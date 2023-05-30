<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                						<sa-info name="主键id" br>{{m.id}}</sa-info>
        						<sa-info name="分类名称" br>{{m.name}}</sa-info>
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
  name: 'category-info',
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
      sa.ajax('/category/getByCurr', function(res) {
        this.m = res.data;
      }.bind(this));
    } else {
      sa.ajax('/category/getById?id=' + this.id, function(res) {
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
