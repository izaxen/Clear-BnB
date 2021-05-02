<template>
  <div class="search-box">
    <div class="box1"><input class="search-text" type="text" name="" placeholder="ruta 1"></div>
    <div class="box2"><input class="search-text" type="text" name="" placeholder="ruta 2"></div>
    <div class="box3"><input class="search-text" type="text" name="" placeholder="ruta 3"></div>
    <div class="box4"><input class="search-text" type="text" name="" placeholder="ruta 4"></div>
    <a class="search-btn" href="#">
      <em class="fas fa-search"></em>
    </a>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.box1 {
  border-right: 1px solid gray;
}
.box2 {
  border-right: 1px solid gray;
}
.box3 {
  border-right: 1px solid gray;
}
.search-box {
  display: flex;
  background: #fbfbfb;
  height: 60px;
  border-radius: 40px;
  padding: 10px;
  width: fit-content;
}
.search-box:focus-within > .search-text {
  width: 350px;
}
.search-box:hover > .search-btn {
  background: #4aae9b;
}
.search-btn {
  color: #e84118;
  float: right;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: white;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.4s;
}
.search-text{
  border: none;
  background: none;
  outline: none;
  float: left;
  padding: 0;
  color: black;
  font-size: 16px;
  transition: 0.4s;
  line-height: 40px;
  width: 150px;
  text-align: center;
}
</style>