<template>
  <div class="vue-box">
    <div class="c-panel">
      <!-- ------------- 检索参数 ------------- -->
      <h4 class="c-title">检索参数</h4>
      <el-form>
        <el-form-item v-model="p.type" prop="type" label="类型" >
          <el-select v-model="p.type" placeholder="请选择类型：" clearable >
            <el-option v-for="(item, index) in typeOptions" :key="index" :label="item.label" :value="item.value"
              :disabled="item.disabled"></el-option>
          </el-select>
          <el-button type="primary" icon="el-icon-search" @click="p.pageNo = 1; f5()">查询</el-button>
        </el-form-item>
        <br>
      </el-form>
      <!-- ------------- 快捷按钮 ------------- -->
      <sa-item type="fast-btn" show="add,export,reset" />
      <!-- ------------- 数据列表 ------------- -->
      <el-table ref="data-table" class="data-table" :data="dataList">
        <sa-td type="selection"></sa-td>
        <el-table-column label="主键id" prop="id" ></el-table-column>
        <el-table-column label="地址" prop="url">
          <template slot-scope="scope">
            <a :href="scope.row.url" class="custom-link" target="_blank">{{ scope.row.url }}</a>
          </template>
        </el-table-column>
        <el-table-column label="类型">
          <template slot-scope="s">
            <el-select v-model="s.row.typeName"  placeholder="请选择类型：">
              <el-option v-for="(item, index) in typeOptions" :key="index" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </template>
        </el-table-column>
        <el-table-column label="状态" prop="statusName" ></el-table-column>
        <el-table-column label="操作" fixed="right"  width="240px">
          <template slot-scope="s">
            <el-button type="text" @click="update(s.row)">
              <span>修改</span>
            </el-button>
            <el-button class="c-btn" type="danger" icon="el-icon-edit-outline" @click="updateStatus(s.row)">
              <span v-if="s.row.status === '1'">下架</span>
              <span v-else="s.row.status === '2'">上架</span>
            </el-button>
          </template>
        </el-table-column>
     </el-table>
      <!-- 分页 -->
      <sa-item type="page" :curr.sync="p.pageNo" :size.sync="p.pageSize" :total="dataCount" @change="f5()" />
    </div>

  </div>
</template>

<script>
export default {
  name: 'admin-list',
  data() {
    return {
      p: {		// 查询参数
        id: '',
        type:"",
        pageNo: 1,
        pageSize: 10,
      },
      typeOptions: [{
        "label": "普通会员",
        "value": 1
      }, {
        "label": "VIP会员",
        "value": 2
      }],
      dataCount: 0,
      dataList: [],	// 数据集合
    }
  },
  created: function() {
    this.f5();
    sa.onInputEnter();	// 监听回车执行查询
    // 加载角色
    sa.ajax('/spVedio/getList', function(res){
      this.dataList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    // 刷新
    f5: function() {
      sa.ajax('/spVedio/getList', this.p, (res) => {
        this.dataList = sa.listAU(res.data);
        sa.f5TableHeight(); // 刷新表格高度
      });
    },
    // 新增
    add: function() {
      console.log(123);
      sa.showModel('管理员添加', () => import('./sp-vedio-add'), { id: -1 });
    },
    // 查看 - 根据选中的
    getBySelect: function(data) {
      var selection = this.$refs['data-table'].selection;
      if (selection.length === 0) {
        return sa.msg('请至少选择一条数据')
      }
      this.getInfo(selection[0]);
    },
    update: function(data) {
      console.log(JSON.stringify(data));
      console.log(JSON.stringify(this.typeOptions));
      this.typeOptions.forEach(e =>{
        if(e.value === data.typeName){
          data.type = e.value;
        }
      });
      sa.confirm('是否修改数据？', () => {
        sa.ajax('/spVedio/update', data, (res) => {
          sa.msg('修改成功');
          this.$nextTick(() => {
            data.is_update = false;
          });
        });
      });
    },
    refreshData() {
      // 调用列表查询方法来刷新数据
      this.f5();
    },
    // 修改用户的状态
    updateStatus: function(data) {
      console.log("当前状态为:"+data.status);
      var status = typeof(3 - data.status)!== 'undefined'? 3 - data.status : data.status; // 反转数据状态 1正常 2禁用 3
      var statusName = (status === 1 ? "上架" : "下架");
      var is_ok = false;	// 记录是否成功
      sa.confirm('是否'+statusName+"?", function(){
        var ajax = sa.ajax('/spVedio/updateStatus', { id: data.id, status: status }, function(res) {
          sa.msg(statusName+'成功');
          is_ok = true;
          this.refreshData(); // 重新刷新数据页面。。。。。。。。。。。。。。。。
          sa.f5TableHeight();
        }.bind(this));
      }.bind(this));
      // $.when(ajax).done(function() {
      //   if(is_ok == false) {
      //     data.status = 3 - data.status;
      //   }
      // })
    },
    // 删除
    del: function(data) {
      sa.confirm('是否删除，此操作不可撤销', function(){
        sa.ajax('/spVedio/delete', { id: data.id }, function(res){
          sa.arrayDelete(this.dataList, data);
          sa.ok('删除成功');
          sa.f5TableHeight();		// 刷新表格高度
        }.bind(this))
      }.bind(this));
    },
    // 批量删除
    deleteByIds: function() {
      // 获取选中元素的id列表
      let selection = this.$refs['data-table'].selection;
      let ids = sa.getArrayField(selection, 'id');
      if (selection.length == 0) {
        return sa.msg('请至少选择一条数据')
      }
      // 提交删除
      sa.confirm('是否批量删除选中数据？此操作不可撤销', function() {
        sa.ajax('/spVedio/deleteByIds', { ids: ids.join(',') }, function(res) {
          sa.arrayDelete(this.dataList, selection);
          sa.ok('删除成功');
          sa.f5TableHeight();		// 刷新表格高度
        }.bind(this))
      }.bind(this));
    },
  }
}
</script>

<style scoped>
  .custom-link {
    color: blue; /* 设置超链接的背景颜色为黄色 */
    /* 其他样式设置 */
  }
</style>
