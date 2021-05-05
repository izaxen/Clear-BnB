<template>
  <form @submit.prevent="addRentalObject">
    <div class="rental-info">
          
      <div class="input-boxes">
        <div class="input-holder">
        <p>Description</p>
        <textarea class="description border-radius" v-model="description" type="text"  rows="1" cols="17" placeholder="Description..."/>
        </div>
        <div class="input-holder">
        <p>Freetext</p>
        <textarea class="freetext  border-radius" v-model="freeText" type="text" rows="10" cols="17" placeholder="Freetext..."/>
        </div>
        <div class="input-holder ">
        <p>City</p>
        <input class="small-box  border-radius" v-model="city" required type="text" placeholder="City..."/>
        </div>
        <div class="input-holder ">
        <p>Adress</p>
        <input class="small-box  border-radius" v-model="adress" required type="text" placeholder="Adress..."/>
        </div>
        <div class="input-holder ">
        <p>Zip code</p>
        <input class="small-box  border-radius" v-model="zip" required type="text" placeholder="Zip Code..."/>
        </div>
        <div class="input-holder">
        <p>Number of beds</p>
        <input class="num-beds small-box  border-radius" v-model="availableBeds" required type="number" min="1" placeholder="Number of beds"/>
        </div>
        <div class="input-holder">
        <p>Price per night</p>
        <input class="price small-box" v-model="price" required type="number" min="400" placeholder="Price per night"/>
        </div>
      </div>
      
      </div>
    </form>
</template>

<script>

import Calendar from '../components/Calendar.vue'


export default {
components:{
Calendar,

},
watch:{
  description: function(){
    this.addRentalObject()
  },

},

  data(){
    return{
      availableFrom : '',
      availableTo: '',
      freeText : '',
      description : '',
      city : '',
      adress:'',
      zip:'',
      availableBeds: '',
      price : '',
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
      adress: this.adress,
      zip: this.zip,
      availableBeds: this.availableBeds,
      price : this.price,
      }
      this.$emit('fetchObject', rentalObject)

     /*  this.$store.dispatch('postRentalObject', rentalObject)
      this.availableFrom = ""
      this.availableTo = ""
      this.freeText = ""
      this.description = ""
      this.city = ""
      this.availableBeds = ""
      this.price = ""
 */
      
    }
  }
}
</script>

<style scoped>

.border-radius{
  border-radius: 0.15rem;
}
.rental-info{
  display: flex;
  flex-direction: row;
  padding: 10px;
  width: 290px;
  
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

.button {
  margin-top:1rem ;
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

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