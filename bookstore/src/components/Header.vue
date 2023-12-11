<template>
  <div class="header">
    <img src="../assets/images/logo.png">
    <HeaderSearch />
    <HeaderCart/>
    <span v-if="!user">
      你好，请
      <el-button @click.prevent="$router.push('/login')" type="primary" plain>登录</el-button>
      免费
      <el-button @click.prevent="$router.push('/register')" type="primary" plain>注册</el-button>
    </span>
    <span v-else>
      欢迎您，{{ user.username }}，
      <el-button @click="logout" type="primary" plain>退出登录</el-button>
    </span>
  </div>
</template>

<script>
import HeaderSearch from "./HeaderSearch.vue";
import HeaderCart from "./HeaderCart.vue";
import { mapState, mapMutations } from 'vuex';

export default {
  name: "Header",
  components: {
    HeaderSearch,
    HeaderCart
  },
  computed: {
    ...mapState('user', [
      'user'
    ])
  },
  methods: {
    logout() {
      this.deleteUser();
    },
    ...mapMutations('user', [
      'deleteUser'
    ])
  },
};
</script>

<style scoped>
.header {
  width: 100%;
}

.header img {
  width: 200px;
  height: 60px;
  margin: auto;  
}

.header span {
  margin-left: 20px;
}

/* 共用样式，模仿 HeaderSearch 中按钮的样式 */
.header button {
  position: relative;
  margin-left: 0px;
}
</style>
