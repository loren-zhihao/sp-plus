<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                						<sa-info name="主键id" br>{{m.id}}</sa-info>
        						<sa-info name="类型如1：系统2：其他，用户可以自定义" br>{{m.type}}</sa-info>
        						<sa-info name="类型说明" br>{{m.name}}</sa-info>
        						<sa-info name="创建时间" br>{{m.createTime}}</sa-info>
        						<sa-info name="创建人" br>{{m.createBy}}</sa-info>
        						<sa-info name="更新时间" br>{{m.updateTime}}</sa-info>
        						<sa-info name="更新人" br>{{m.updateBy}}</sa-info>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'sp-semic-type-info',
  props: { param: Object },
  data() {
    return {
      id: this.param.id || 0,
      sa: sa,
      m: {}
    }
  },
  created: function() {
    sa.ajax('/spSemicType/getById?id=' + this.id, function(res) {
            this.m = res.data;
          }.bind(this));
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
