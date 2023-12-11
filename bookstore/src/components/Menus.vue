<template>
  <div class="menus">
    <ul>
      <li>
        <el-button type="primary" plain class="custom-button">
          <router-link to="/home">首页</router-link>
        </el-button>
      </li>
      <li>
        <el-button type="success" plain class="custom-button">
          <router-link to="/newBooks">新书</router-link>
        </el-button>
      </li>
      <li>
        <el-button type="warning" plain class="custom-button">
          <router-link to="/hotBooks">特价书</router-link>
        </el-button>
      </li>
      <li>
        <el-button type="danger" plain class="custom-button">
          <router-link to="/teachBooks">教材</router-link>
        </el-button>
      </li>
      <li>
        <el-button type="info" plain class="custom-button">
          <router-link to="/videoBooks">视听教程</router-link>
        </el-button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Menus",
};
</script>

<style scoped>
.menus {
  position: relative;
  width: 100%;
}

.custom-button {
  margin: 10px;
  border-radius: 10px;
  width: auto;
  font-size: 18px;
  color: inherit;
  position: relative;
  overflow: hidden;
  transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
}

.custom-button:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.custom-button::before {
  content: "";
  position: absolute;
  top: -5px;
  right: -5px;
  bottom: -5px;
  left: -5px;
  z-index: -1;
  border-radius: 15px;
  transition: transform 0.3s ease-in-out;
}

.custom-button:hover::before {
  transform: scale(1.2);
}

/* 移除原有的样式，因为 Element Plus 已经提供默认样式 */

li {
  width: 20%;
  list-style-type: none;
  float: left;
  text-align: center;
}

</style>
