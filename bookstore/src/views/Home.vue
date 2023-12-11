<template>
  <div class="home">

    <HomeCategory></HomeCategory>
    <HomeScrollPic></HomeScrollPic>
    <HomeBooksHot></HomeBooksHot>
    <BooksNew></BooksNew>
    <BooksHot></BooksHot>
  </div>
</template>

<script>
// @ is an alias to /src
import HomeCategory from '@/components/HomeCategory.vue';
import HomeScrollPic from '@/components/HomeScrollPic.vue';
import HomeBooksHot from '@/components/HomeBooksHot.vue';
import BooksNew from '@/components/BooksNew.vue';
import BooksHot from '@/components/BooksHot.vue';
export default {
  name: 'Home',
  components: {
    HomeCategory,
    HomeScrollPic,
    HomeBooksHot,
    BooksNew,
    BooksHot
  }
}
</script>

<style scoped>
.home {
  float: left;
  text-align: center;
  width: 100%;
}
[v-cloak]{
  display: none;
}
</style>