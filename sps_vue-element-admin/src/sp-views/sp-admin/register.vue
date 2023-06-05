<template>
  <div class="view-box">
    <!--背景盒子-->
    <div class="bg-fox">
      <img src="https://oss.dev33.cn/sa-plus/temp/login-sc4.png" style="position: absolute; bottom: 8vh; left: 8vw; width: 450px;">
      <div style="width: 100%; height: 100%">
        <!-- 三角形-->
        <div class="sjx" style="position: absolute; top: 0vh; left: 25vw; transform: rotate(70deg) scale(0.8, 0.8);" />
        <div class="sjx" style="position: absolute; top: 0vh; right: 15vw; transform: rotate(60deg) scale(0.5, 0.5);" />
        <div class="sjx" style="position: absolute; top: 25vh; right: -2vw; transform: rotate(40deg);" />
        <div class="sjx" style="position: absolute; bottom: 10vh; right: 20vw; transform: rotate(10deg) scale(1.5, 1.5);" />
      </div>
    </div>
    <!--内容盒子-->
    <div class="for-box">
      <div class="login-box">
        <div class="login-box-2">
          <!-- 表单盒子 -->
          <div class="from-box" :class="{'from-box-show': show}">
            <h3 class="from-title">
              <img src="@/assets/logo.png" class="logo">
              <span>{{$root.title}}</span>
            </h3>
            <el-button class="back-button" @click="goBack()">
              <i class="el-icon-arrow-left">返回</i>
            </el-button> 
            <!-- 其他注册页面内容 -->
            <el-form size="small" label-position="left" label-width="0px">
              <el-form-item>
                <el-input v-model="m.name" prefix-icon="el-icon-user" placeholder="请输入账号" size="medium" />
              </el-form-item>
              <el-form-item>
                <el-input v-model="m.phone" prefix-icon="el-icon-user" placeholder="请输入手机号" size="medium" />
              </el-form-item>
              <el-form-item>
                <el-input v-model="m.password" prefix-icon="el-icon-unlock" type="password" placeholder="请输入密码" size="medium" @keyup.native.enter="ok()" />
              </el-form-item>
              <el-form-item>
                <el-button type="primary" size="medium" style="width: 100%;" @click="ok()">注册</el-button>
              </el-form-item>
              <el-form-item>
                <el-button type="Default" size="medium" style="width: 100%;" @click="login()">登录</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import store from '@/store'
import router from '@/router'
import sa from "@/sa-frame/sa";

export default {
  name: 'register',
  data() {
    return {
      show: false, // 是否显示
      m: {
        id: 0,
        name: '',
        phone: '',
        password: ''
      }
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        const query = route.query
        if (query) {
          this.redirect = query.redirect
          this.otherQuery = this.getOtherQuery(query)
        }
      },
      immediate: true
    }
  },
  mounted() {
    setTimeout(function(){
      this.show = true;
    }.bind(this), 0);
  },
  methods: {
    ok() {
      // 表单验证
      if (this.m.name === '' || this.m.phone === '' || this.m.password === '') {
        return this.sa.error2('请输入完整');
      }
      // 请求后台
      this.sa.ajax('/admin/register', this.m, function(res){
        // 写入token
        // this.sa.alert('注册成功');
        // 这里可以将用户输入的账号密码等信息提交到服务器进行注册处理
        setTimeout(function() {
          // this.$router.push('/');
          this.$router.push({ path: this.redirect || '/login', query: this.otherQuery })
        }.bind(this), 800);
     }.bind(this));
    },
    login(){
      this.$router.push('/login');
    },
     // 返回上一页
    goBack() {
      this.$router.push('/login');
    }
 }
}
</script>


<style scoped>
/* 视图盒子 */
.view-box{}

/*  */
.bg-fox {
  position: fixed;
  width: 100%;
  height: 100%;
  /*background-color: #fafeff;*/
  /*background-color: #f8f8ff;*/
  background-color: rgb(250, 254, 255);
  pointer-events: none;
}
.for-box{
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: 10;
  display: flex;
  align-items: center;
}

.login-box{
  flex: 1;
}
.login-box-2{
  width: 450px;
  max-width: 90vw;
  margin: auto;
  padding-bottom: 100px;
}
.back-button {
  position: absolute;
  top: 10px;
  left: 10px;
  font-size: 18px;
  color: #333;
  text-decoration: none;
  cursor: pointer;
}
/* 表单 */
.from-box{padding: 45px 50px 25px; background-color: rgba(255,255,255,0.5); border: 1px #e5e5e5 solid;}
.from-box{ border-radius: 1px; /*box-shadow: 1px 1px 2px #666;*/;position: relative;}
.from-title{font-size: 24px; color: #000; margin-bottom: 30px; text-align: center; position: relative; left: -15px;}

.logo{width: 50px; height: 50px; vertical-align: middle; margin-right: 15px;}

/*动画*/
.bg-fox>div{animation: changes 30s 0.2s linear infinite alternate; }  /* normal | alternate */
@keyframes changes {
  from {transform: translate(0, 0vh);}
  to {transform: translate(0, 15vh);}
}

.sjx {
  width: 0;
  height: 0;
  border-left: 100px solid transparent;
  border-right: 100px solid transparent;
  border-bottom: 180px solid #dee7f8;
}

/* 2px圆角 */
.view-box >>> .el-input__inner,
.view-box >>> .el-button{border-radius: 2px !important;}

/* 渐渐显示的动画 */
.from-box{
  opacity: 0;
  transition: opacity 1s;
}
.from-box-show{
  opacity: 1;
}

</style>
