<template>
  <div class="vue-box sbot" style="width: 600px;">
    <!-- ------- 内容部分 ------- -->
    <div class="c-panel">
      <el-form v-if="m">
        <#list t.tallList as c>
        	<#if c.istx('no-show')>
        	<#elseif c.foType == 'logic-delete'>
        	<#elseif c.foType == 'text'>
        						<sa-info name="${c.columnComment3}" br>{{m.${c.fieldName}}}</sa-info>
        	<#elseif c.foType == 'num'>
        						<sa-info type="num" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.foType == 'textarea'>
        						<sa-info type="textarea" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.foType == 'richtext'>
        						<sa-info type="richtext" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.foType == 'enum'>
        						<sa-info type="enum" name="${c.columnComment3}" :value="m.${c.fieldName}" :jv="${c.getJvJson()}" br></sa-info>
        	<#elseif c.foType == 'img'>
        						<sa-info type="img" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.isFoType('audio', 'video', 'file')>
        						<sa-info type="${c.foType}" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.foType == 'img-list'>
        						<sa-info type="img-list" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.isFoType('audio-list', 'video-list', 'file-list', 'img-video-list')>
        						<sa-info type="${c.foType}" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.isFoType('date', 'date-create', 'date-update')>
        						<sa-info type="datetime" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.isFoType('time')>
        						<sa-info type="time" name="${c.columnComment3}" :value="m.${c.fieldName}" br></sa-info>
        	<#elseif c.foType == 'fk-1' || c.foType == 'fk-2'>
        					<#if c.isTx('showfk')>
        						<sa-info name="${c.columnComment3}">{{m.${c.fieldName}}}</sa-info>
        					</#if>
        					<#list c.fkPkConcatList as fk>
        						<sa-info name="${fk.fkPkConcatComment}">{{m.${fk.fieldName}}}</sa-info>
        					</#list>
        	<#else>
        						<sa-info name="${c.columnComment3}" br>{{m.${c.fieldName}}}</sa-info>
        	</#if>
        </#list>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: '${t.getKebabName()}-info',
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
      sa.ajax('/${t.getKebabName()}/getByCurr', function(res) {
        this.m = res.data;
      }.bind(this));
    } else {
      sa.ajax('/${t.getKebabName()}/getById?id=' + this.id, function(res) {
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
