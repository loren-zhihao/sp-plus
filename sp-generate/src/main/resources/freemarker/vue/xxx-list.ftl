<template>
  <div class="vue-box">
    <div class="c-panel">
      <!-- ------------- 检索参数 ------------- -->
      <h4 class="c-title">检索参数</h4>
      <el-form>
        <sa-item v-model="p.name" type="text" name="名称" />
        <el-button type="primary" icon="el-icon-search" @click="p.pageNo = 1; f5()">查询</el-button>
        <br>
        <sa-item name="综合排序" class="s-radio-text">
          <el-radio-group v-model="p.sortType">
            <el-radio label="id">最近添加</el-radio>
            <el-radio label="loginTime">最近登录</el-radio>
            <el-radio label="loginCount">登录次数</el-radio>
          </el-radio-group>
        </sa-item>
      </el-form>
      <!-- ------------- 快捷按钮 ------------- -->
      <sa-item type="fast-btn" show="add,get,delete,export,reset" />
      <!-- ------------- 数据列表 ------------- -->
      <el-table ref="data-table" class="data-table" :data="dataList">
        <sa-td type="selection"></sa-td>
        <#list t.tallList as c>
        	<#if c.istx('no-show')>
        	<#elseif c.foType == 'logic-delete'>
        	<#elseif c.istx('click')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="link-btn" @click="s => sa.showIframe(' id = ' + s.row.${c.getClickCatKeyColumn()} + '  详细信息', '../${c.getClickCatTableKebabName()}/${c.getClickCatTableKebabName()}-info.html?id=' + s.row.${c.getClickCatKeyColumn()})">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.istx('switch')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="switch" :jv="${c.getJvJson()}" @change="s => update${c.fieldNameFnCat}(s.row)">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.istx('fast-update')>
                <el-table-column label="${c.columnComment3}">
                    <template slot-scope="s">
                        <span>{{s.row.${c.fieldName}}}</span>
                        <el-button type="text" @click="update${c.fieldNameFnCat}(s.row)">改</el-button>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('text', 'fk-s', 'fk-p')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" >
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('textarea')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="textarea">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('num')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="num">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.foType == 'richtext'>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="richtext">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('date', 'date-create', 'date-update')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="datetime">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('time')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" class-name="tc-date">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.foType == 'img'>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="img"></el-table-column>
        	<#elseif c.isFoType('audio', 'video', 'file')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="${c.foType}">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.foType == 'img-list'>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="img-list">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.isFoType('audio-list', 'video-list', 'file-list', 'img-video-list')>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="${c.foType}">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.foType == 'link'>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="link">
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	<#elseif c.foType == 'enum'>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" type="enum" :jv="${c.getJvJson()}"></el-table-column>
        	<#else>
                <el-table-column label="${c.columnComment3}" prop="${c.fieldName}" >
                    <template slot-scope="s">
                      <el-input v-if="s.row.is_update" v-model="s.row.${c.fieldName}" />
                      <span v-else>{{ s.row.${c.fieldName}}}</span>
                    </template>
                </el-table-column>
        	</#if>
        </#list>
            <el-table-column label="操作" fixed="right" <#if t.hasFt('tree', 'tree-lazy')> width="320px"<#else> width="240px"</#if>>
                <template slot-scope="s">
                    <el-button class="c-btn" type="success" icon="el-icon-view" @click="get(s.row)">查看</el-button>
                    <el-button class="c-btn" type="primary" icon="el-icon-edit" @click="update(s.row)">修改</el-button>
        <#if t.hasFt('tree', 'tree-lazy')>
                    <   el-button class="c-btn" type="primary" icon="el-icon-plus" @click="addChildren(s.row)">添加子级</el-button>
        </#if>
                    <el-button class="c-btn" type="danger" icon="el-icon-delete" @click="del(s.row)">删除</el-button>
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
        name: '',
        pageNo: 1,
        pageSize: 10,
      },
      dataCount: 0,
      dataList: [],	// 数据集合
      roleList: [],	// 角色集合
    }
  },
  created: function() {
    this.f5();
    sa.onInputEnter();	// 监听回车执行查询
  },
  methods: {

    // 刷新
    f5: function() {
      sa.ajax('/${t.varName}/getList', this.p, function(res) {
        this.dataList = sa.listAU(res.data);
        sa.f5TableHeight();		// 刷新表格高度
      }.bind(this));
    },
    // 新增
    add: function() {
      console.log(123);
      sa.showModel('管理员添加', () => import('./${t.kebabName}-add'), { id: -1 });
    },
    // 查看详情
    getInfo: function(data) {
      sa.showModel('管理员详情', () => import('./${t.kebabName}-info'), { id: data.id });
    },
    // 查看 - 根据选中的
    getBySelect: function(data) {
      var selection = this.$refs['data-table'].selection;
      if (selection.length === 0) {
        return sa.msg('请至少选择一条数据')
      }
      this.getInfo(selection[0]);
    },
    // 修改名称
    update: function(data) {
          console.log(JSON.stringify(data));
          if (data.is_update == false || data.is_update == 'undefined') {
            data.is_update = true;
          } else {
            sa.confirm('是否修改数据？', function() {
              sa.ajax('/${t.varName}/update', data, function(res) {
                sa.ok('修改成功');
                data.is_update = false;
              })
            })
          }
        },
    // 修改用户的状态
    updateStatus: function(data) {
      if (data.id == sa.$sys.getCurrUser().id) {
        data.status = 3 - data.status;
        return sa.alert('不能自己封禁自己');
      }
      var is_ok = false;	// 记录是否成功
      var ajax = sa.ajax('/${t.varName}/updateStatus', { adminId: data.id, status: data.status }, function(res) {
        sa.msg('修改成功');
        is_ok = true;
      });
      // 如果未能修改成功, 则回滚
      sa.axios.all([ajax]).then(function(res) {
        if (is_ok == false) {
          data.status = 3 - data.status;
        }
      })
      // $.when(ajax).done(function() {
      //   if(is_ok == false) {
      //     data.status = 3 - data.status;
      //   }
      // })
    },
    // 删除
    del: function(data) {
      sa.confirm('是否删除，此操作不可撤销', function(){
        sa.ajax('/${t.varName}/delete', { id: data.id }, function(res){
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
        sa.ajax('/${t.varName}/deleteByIds', { ids: ids.join(',') }, function(res) {
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

</style>
