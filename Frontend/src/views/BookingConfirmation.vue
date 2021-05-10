<template>
  <ConfirmationModal :startDate="receipt.startDate" :endDate="receipt.endDate">
   <template v-slot:header>
      <h2>Your booking has been confirmed!</h2>
      <h5>Bookingnumber: {{receipt.id}}</h5>
    </template>
    <template v-slot:start-date-text><h4>Check in:</h4></template>
    <template v-slot:end-date-text><h4>Check out:</h4></template>
    <template v-slot:beds>
      <h4>Adults:</h4><p>{{receipt.numAdult}}</p>
      <h4>Children:</h4><p>{{receipt.numChild}}</p>
    </template>
    <template v-slot:price>
      <h4>Total price:</h4> {{receipt.totalPrice}}
    </template>

  </ConfirmationModal>
</template>

<script>
import ConfirmationModal from '../components/ConfirmationModal.vue'

export default {

props: ["receipt"],

components:{
  ConfirmationModal,
},
}

</script>