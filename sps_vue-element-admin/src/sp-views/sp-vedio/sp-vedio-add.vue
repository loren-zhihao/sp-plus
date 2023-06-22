<template>
  <!-- 参数栏 -->
  <div class="c-panel">
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px"
  label-position="left">
      <el-col :span="24">
        <el-form-item label="上传视频" prop="url" required>
          <el-upload ref="url" :file-list="urlfileList" :action="urlAction" :before-upload="urlBeforeUpload"
          :on-success="handleSuccess" accept="video/*">
            <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
          </el-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="类型：" prop="type">
          <el-select v-model="formData.type" placeholder="请选择类型：" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in typeOptions" :key="index" :label="item.label" :value="item.value"
              :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item size="large">
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-col>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'sp-vedio-add',
  props: { param: Object },
  data() {
    return {
      id: (this.param && this.param.id) || 0, 	// 超级对象
      formData: this.crateModel(),
      rules: {
        url: [{
          required: true,
          message: '请选择类型：',
          trigger: 'blur'
        }],
        type: [{
          required: true,
          message: '请选择类型：',
          trigger: 'change'
        }],  
      },
      urlAction: process.env.VUE_APP_BASE_API+"/upload/video",
      urlfileList: [],
      typeOptions: [{
        "label": "普通会员",
        "value": 1
      }, {
        "label": "VIP会员",
        "value": 2
      }],
    }
  },
  created: function() {
    // 加载角色
    sa.ajax('/spVedio/getList', function(res) {
      this.roleList = res.data;	// 数据
    }.bind(this), { msg: null });
  },
  methods: {
    crateModel() {
      return {
            "id": 0,
            "url": "",
            "type": "",
            "status": "1",
      }
    },
    // 提交
    submitForm: function(){
      // 表单校验
      let m = this.formData;
      console.log(m);
      // 添加
      sa.ajax('/spVedio/add', m, function(res) {
        sa.alert('添加成功, 账号id为：' + res.data, function(){
          this.m = this.crateModel();
          if (this.id != 0) {
            sa.closeModel();
            sa.currView().f5();
          }
        }.bind(this));
      }.bind(this));
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    urlBeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 500
      if (!isRightSize) {
        this.$message.error('文件大小超过 500MB')
      }
      let isAccept = new RegExp('video/*').test(file.type)
      if (!isAccept) {
        this.$message.error('应该选择video/*类型的文件')
      }
    },
    handleSuccess(response) {
      // 上传成功后的处理逻辑
      // 根据接口返回的数据结构获取视频地址
      const videoUrl = response.data;  // 假设接口返回的数据中包含名为 url 的字段
      console.log('视频地址:', videoUrl);
      this.formData.url = videoUrl; 
    },
  }
}
</script>

<style scoped>
/*.vue-box >>> .c-item .el-input__inner{width: 300px;}*/
.el-upload__tip {
  line-height: 1.2;
}
</style>
