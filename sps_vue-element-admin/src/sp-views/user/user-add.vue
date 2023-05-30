<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个用户</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>
        <!-- 表单 -->
        <sa-item v-model="m.username" type="text" name="用户名" br />
        <sa-item v-model="m.password" type="password" name="密码" br />
        <sa-item name="" br class="s-ok">
          <el-button type="primary" icon="el-icon-plus" @click="ok()">保存</el-button>
        </sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'user-add',
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
    sa.ajax('/role/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
        id: 0,
        username: '',
        password: '',
        roleId: 0
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.username, '请输入昵称');
      sa.checkNull(m.password, '请输入密码');

      // 添加
      sa.ajax('/user/add', m, function(res) {
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
