<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                						<sa-info name="主键id" br>{{m.id}}</sa-info>
        						<sa-info name="关联类型表id" br>{{m.semicTypeId}}</sa-info>
        						<sa-info name="英文全称" br>{{m.fullName}}</sa-info>
        						<sa-info name="英文简写" br>{{m.abbreviation}}</sa-info>
        						<sa-info name="描述" br>{{m.description}}</sa-info>
        						<sa-info name="创建时间" br>{{m.createTime}}</sa-info>
        						<sa-info name="创建人" br>{{m.createBy}}</sa-info>
        						<sa-info name="更新人" br>{{m.updateTime}}</sa-info>
        						<sa-info name="更新人" br>{{m.updateBy}}</sa-info>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'sp-semic-dictionary-info',
  props: { param: Object },
  data() {
    return {
      id: this.param.id || 0,
      sa: sa,
      m: {}
    }
  },
  created: function() {
    sa.ajax('/spSemicDictionary/getById?id=' + this.id, function(res) {
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
