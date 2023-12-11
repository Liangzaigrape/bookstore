<template>
  <div class="addSubtractButton">
    <div>
      <input v-model="quantity" type="number">
    </div>
    <div>
      <a class="add" href="javascript:;" @click="handleAdd">+</a>
      <br>
    </div>
    <div>
      <a class="sub" @click="handleSubtract" :class="{ disabled: quantity === 0, actived: quantity > 0 }" href="javascript:;">-</a>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      quantity: 0,
    };
  },
  name: "AddSubtractButton",
  methods: {
    handleAdd() {
      this.quantity++;
      this.$emit("update-quantity", this.quantity);
    },
    handleSubtract() {
      this.quantity--;
      this.$emit("update-quantity", this.quantity);
    },
  },
};
</script>

<style scoped>
.addSubtractButton {
  display: flex;
}

.addSubtractButton input {
  font-size: large  ;
  margin-right: 10px;
  border-radius: 10px;
  height: 30px;
  width: 30px;
  text-align: center;
}

.addSubtractButton a {
  font-size: x-large;
  border-radius: 10px;
  text-align: center;
  height: 32px;
  width: 32px;
  padding-bottom: 3px;
  background-color: #ccc;
  border: solid 1px gray;
  display: inline-block;
}

.addSubtractButton a.add {
  color: black;
  margin-right: 4px;
  margin-bottom: 10px;
}

.addSubtractButton a.sub {
  border-top: none;
  margin-bottom: 10px;
}

.disabled {
  pointer-events: none;
  color: gray;
  cursor: default;
}

.actived {
  color: black;
}
</style>
