<template>
  <div class="login">
    <div class="error">{{ message }}</div>
    <form>
      <div class="lable">
        <input
          name="username"
          type="text"
          v-model.trim="username"
          placeholder="请输入用户名"
        />
        <input
          type="password"
          v-model.trim="password"
          placeholder="请输入密码"
        />
      </div>
      <div class="submit">
        <el-button type="primary" plain @click.prevent="login">登录</el-button>
      </div>
    </form>
  </div>
</template>

<script>
import { ElButton } from 'element-plus';
import { mapMutations } from 'vuex';

export default {
  name: "UserLogin",
  components: {
    ElButton,
  },
  data() {
    return {
      username: '',
      password: '',
      message: ''
    };
  },
  methods: {
    login(){
      this.message = '';
      if(!this.checkForm())
        return;
      this.axios.post("/user/login", 
        {username: this.username, password: this.password})
        .then(response => {
          if(response.data.code === 200){
            console.log(response.data.data);
            var user={username:response.data.data.userName,id:response.data.data.userId};
            this.saveUser(user);
            this.username = '';
            this.password = '';
            if(this.$route.query.redirect){   
                const redirect = this.$route.query.redirect;
                this.$router.replace(redirect); 
            }else{
                this.$router.replace('/');    
            }
          }else if(response.data.code === 500){
            this.message = "用户登录失败";
          }else if(response.data.code === 400){
            this.message = "用户名或密码错误";
          }
        })
        .catch(error => {
          console.log(error.message);
        })
    },
    ...mapMutations('user', [
      'saveUser'
    ]),
    checkForm(){
      if(!this.username || !this.password){
        alert("所有字段不能为空");
        return false;
      }
      return true;
    }
  }
};
</script>

<style scoped>
.login {
  margin: 5em auto 0;
  width: 44%;
}

.login input{
  padding: 15px;
  width: 94%;
  font-size: 1.1em;
  margin: 18px 0px;
  color: gray;
  float: left;
  cursor: pointer;
  font-family: "HelveticaNeue", "Helvetica Neue", Helvetica, Arial, sans-serif;
  outline: none;
  font-weight: 600;
  margin-left: 3px;
  background: #eee;
  transition: all 0.3s ease-out;
  border: solid 1px #ccc;
}

.login input:hover{
  color: rgb(180, 86, 9);
  border-left: solid 6px #409EFF;
}

.login {
  padding: 5px 4px;
  text-align: center;
}

.el-button {
  width: 100%;
  height: 50px;
  max-width: 100%;
  font-size: large;
}

.login .error{
  color: #409EFF;
  font-weight: bold;
  font-size: 1.1em;
}
</style>
