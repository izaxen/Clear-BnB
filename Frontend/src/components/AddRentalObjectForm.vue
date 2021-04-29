<template>
  <div class="rental-info">
    <form @submit.prevent="addRentalObject">
    <!--Replace inputs for date with calendar for choosing from- and to- dates-->
    <h5>Rent out from</h5><input v-model="availableFrom" type="date"/>
    <h5>Rent out until</h5><input v-model="availableTo" type="date">
    <div class="input-boxes">
      <textarea class="description" v-model="description" rows="1" cols="17" type="text" placeholder="Description"/>
    <textarea class="freetext" v-model="freeText" rows="10" cols="17" placeholder="Freetext"/>
    <textarea class="city" v-model="city" rows="1" cols="17" placeholder="City"/>
    <input class="num-beds" v-model="availableBeds" type="number" placeholder="Number of beds"/>
    <input class="price" v-model="adultPrice" type="number" placeholder="Adult price per night"/>
    <input class="price" v-model="childPrice" type="number" placeholder="Child price per night"/></div>
    <button>Add house</button>
    </form>

  </div>
</template>

<script>
export default {
  data(){
    return{
      availableFrom : "",
      availableTo: "",
      freeText : "",
      description : "",
      city : "",
      availableBeds: "",
      adultPrice : "",
      childPrice : "",
    }
  },
  methods: {
    addRentalObject(){
      let rentalObject ={
      availableFrom : this.availableFrom,
      availableTo: this.availableTo,
      freeText : this.freeText,
      description : this.description,
      city : this.city,
      availableBeds: this.availableBeds,
      adultPrice : this.adultPrice,
      childPrice : this.childPrice,
      }
      this.$store.dispatch('postRentalObject', rentalObject)
    }
  }

}
</script>

<style scoped>
.rental-info{
  display: flex;
  flex-direction: column;
  width: 300px;
  height: fit-content;
  padding: 10px 20px;
}
.input-boxes{
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-content: space-around;
}
input[type=text], input[type=number]{
  margin: 20px;
}
button {
  margin: 0 30px;
  width: 60px;
  height: 30px;
  color: green;
}
.description{
  min-height: 150px;
  display: flex;
  justify-content: space-around;
  align-content: space-between;
}
.freetext{
min-height: 150px;
}
.city{
min-height: 60px;
}
.num-beds{
min-height: 50px;
}
.price{
min-height: 40px;
}
</style>