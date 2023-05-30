<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                		<sa-info name="主键id" br>{{m.id}}</sa-info>
        						<sa-info name="所属用户ID" br>{{m.userId}}</sa-info>
        						<sa-info name="密码分类ID" br>{{m.categoryId}}</sa-info>
        						<sa-info name="密码标题" br>{{m.title}}</sa-info>
        						<sa-info name="账号" br>{{m.account}}</sa-info>
        						<sa-info name="密码" br>{{m.password}}</sa-info>
        						<sa-info name="登录地址" br>{{m.url}}</sa-info>
        						<sa-info name="备注" br>{{m.notes}}</sa-info>
        						<sa-info name="创建人" br>{{m.createBy}}</sa-info>
        						<sa-info name="创建时间" br>{{m.createTime}}</sa-info>
        						<sa-info name="更新人" br>{{m.updateBy}}</sa-info>
        						<sa-info name="更新时间" br>{{m.updateTime}}</sa-info>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'password-info',
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
      sa.ajax('/password/getByCurr', function(res) {
        this.m = res.data;
      }.bind(this));
    } else {
      sa.ajax('/password/getById?id=' + this.id, function(res) {
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
