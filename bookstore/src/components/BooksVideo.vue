<template>
  <section id="video" class="book">
    <div class="row">
      <div class="col-md-12">
        <div class="box-video">
          <div class="video-container">
            <iframe width="100%" height="520" src="https://search.bilibili.com/all?keyword=%E7%BC%96%E7%A8%8B%E4%B9%A6%E7%B1%8D&from_source=webtop_search&spm_id_from=333.1007&search_source=5" frameborder="0" allowfullscreen="allowfullscreen"></iframe>
          </div>
        </div>
      </div>

      <div class="col-md-12">
        <el-button class="accent-button button" type="primary" plain color="#409EFF">
          <a href="https://search.bilibili.com/all?keyword=%E7%BC%96%E7%A8%8B%E4%B9%A6%E7%B1%8D&from_source=webtop_search&spm_id_from=333.1007&search_source=5" target="_blank">了解更多编程书籍</a>
        </el-button>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: '',
  props: [''],
  data() {
    return {
      books: [],
    };
  },
  inject: ['factPrice', 'currency'],
  created() {
    this.axios.get("/book/teach")
      .then(response => {
        if (response.status == 200) {
          this.loading = false;
          this.books = response.data;
        }
      })
      .catch(error => console.log(error));
  }
}
</script>

<style scoped>
/* 如果需要自定义样式，请添加样式 */
</style>
