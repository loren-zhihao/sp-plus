<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                						<sa-info name="id，--主键、自增" br>{{m.id}}</sa-info>
        						<sa-info name="admin名称" br>{{m.name}}</sa-info>
        						<sa-info name="头像地址" br>{{m.avatar}}</sa-info>
        						<sa-info name="密码" br>{{m.password}}</sa-info>
        						<sa-info name="明文密码" br>{{m.pw}}</sa-info>
        						<sa-info name="手机号" br>{{m.phone}}</sa-info>
        						<sa-info name="所属角色id" br>{{m.roleId}}</sa-info>
        						<sa-info name="账号状态" br>{{m.status}}</sa-info>
        						<sa-info name="创建自哪个管理员" br>{{m.createByAid}}</sa-info>
        						<sa-info name="创建时间" br>{{m.createTime}}</sa-info>
        						<sa-info name="上次登陆时间" br>{{m.loginTime}}</sa-info>
        						<sa-info name="上次登陆IP" br>{{m.loginIp}}</sa-info>
        						<sa-info name="登陆次数" br>{{m.loginCount}}</sa-info>
        						<sa-info name="会员类型0:普通1:会员" br>{{m.userType}}</sa-info>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'sp-admin-info',
  props: { param: Object },
  data() {
    return {
      id: this.param.id || 0,
      sa: sa,
      m: {}
    }
  },
  created: function() {
    if (this.id == 0 || this.id == sa.$sys.getCurrUser().id) {
      sa.ajax('/spAdmin/getByCurr', function(res) {
        this.m = res.data;
      }.bind(this));
    } else {
      sa.ajax('/spAdmin/getById?id=' + this.id, function(res) {
        this.m = res.data;
      }.bind(this));
    }
  },
  methods: {
  }
}
</script>

<style scoped>
  .vue-box,.c-panel{}
  .c-panel >>> .c-title{margin-bottom: 20px;}
  .c-panel >>> .c-item .c-label{width: 150px;}
  .c-panel >>> .c-item .el-input{width: 300px;}
  /* 链接样式  */
  /*.my-link{position: relative; top: -1px; margin-left: 0.5em;}*/
</style>
