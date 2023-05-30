<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个密码表</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>

        						<sa-item type="text" name="主键id" v-model="m.id" br></sa-item>
        						<sa-item type="text" name="所属用户ID" v-model="m.userId" br></sa-item>
        						<sa-item type="text" name="密码分类ID" v-model="m.categoryId" br></sa-item>
        						<sa-item type="text" name="密码标题" v-model="m.title" br></sa-item>
        						<sa-item type="text" name="账号" v-model="m.account" br></sa-item>
        						<sa-item type="text" name="密码" v-model="m.password" br></sa-item>
        						<sa-item type="text" name="登录地址" v-model="m.url" br></sa-item>
        						<sa-item type="text" name="备注" v-model="m.notes" br></sa-item>
        						<sa-item type="text" name="创建人" v-model="m.createBy" br></sa-item>
        						<sa-item type="text" name="创建时间" v-model="m.createTime" br></sa-item>
        						<sa-item type="text" name="更新人" v-model="m.updateBy" br></sa-item>
        						<sa-item type="text" name="更新时间" v-model="m.updateTime" br></sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'password-add',
  props: { param: Object },
  data() {
    return {
      id: (this.param && this.param.id) || 0, 	// 超级对象
      m: this.crateModel(),
      roleList: []
    }
  },
  created: function() {
    // 加载角色
    sa.ajax('/password/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
            主键id: 0,
            所属用户ID: 0,
            密码分类ID: 0,
            密码标题: "",
            账号: "",
            密码: "",
            登录地址: "",
            备注: "",
            创建人: "",
            创建时间: "",
            更新人: "",
            更新时间: "",
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.name, '请输入昵称');

      // 添加
      sa.ajax('/password/add', m, function(res) {
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
