<template>
  <div class="bookListItem">
    <div>
      <!-- 修改 -->
      <!-- <img :src="item.bigImgUrl"> -->
      <img :src="item.image">
    </div>
    <p class="title">
      <router-link :to="{ name: 'book', params: { id: item.id } }" target="_blank">
        {{ item.title }}
      </router-link>
    </p>
    <p>
      <span class="factPrice">
        {{ currency(factPrice(item.price, item.discount)) }}
      </span>
      <span>
        定价：<i class="price">{{ currency(item.price) }}</i>
      </span>
    </p>
    <p>
      <span>{{ item.author }}</span> /
      <span>{{ item.publishDate }}</span> /
      <span>{{ item.bookConcern }}</span>
    </p>
    <p class="brief">
      {{ item.brief }}
    </p>
    <p>
      <el-button type="primary" plain @click=addCartItem(item) class="addcart">加入购物车</el-button>
    </p>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'BookListItem',
  props: {
    item: {
      type: Object,
      default: () => { }
    }
  },
  inject: ['factPrice', 'currency'],
  methods: {
    ...mapActions('cart', {
      // 将this.addCart映射为 this.$store.dispatch('cart/addProductToCart')
      addCart: 'addProductToCart'
    }),
    addCartItem(item) {
      let quantity = 1;
      let newItem = {
        ...item,
        price: this.factPrice(item.price, item.discount),
        quantity
      };
      this.addCart(newItem);
      this.$router.push("/cart");
    }
  },
}
</script>
<style scoped>
.bookListItem {
  border-bottom: solid 1px #ccc;
  margin-top: 10px;
  margin-left: 30px;
  margin-right: 30px;
  border-radius: 10px;
}

.bookListItem p {
  text-align: left;
}

.bookListItem p span {
  padding-left: 10px;
}

.bookListItem img {
  border-radius: 10px;
  width: 180px;
  height: 180px;
  float: left;
}

.addCartButton {
  padding: 5px 10px 6px;
  color: #fff;
  border: none;
  border-bottom: solid 1px #222;
  border-radius: 5px;
  box-shadow: 0 1px 3px #999;
  text-shadow: 0 -1px 3px #444;
  cursor: pointer;
  background-color: #e33100;
}

.addcart{
  margin-left: 10px;

}

.brief{
  margin-left: 10px;
}

.bookListItem .price {
  color: #cdcdcd;
  text-decoration: line-through;
}

.bookListItem .factPrice {
  color: red;
  font-weight: bold;
}

.bookListItem .title {
  color: #e00;
}</style>