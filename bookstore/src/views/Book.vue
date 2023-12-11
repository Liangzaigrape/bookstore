<template>
  <div class="book">
    <img :src="book.image" />
    <div>
      <div class="bookInfo">
        <h3>{{ book.title }}</h3>
        <p>{{ book.slogan }}</p>
        <p>
          <span>作者：{{ book.author }}</span>
          <span>出版社：{{ book.bookConcern }}</span>
          <span>出版日期：{{ book.publishDate }}</span>
        </p>
        <p>
          <span class="factPrice">
            {{ currency(factPrice(book.price, book.discount)) }}
          </span>
          <span class="discount">
            [{{ formatDiscount(book.discount) }}]
          </span>
          <span>[定价 <i class="price">{{ currency(book.price) }}</i>]</span>
        </p>
      </div>
      <div class="addCart">
        <AddSubtractButton :quantity="quantity" @updateQuantity="handleUpdate"/> 
        <!-- 使用 el-button，添加 type="primary" 和 plain 属性 -->
        <el-button type="primary" plain @click="addCart(book)">加入购物车</el-button>
      </div>
    </div>
    <BookTabComponent :content="book.brief"/> 
  </div>
</template>

<script>
import AddSubtractButton from '@/components/AddSubtractButton.vue'
import BookTabComponent from '@/components/BookTabComponent.vue'
import { mapActions } from 'vuex'

export default {
  name: 'Book',
  data () {
    return {
      book: {},
      quantity: 0
    }
  },
  inject: ['factPrice', 'currency'],
  components: {
    AddSubtractButton,
    BookTabComponent
  },

  created(){
    console.log(this.$route.fullPath);
    this.axios.get(this.$route.fullPath)
      .then(response => {
        if(response.status == 200){
          this.book = response.data;
        }
      }).catch(error => alert(error));
  },

  methods: {
    // 子组件AddSubtractButton的自定义事件updateQuantity的处理函数
    handleUpdate(value){
      this.quantity = value;
    },
    addCart(book){
      let quantity = this.quantity;
      
      if(quantity === 0){
        quantity = 1;
      }
      let newItem = {...book, price: this.factPrice(book.price, book.discount)}; 
      this.addProductToCart({...newItem, quantity});
      this.$router.push('/cart');
    },
    ...mapActions('cart', [
      'addProductToCart'
    ]),
    // 格式化折扣数据
    formatDiscount(value){
      if(value){
        let strDigits = value.toString().substring(2);
        strDigits += "折";
        return strDigits;
      }
      else
        return value;
    }
  },
}
</script>

<style scoped>
.book {
  width: 1100px;
  margin-top: 60px;
  text-align: left;
}

.book img {
  border-radius: 10px;
  margin-left: 50px;
  float: left;
  width: 200px;
  height: 200px;
}

.book .bookInfo {
  border-radius: 10px;
  margin-left: 20px;
  float: left;
  width: 800px;
  background-color: #eee;
  padding-left: 20px;
  padding-top: 5px;
}

.book .addCart {
  margin-left: 23px;
  float: left;
  margin-top: 10px;
}

.book .addCartButton {
  /* 使用 el-button，添加 type="primary" 和 plain 属性 */
  border-radius: 10px;
  color: #fff;
  cursor: pointer;
}

.addCartButton:hover {
  
  margin: 80px;
  text-shadow: 0 1px 1px #444;
}

.book span {
  padding-right: 15px;
}

.book .price {
  color: gray;
  text-decoration: line-through;
}

.book .discount {
  color: red;
}

.book .factPrice {
  color: red;
  font-weight: bold;
}
</style>
