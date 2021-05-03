<template>
  <form @submit.prevent="addRentalObject">
    <div class="rental-info">
      <Calendar />
    
      <div class="input-boxes">
        <div class="input-holder">
        <p>Description</p>
        <textarea class="description" v-model="description" rows="1" cols="17" type="text" placeholder="Description..."/>
        </div>
        <div class="input-holder">
        <p>Freetext</p>
        <textarea class="freetext" v-model="freeText" rows="10" cols="17" placeholder="Freetext"/>
        </div>
        <div class="input-holder">
        <p>City</p>
        <textarea class="city small-box" v-model="city" rows="1" cols="17" placeholder="City"/>
        </div>
        <div class="input-holder">
        <p>Number of beds</p>
        <input class="num-beds small-box" v-model="availableBeds" type="number" min="1" placeholder="Number of beds"/>
        </div>
        <div class="input-holder">
        <p>Price per night</p>
        <input class="price small-box" v-model="price" type="number" min="1" placeholder="Price per night"/>
        </div>
      </div>
    <button>Add house</button>
    </div>
    </form>
</template>

<script>

import Calendar from '../components/Calendar.vue'

export default {
components:{
Calendar,
},


  data(){
    return{
      availableFrom : "",
      availableTo: "",
      freeText : "",
      description : "",
      city : "",
      availableBeds: "",
      price : "",
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
      price : this.price,
      }
      this.$store.dispatch('postRentalObject', rentalObject)
      this.availableFrom = ""
      this.availableTo = ""
      this.freeText = ""
      this.description = ""
      this.city = ""
      this.availableBeds = ""
      this.price = ""
    }
  }

}


 /* <p>Available from</p> //Gamla kalender.
        <input v-model="availableFrom" type="date"/>
      </div>
      <div class="column">
        <p>Available to</p>
        <input v-model="availableTo" type="date"/>
        </div> */

</script>

<style scoped>
.rental-info{
  display: flex;
  flex-direction: column;
  padding: 10px;
  width: 290px;
  border: 1px solid rgb(34, 32, 32);
  font-family: 'Times New Roman', Times, serif;
  font-size: 13px;
}
.input-holder{
  height: fit-content;
  width: 100%;
  margin-top: 10px;
}
p{
  font-size: 12px;
  margin: 0;
  margin-bottom: 2px;
}
.column{
  width: 50%;
  display: flex;
  flex-direction: column;
  align-content: space-around;
  border: 1px solid rgb(34, 32, 32);
  padding: 3px;
}
.row{
  display: flex;
  flex-direction: row;
  width: 100%;
  margin-bottom: 7px;
}
.row p{
  color: rgb(0, 0, 0);
  margin: 0;
}
input[type=date]{
  font-size: 13px;
}
.input-boxes{
  display: flex;
  flex-direction: column;
  width: 100%;
}
input[type=number]{
  margin: 0;
  padding: 0;
}
form button {
  display: block;
  margin-top: 10px;
  width: 70px;
  height: 25px;
  color: rgb(7, 7, 7);
  font-size: 12px;
}
textarea{
  width: 100%;
  resize: none;
}
.description{
  min-height: 70px;
}
.freetext{
min-height: 150px;
}
.small-box{
  line-height: 13px;
  min-height: 20px;
  width: 60%;
}
</style>