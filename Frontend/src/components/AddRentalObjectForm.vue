<template>
  <form @submit.prevent="addRentalObject">
    <div class="rental-info">
      <div class="input-boxes">
        <div class="input-holder">
        <input class="freetext  border-radius" v-model="freeText" type="text" placeholder=" Title..."/>
        <textarea class="description border-radius" v-model="description" type="text" placeholder=" Description..."/>
        </div>
          
          <div class ="address-row">
            <input class="medium-box  border-radius" v-model="address" required type="text" placeholder=" Address..."/>
          </div>

        <div class="beds-price">
          <input class="medium-box1  border-radius" v-model="city" required type="text" placeholder=" City..."/>
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

.border-radius{
  border-radius: 5px;
  border: 1px solid grey;
  margin: 10px 0;
}

.rental-info{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 10px;
  padding: 10px;
  font-family: 'Times New Roman', Times, serif;
  font-size: 13px;
}



.beds-price{
  display: flex;
  flex-direction: row;
  
}

.input-boxes{
  display: flex;
  flex-direction: column;
  width: 100%;
}

textarea{
  width: 100%;
  resize: none;
}

.freetext{
line-height: 18px;
width: 100%;
}

.medium-box{
  width: 100%;
  line-height: 18px;
}
.medium-box1{
  grid-area: right;
  line-height: 18px;
}

.small-box{
  line-height: 18px;
  width: 60px;
  margin-left:5px;
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
}

@media only screen and (max-width: 575px){
.rental-info{
  justify-content: center;
  align-items: center;
  margin: -3px;
}

} 
</style>