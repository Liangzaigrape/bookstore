<template>
  <div class="booksNew">
    <h3>特价销售</h3>
    <div class="book" v-for="book in books" :key="book.id">
      <figure class="bookFigure">
        <router-link :to="'/book/' + book.id">
          <img :src="book.image">
          <figcaption>
            {{ book.title }}
          </figcaption>
        </router-link>
      </figure>
      <p>
        {{ currency(factPrice(book.price, book.discount)) }} 
        <span>{{ currency(book.price) }}</span>
      </p>
    </div>
  </div>
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
    this.axios.get("/book/hot")
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
.booksNew {
  float: left;
  margin-left: 200px;
}

.booksNew .book {
  display: inline-block;
  width: 200px;
  border: 2px solid #ccc;
  border-radius: 8px;
  margin-left: 10px;
  transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out; /* 添加过渡效果 */
}

.booksNew .book:hover {
  transform: translateY(-5px); /* 向上移动5像素，模拟立体感觉 */
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
}

.booksNew .bookFigure {
  overflow: hidden; /* 防止图片超出卡片部分溢出 */
}

.booksNew .book a:hover {
  color: red;
}

.booksNew img {
  border-radius: 10px;
  width: 120px;
  height: 100px;
}

.booksNew span {
  color: #cdcdcd;
  text-decoration: line-through;
}
</style>
