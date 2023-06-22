<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个系统管理员表</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>

        						<sa-item type="text" name="id，--主键、自增" v-model="m.id" br></sa-item>
        						<sa-item type="text" name="admin名称" v-model="m.name" br></sa-item>
        						<sa-item type="text" name="头像地址" v-model="m.avatar" br></sa-item>
        						<sa-item type="text" name="密码" v-model="m.password" br></sa-item>
        						<sa-item type="text" name="明文密码" v-model="m.pw" br></sa-item>
        						<sa-item type="text" name="手机号" v-model="m.phone" br></sa-item>
        						<sa-item type="text" name="所属角色id" v-model="m.roleId" br></sa-item>
        						<sa-item type="text" name="账号状态" v-model="m.status" br></sa-item>
        						<sa-item type="text" name="创建自哪个管理员" v-model="m.createByAid" br></sa-item>
        						<sa-item type="text" name="创建时间" v-model="m.createTime" br></sa-item>
        						<sa-item type="text" name="上次登陆时间" v-model="m.loginTime" br></sa-item>
        						<sa-item type="text" name="上次登陆IP" v-model="m.loginIp" br></sa-item>
        						<sa-item type="text" name="登陆次数" v-model="m.loginCount" br></sa-item>
        						<sa-item type="text" name="会员类型0:普通1:会员" v-model="m.userType" br></sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'sp-admin-add',
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
    sa.ajax('/spAdmin/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
            "id": 0,
            "name": "",
            "avatar": "",
            "password": "",
            "pw": "",
            "phone": "",
            "roleId": 0,
            "status": "",
            "createByAid": 0,
            "createTime": "",
            "loginTime": "",
            "loginIp": "",
            "loginCount": "",
            "userType": "",
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.name, '请输入昵称');

      // 添加
      sa.ajax('/spAdmin/add', m, function(res) {
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
