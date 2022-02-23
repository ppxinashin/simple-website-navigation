<template>

  <el-header >
    <el-row :gutter="0">

      <el-col span="4" push="1">
        <el-breadcrumb>
          <el-breadcrumb-item >
            <el-button type="text"
                       @click.native="loginBox = true"
                       :disabled="usingState">{{userName}}</el-button>
          </el-breadcrumb-item>
          <el-breadcrumb-item >
            <el-button type="text"
                       @click.native="transferPress()">{{regiest}}</el-button>
          </el-breadcrumb-item>
          <el-breadcrumb-item >
            <el-button type="text"
                       @click.native="reactBox = true">{{reaction}}</el-button>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>
      <el-col span="3" push="15">
        <iframe width="300" height="30" frameborder="0" scrolling="no" hspace="0" src="https://i.tianqi.com/?c=code&a=getcode&id=34"></iframe>
      </el-col>
    </el-row>
    <el-dialog
        title="登录"
        :visible.sync="loginBox"
        width="50%">
      <span><el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="用户名" v-model="userNameInput"></el-input>
          <el-input placeholder="密码" :show-password="true" v-model="passwd"></el-input>
        </el-col>
      </el-row></span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelLoginBox()">取 消</el-button>
    <el-button type="primary" @click="okLoginBox()">登 录</el-button>
  </span>
    </el-dialog>
    <el-dialog
        title="注册"
        :visible.sync="regionBox"
        width="50%">
      <span><el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="用户名" v-model="userNameInput"></el-input>
          <el-input placeholder="密码" :show-password="true" v-model="passwd"></el-input>
          <el-input placeholder="电话" v-model="userPhone"></el-input>
          <el-input placeholder="个性签名" v-model="motto"></el-input>
        </el-col>
      </el-row></span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelRegionBox()">取 消</el-button>
    <el-button type="primary" @click="okRegionBox">注 册</el-button>
  </span>
    </el-dialog>
    <el-dialog
        title="反馈"
        :visible.sync="reactBox"
        width="50%">
      <span><el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="标题" v-model="title"/>
          <el-input placeholder="反馈信息" type="textarea" v-model="mark"/>
        </el-col>
      </el-row></span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelReactBox">取 消</el-button>
    <el-button type="primary" @click="okReactBox">提 交</el-button>
  </span>
    </el-dialog>


  </el-header>
</template>

<script>

export default {
  name: "Header",
  data(){
    return{
      usingState:sessionStorage.getItem('userName') !== null,
      userName:sessionStorage.getItem('userName') !== null? sessionStorage.getItem('userName'):'登录',
      title:'',
      mark:'',
      userNameInput:"",
      userStatic:false,
      passwd:"",
      userPhone:"",
      motto:'',
      regiest:sessionStorage.getItem('userName') !== null? '退出':'注册',
      reaction:"反馈",
      loginBox:false,
      regionBox:false,
      reactBox:false
    }
  },
  methods:{
    cancelLoginBox(){
      this.loginBox = false
    },
    okLoginBox(){
      this.$axios(
          {
            method:"post",
            url:"http://localhost:8080/user/login",
            data:{
              userName: this.userNameInput,
              userPassword: this.passwd
            },
            timeout:1000,
          }
        ).then(res => {
        this.userStatic = res.data.success;
        if (this.userStatic === true && this.userStatic !== null){
          this.usingState = true;
          sessionStorage.setItem('userName',res.data.detail.userName);
          sessionStorage.setItem('userId',res.data.detail.id);
          this.userName = res.data.detail.userName;
          this.regiest = '退出'
          this.$message({
            showClose: true,
            message: `欢迎！${this.userName}`,
            type: 'success'
          });
        } else {
          this.$message({
            showClose: true,
            message: `登陆失败`,
            type: 'error'
          });
        }
      }).catch(e => console.log(e));
      this.userNameInput = '';
      this.passwd = '';
      this.loginBox = false;

    },
    okRegionBox(){
      this.$axios(
          {
            method:"post",
            url:"http://localhost:8080/user/registeredUser",
            data:{
              userName: this.userNameInput,
              userPassword: this.passwd,
              userPhone: this.userPhone,
              userMotto: this.motto,
            },
            timeout:1000,
          }
      ).then(res => {
        this.userStatic = res.data.success;
        if (this.userStatic === true && this.userStatic !== null){
          this.usingState = true;
          sessionStorage.setItem('userName',res.data.detail.userName);
          sessionStorage.setItem('userId',res.data.detail.id);
          this.userName = res.data.detail.userName;
          this.regiest = '退出'
          this.$message({
            showClose: true,
            message: `欢迎！${this.userName}`,
            type: 'success'
          });
        } else {
          this.$message({
            showClose: true,
            message: `注册失败`,
            type: 'error'
          });
        }
      }).catch(e => console.log(e));
      this.userNameInput = '';
      this.passwd = '';
      this.userPhone = '';
      this.motto = '';
      this.regionBox = false;

    },
    transferPress(){
      switch (this.regiest) {
        case "注册":
          this.regionBox = true;
          break;
        case "退出":
          sessionStorage.clear();
          this.$message({
            showClose: true,
            message:'退出登录成功，欢迎下次登录',

          })
          this.usingState = false;
          this.userName = '登录';
          this.regiest = '注册';
          break;
      }
    },
    okReactBox(){
      this.$axios({
        method: 'post',
        url: 'http://localhost:8080/mark/addYourSuggestion',
        data:{
          title: this.title,
          mark: this.mark,
          userId: parseInt(sessionStorage.getItem('userId'))
        }
      }).then(res => {
        if (res.data){
          this.$message({
            type:'success',
            showClose: true,
            message:`提交成功,编号${res.data.detail.id}`
          })
        }
      }).catch(e => {
        this.$message({
          type:'error',
          showClose: true,
          message:`提交失败`
        })
        console.log(e)
      });
      this.title = '';
      this.mark = '';
      this.reactBox = false;
    },
    cancelRegionBox(){
      this.regionBox = false
    },
    cancelReactBox(){
      this.reactBox = false
    }
  },
  watch:{
    userNameInput: function (val) {
      console.log(val);
      this.userNameInput = val;

    },
    passwd: function (val){
      this.passwd = val;
    },
    userPhone: function (val) {
      this.userPhone = val;
    },
    motto: function (val) {
      this.motto = val
    },
    title: function (val) {
      this.title = val
    },
    mark: function (val) {
      this.mark = val
    }
  }
}
</script>

<style scoped>


</style>