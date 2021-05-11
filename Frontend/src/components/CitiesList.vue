<template>
  <!-- key should be an unique value -->
  <div class="city-list">
  <h1>POPULAR LOCATIONS</h1>
    <div class="location-box">
         <City
          v-for="city of rentalObjects"
          :key="city.id" 
          :city="city" 
        />
    </div>
    <div class="arrow-btns">
      <button class="slide-arrow" @click="slideLeft"><em class="far fa-arrow-alt-circle-left slide-arrow"></em></button>
      <button class="slide-arrow" @click="slideRight"><em class="far fa-arrow-alt-circle-right slide-arrow"></em></button>
    </div>
    
  </div>
</template>

<script>
import City from './City.vue'
export default {
  components: {
      City
      },
  
  data(){
    return {
      start: 0,
      end: 2
    }
  },
  computed: {
    rentalObjects(){
      return this.$store.state.rentalObjects.slice(this.start, this.end)
    }
  },
  methods: {
    slideRight(){
      if(this.start === 4)
        return
      this.start = this.start + 2
      this.end = this.end + 2
    },
    slideLeft(){
      if(this.start < 1)
        return
      this.start = this.start - 2
      this.end = this.end - 2
    },
  }
}
</script>

<style scoped>
input {
  margin-bottom: 15px;
  padding: 5px;
  width: 100%;
  border-radius: 7px;
  border: 1px solid gray;
}
.slide-arrow {
  background: none;
  border: none;
}
.arrow-btns {
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 20px;
  font-size: 40px;
}
.slide-arrow:hover > .slide-arrow {
  transform: scale(1.2);
  cursor: pointer;
  background: rgba(74, 255, 255, 0.534);
  border-radius: 50%;
  
}
button {
  width: 100px;
  justify-self: center;
  margin-bottom: 10px;
}
.city-list{
  display: grid;
  justify-items: center;
  margin: auto;
}
.location-box {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  padding: 10px;
  margin: 10px;
  width: 70rem;
}
h1 {
  font-size: 40px;
  font-weight: 900;
  text-align: center;
}
input:focus {
  outline: none;
}

 @media screen and (max-width: 925px) {
   .location-box {
     display: flex;
     flex-direction: column;
     width: 20rem;
   }
 }
</style>