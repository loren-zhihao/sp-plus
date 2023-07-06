<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
                						<sa-info name="主键id" br>{{m.id}}</sa-info>
        						<sa-info name="订单编号" br>{{m.code}}</sa-info>
        						<sa-info name="支付方式1：支付宝2:微信3:其他" br>{{m.payType}}</sa-info>
        						<sa-info name="支付金额" br>{{m.payAmount}}</sa-info>
        						<sa-info name="订单来源1:注册2:分享" br>{{m.orderSource}}</sa-info>
        						<sa-info name="付款人" br>{{m.drawee}}</sa-info>
        						<sa-info name="订单支付时间" br>{{m.orderPayTime}}</sa-info>
        						<sa-info name="订单编号" br>{{m.orderCode}}</sa-info>
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
  name: 'sp-order-info',
  props: { param: Object },
  data() {
    return {
      id: this.param.id || 0,
      sa: sa,
      m: {}
    }
  },
  created: function() {
    sa.ajax('/spOrder/getById?id=' + this.id, function(res) {
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
