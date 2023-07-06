<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个半导体词典表的子集信息</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>

        						<sa-item type="text" name="主键id" v-model="m.id" br></sa-item>
        						<sa-item type="text" name="关联类型表id" v-model="m.semicDictionaryId" br></sa-item>
        						<sa-item type="text" name="英文简写" v-model="m.abbreviation" br></sa-item>
        						<sa-item type="text" name="描述" v-model="m.description" br></sa-item>
        						<sa-item type="text" name="创建时间" v-model="m.createTime" br></sa-item>
        						<sa-item type="text" name="创建人" v-model="m.createBy" br></sa-item>
        						<sa-item type="text" name="更新人" v-model="m.updateTime" br></sa-item>
        						<sa-item type="text" name="更新人" v-model="m.updateBy" br></sa-item>
        						<sa-item type="text" name="英文全称" v-model="m.fullName" br></sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'sp-semic-child-dictionary-add',
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
    sa.ajax('/spSemicChildDictionary/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
            "id": "",
            "semicDictionaryId": "",
            "abbreviation": "",
            "description": "",
            "createTime": "",
            "createBy": "",
            "updateTime": "",
            "updateBy": "",
            "fullName": "",
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      sa.checkNull(m.name, '请输入昵称');

      // 添加
      sa.ajax('/spSemicChildDictionary/add', m, function(res) {
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
