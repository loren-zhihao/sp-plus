<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个商品信息表</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>
          <sa-item type="text" name="商品名称" v-model="m.name" br></sa-item>
          <sa-item name="商品类别" br>
            <el-select v-model="m.type">
              <el-option label="请选择" :value="0" disabled />
              <el-option v-for="typeObj in typeList" :key="typeObj.type" :label="typeObj.name" :value="typeObj.type" />
            </el-select>
          </sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'sp-product-add',
  props: { param: Object },
  data() {
    return {
      id: (this.param && this.param.id) || 0, 	// 超级对象
      m: this.crateModel(),
      roleList: [],
      typeList: [
        {type: 1, name: "包天"},
        {type: 2, name: "包月"},
        {type: 3, name: "3个月"},
        {type: 4, name: "包季度"},
        {type: 5, name: "包年"},
        {type: 6, name: "永久"}
      ]
    }
  },
  created: function() {
    // 加载角色
    sa.ajax('/spProduct/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
            "id": 0,
            "name": "",
            "type": "",
            "createTime": "",
            "createBy": "",
            "updateTime": "",
            "updateBy": "",
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.name, '请输入昵称');

      // 添加
      sa.ajax('/spProduct/add', m, function(res) {
        sa.alert('添加成功, 账号id为：' + res.data, function(){
          this.m = this.crateModel();
          if (this.id != 0) {
            sa.closeModel();
            sa.currView().f5();
          }
        }.bind(this));
      }.bind(this));
    }
  }
}
</script>

<style scoped>
/*.vue-box >>> .c-item .el-input__inner{width: 300px;}*/
</style>
