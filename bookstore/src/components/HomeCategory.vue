<template>
    <div class="category">
      <h3>图书分类</h3>
      <div v-for="category in categories" :key="category.categoryId">
        <h5>{{ category.categoryName }}</h5>
        <router-link 
          v-for="child in category.children"
          :key="child.id"
          :to="'category/' + child.categoryId"
          >{{ child.categoryName }}</router-link
        >
        <!-- <router-view></router-view> -->
      </div>
    </div>
  </template>
  <script>
  export default {
    name: "HomeCategory",
    data() {
      return {
        categories: [],
      };
    },

    created() {
      this.axios
        .get("/categories")
        .then((response) => {
          if (response.status == 200) {
            this.categories = response.data;
          }
        })
        .catch((error) => console.log(error));
    },
  };
  </script>
  
  <style scoped>
  .category {
    margin-left: 60px;
    margin-top: 10px;
    float: left;
    border: 2px solid #ccc;
    width: 15%;
    border-radius: 10px;
  }
  .category div {
    margin-bottom: 10px;
  }
  .category a {
    padding: 0 5px 0 5px;
  }
  </style>