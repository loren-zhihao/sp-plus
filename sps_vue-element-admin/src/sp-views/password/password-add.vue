<template>
  <div class="vue-box" :class="id != 0 ? 'sbot sbot-fluid': null">
    <!-- 参数栏 -->
    <div class="c-panel">
      <h4 class="c-title">添加一个账号密码信息</h4>
      <el-form>
        <!-- 防止密码框被填充 -->
        <div style="height: 0px; overflow: hidden;">
          <el-input />
          <el-input type="password" />
        </div>
          <sa-item name="账号分类" br>
            <el-select v-model="m.categoryId">
              <el-option label="请选择" :value="0" disabled />
              <el-option v-for="category in categoryList" :key="category.id" :label="category.name" :value="category.id" />
            </el-select>
          </sa-item>
          <sa-item type="text" name="标题" v-model="m.title" br></sa-item>
          <sa-item type="text" name="账号" v-model="m.account" br></sa-item>
          <sa-item type="text" name="密码" v-model="m.password" br></sa-item>
          <sa-item type="text" name="地址" v-model="m.url" br></sa-item>
          <sa-item type="text" name="备注" v-model="m.notes" br></sa-item>
          <sa-item name="" br class="s-ok">
            <el-button type="primary" icon="el-icon-plus" @click="ok()">保存</el-button>
          </sa-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'password-add',
  props: { param: Object },
  data() {
    return {
      id: (this.param && this.param.id) || 0, 	// 超级对象
      m: this.crateModel(),
      categoryList: []
    }
  },
  created: function() {
    // 加载分类
    sa.ajax('/category/getList', function(res) {
      this.categoryList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
        id: 0,
        userId: 0,
        categoryId: 0,
        title: "",
        account: "",
        password: "",
        url: "",
        notes: "",
      }
    },
    // 修改
    ok: function(){
      // 表单校验
      let m = this.m;
      console.log(JSON.stringify(m));
      if (m.categoryId == null || m.categoryId == 0 || m.categoryId == 'undefined') {
        return sa.alert('请选择分类');
      }
      sa.checkNull(m.title, '请输入标题');
      sa.checkNull(m.account, '请输入账号');
      // sa.checkNull(m.password, '请输入密码');
      sa.checkNull(m.url, '请输入地址');

      // 添加
      sa.ajax('/password/add', m, function(res) {
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
