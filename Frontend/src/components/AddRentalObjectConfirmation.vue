<template>
  <ConfirmationModal :startDate="availableFrom" :endDate="availableTo">
   <template v-slot:header>
      <h2>Your object has been added.</h2>
    </template>
    <template v-slot:start-date-text>Available from:</template>
    <template v-slot:end-date-text>Available to:</template>
    <template v-slot:beds-text>Available beds:</template>
    <template v-slot:beds-count>{{$store.state.rentalObject.availableBeds}}</template>
    <template v-slot:price-text>Price per night:</template>
    <template v-slot:price>{{$store.state.rentalObject.price}}</template>
    
  </ConfirmationModal>
</template>

<script>
import ConfirmationModal from './ConfirmationModal.vue'

export default {
components:{
  ConfirmationModal,
},

data(){
  return{
  availableFrom: '',
  availableTo : '',
  }
},

watch:{
  '$store.state.rentalObject'(){
    this.availableFrom = this.$store.state.rentalObject.availableFrom
    this.availableTo = this.$store.state.rentalObject.availableTo
  }
}
}
</script>