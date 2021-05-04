<template>
  <form class="search-box">
    <select @click="showCityNames" v-model="cityName" class="box1">
      <option value="" disabled selected hidden>--Citys--</option>
      <option v-for="city in citys" :value="city"> {{city}} </option>
    </select>
      <Calendar :searchBar="searchBar" />
    <div class="box4" type="text" name="" placeholder="ruta 4">
      <p>Persons</p>
      </div>
      <div class="person-div"></div>
    <a class="search-btn" href="#">
      <em class="fas fa-search"></em>
    </a>
  </form>
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
    city: '',
    citys: [],
    cityName: ''
  }
},

methods: {
  showCityNames(){
    let getCitys = this.$store.state.rentalObjects;
    for(let cityName of getCitys){

      this.citys.push(cityName.city)
    }

    let removedDuplicates = this.citys.filter((value, index) => {
      return this.citys.indexOf(value) === index
    })
    this.citys = removedDuplicates;
  }
}

}
</script>

<style scoped>
option {
  color: rgb(0, 0, 0);
  font-weight: 600;
  background:#59deff93;
  padding: 10px;
  font-size: 17px;

}

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

.box1:hover > .search-btn {
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
.box1{
  border: none;
  background: none;
  outline: none;
  padding: 2px;
  color: rgb(113,128,150);
  font-size: 15px;
  transition: 0.4s;
  width: 150px;
}

.box4{
  display: grid;
  justify-content: center;
  align-content: center;
  padding: 2px;
  color: rgb(113,128,150);
  font-size: 20px;
  transition: 0.4s;
  line-height: 40px;
  width: 150px;
}

.box4:hover {
  cursor: pointer;
}
</style>