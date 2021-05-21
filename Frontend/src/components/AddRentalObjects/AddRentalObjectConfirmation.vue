<template>
  <ConfirmationModal :startDate="availableFrom" :endDate="availableTo" @close="close">
   <template v-slot:header>
      <h2>Your object has been added.</h2>
    </template>
    <template v-slot:start-date-text>Available from:</template>
    <template v-slot:end-date-text>Available to:</template>
    <template v-slot:beds-text>Available beds:</template>
    <template v-slot:beds-count>{{rentalObject.availableBeds}}</template>
    <template v-slot:price-text>Price per night:</template>
    <template v-slot:price>{{rentalObject.price}}</template>
    
  </ConfirmationModal>
</template>

<script>
import ConfirmationModal from '../Utils/ConfirmationModal.vue'
export default {
emits: ['close'],
components:{
  ConfirmationModal,
},

data(){
  return{
  availableFrom: '',
  availableTo : '',
  }
},

methods:{
  close(){
    this.$emit('close')
    
  },
},

computed:{
      rentalObject: function(){ 
        
      return this.$store.state.rentalObject}
},


watch:{ 
  
  '$store.state.rentalObject'(){
    if(this.$store.state.rentalObject != null){
    this.availableFrom = this.$store.state.rentalObject.availableFrom
    this.availableTo = this.$store.state.rentalObject.availableTo
  } 
  }
}
}
</script>