<template>
  <form @submit.prevent="addRentalObject">
    <div class="rental-info">
      <div class="input-boxes">
        <div class="input-holder">
        <input class="freetext  border-radius" v-model="freeText" type="text" placeholder=" Title..."/>
        <textarea class="description border-radius" v-model="description" type="text"  placeholder=" Description..."/>
        <input class="medium-box  border-radius" v-model="address" required type="text" placeholder=" Address..."/>
        <input class="medium-box1  border-radius" v-model="city" required type="text" placeholder=" City..."/>
        </div>

        <div class="beds-price">
          <input class="small-box  border-radius" v-model="zipCode" required type="text" placeholder=" Zip Code..."/>
        <input class="small-box  border-radius" v-model="availableBeds" required type="number" min="1"  max ="25" placeholder=" Beds.."/>
        <input class="small-box border-radius" v-model="price" required type="number" min="400" placeholder=" Price.."/>
        
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
  freeText: function(){
      this.addRentalObject()
    },
  city: function(){
      this.addRentalObject()
    },
  address: function(){
      this.addRentalObject()
    },
  zipCode: function(){
      this.addRentalObject()
    },
  availableBeds: function(){
      this.addRentalObject()
    },
  price: function(){
      this.addRentalObject()
    },
},

  data(){
    return{
      freeText : '',
      description : '',
      city : '',
      address:'',
      zipCode:'',
      availableBeds: '',
      price : '',
      }
  },

  methods: {
    addRentalObject(){
      
      let rentalObject ={
      freeText : this.freeText,
      description : this.description,
      city : this.city,
      address: this.address,
      zipCode: this.zipCode,
      availableBeds: this.availableBeds,
      price : this.price,
      }
      this.$emit('fetchObject', rentalObject)

    },
  }
}
</script>

<style scoped>
.input-holder{
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: repeat(auto-fit, minmax(50px, 1fr));
  width: 100%;
}

.border-radius{
  border-radius: 5px;
  border: 1px solid grey;
  margin: 10px 0;
}

.rental-info{
  display: grid;
  grid-template-columns: 1fr;
  margin: 10px;
  padding: 10px;
  font-family: 'Times New Roman', Times, serif;
  font-size: 18px;
}

.beds-price{
  display: flex;
  flex-direction: row;
}

.input-boxes{
  display: grid;
  grid-template-columns: 1fr;
  width: 100%;
}

textarea{
  width: 100%;
  resize: none;
}

.freetext{
  line-height: 18px;
  width: 100%;
  height: 30px;
}

.small-box{
  line-height: 18px;
  width: 80px;
  margin-left: 5px;
}

input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
  -webkit-appearance: none; 
  margin: 0; 
}

input[type=number] {
  -moz-appearance: textfield;
}

.description{
  line-height: 20px;
  height: 160px;
}

@media only screen and (max-width: 575px){
.rental-info{
  justify-content: center;
  align-items: center;
  margin: -3px;
  }
}
@media only screen and (max-width: 525px){
  .beds-price {
    display: flex;
    flex-direction: column;
  }
  .small-box {
    width: 100px;
  }
}
</style>