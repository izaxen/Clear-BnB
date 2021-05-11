<template>
  <ConfirmationModal :startDate="rentalObject.availableFrom" :endDate="rentalObject.availableTo">
   <template v-slot:header>
      <h2>Your object has been added.</h2>
    </template>
    <template v-slot:start-date-text>Available from:</template>
    <template v-slot:end-date-text>Available To out:</template>
    <template v-slot:beds-text>Adults:</template>
    <template v-slot:beds-count>{{receipt.numAdult}}</template>
    <template v-slot:price>{{receipt.totalPrice}}</template>
    </template>
    
  </ConfirmationModal>
</template>

<script>
import ConfirmationModal from '../components/ConfirmationModal.vue'

export default {

props: ["rentalObject"],

components:{
  ConfirmationModal,
},
}
</script>