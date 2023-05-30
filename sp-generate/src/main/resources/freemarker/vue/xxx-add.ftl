<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个${t.tableComment}</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>

        <#list t.t12List as c>
        	<#if c.istx('no-add')>
        	<#elseif c.foType == 'logic-delete'>
        	<#elseif c.getFlag() == 'tree-parent-id'>
        						<sa-item type="text" name="${c.columnComment3}" v-model="m.${c.fieldName}" v-if="sa.p('${t.getTreeFkey()}', 'nof') == 'nof'" br></sa-item>
        	<#elseif c.foType == 'text'>
        						<sa-item type="text" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'num'>
        						<sa-item type="num" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'textarea'>
        						<sa-item type="textarea" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'richtext'>
        						<sa-item type="richtext" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'enum'>
        						<sa-item type="enum" name="${c.columnComment3}" v-model="m.${c.fieldName}" :jv="${c.getJvJson()}" jtype="${c.gtx('a-type')}" br></sa-item>
        	<#elseif c.foType == 'img'>
        						<sa-item type="img" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'audio'>
        						<sa-item type="audio" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'video'>
        						<sa-item type="video" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'file'>
        						<sa-item type="file" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'img-list'>
        						<sa-item type="img-list" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.isFoType('audio-list', 'video-list', 'file-list', 'img-video-list')>
        						<sa-item type="${c.foType}" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'date'>
        						<sa-item type="datetime" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.isFoType('date-create', 'date-update')>
        						<!-- ${c.foType}字段： m.${c.fieldName} - ${c.columnComment3} -->
        	<#elseif c.foType == 'time'>
        						<sa-item type="time" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	<#elseif c.foType == 'fk-s'>
        				<#if c.istx('drop')>
        						<sa-item name="${c.columnComment3}" br>
        							<el-select v-model="m.${c.fkSCurrDc.fieldName}">
        								<el-option label="请选择" value="" disabled></el-option>
        								<el-option v-for="item in ${c.fieldName}List" :label="item.${c.tx.catc}" :value="item.${c.tx.jc}" :key="item.${c.tx.jc}"></el-option>
        							</el-select>
        						</sa-item>
        				</#if>
        	<#elseif c.foType == 'no'>
        						<!-- no字段： m.${c.fieldName} - ${c.columnComment3} -->
        	<#else>
        						<sa-item type="text" name="${c.columnComment3}" v-model="m.${c.fieldName}" br></sa-item>
        	</#if>
        </#list>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: '${t.getKebabName()}-add',
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
    sa.ajax('/${t.getKebabName()}/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
      <#list t.t12List as c>
          <#if c.columnType == 'bigint'>
            ${c.columnComment3}: 0,
          <#elseif c.foType == 'text'>
            ${c.columnComment3}: "",
          <#else>
            ${c.columnComment3}: ""
          </#if>
      </#list>
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.name, '请输入昵称');

      // 添加
      sa.ajax('/${t.getKebabName()}/add', m, function(res) {
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
