<template>
  <div class="search-box">
    <div class="box1"><input class="search-text" type="text" name="" placeholder="ruta 1"></div>
      <Calendar :searchBar="searchBar" />
    <div class="box4"><input class="search-text" type="text" name="" placeholder="ruta 4"></div>
    <a class="search-btn" href="#">
      <em class="fas fa-search"></em>
    </a>
  </div>
</template>

<script>
import Calendar from './Calendar.vue'

export default {
components:{
  Calendar,
},
data(){
  return{
    searchBar: true,
  }
}

}
</script>

<style scoped>
.box1 {
  border-right: 1px solid gray;
}
.box4 {
  border-left: 1px solid gray;
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
  color: rgb(113,128,150);
  font-size: 16px;
  transition: 0.4s;
  line-height: 40px;
  width: 150px;
  text-align: center;
}
</style>