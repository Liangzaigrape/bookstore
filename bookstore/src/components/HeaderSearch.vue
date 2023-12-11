<template>
  <div class="headerSearch">
    <input type="search" v-model.trim="keyword" >
    <el-button @click="search" type="primary" plain>搜索</el-button>
  </div>
</template>

<script>
import { ElButton } from 'element-plus';

export default {
  name: 'HeaderSearch',
  components: {
    ElButton,
  },
  data() {
    return {
      keyword: '',
    };
  },
  methods: {
    search() {
      // 当查询关键字与当前路由对象中的查询参数wd值不同时，才调用$router.push方法
      if (this.keyword !== this.$route.query.keyword) {
        this.$router.push({ path: '/search', query: { keyword: this.keyword } });
      }
    },
  },
};
</script>

<style scoped>
.headerSearch {
  display: inline-block;
  position: relative;
  margin-left: 30px;
}

.headerSearch input {
  margin: 10px;
  width: 400px;
  height: 30px;
}

/* 移除原有的 .headerSearch button 样式 */

.headerSearch button{
}

</style>
