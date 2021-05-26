<template>
  <ConfirmationModal @close="close" :startDate="receipt.startDate" :endDate="receipt.endDate">
   <template v-slot:header>
      <h2>Your booking has been confirmed!</h2>
    </template>
    <template v-slot:start-date-text>Check in:</template>
    <template v-slot:end-date-text>Check out:</template>
    <template v-slot:beds-text>Adults:</template>
    <template v-slot:beds-count>{{receipt.numAdult}}</template>
    <template v-slot:beds-text-two>Children:</template>
    <template v-slot:beds-count-two>{{receipt.numChild}}
    </template>
    <template v-slot:price>
      {{receipt.totalPrice}}
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

methods:{
  close(){
    this.$emit('close')
  }
}
}

</script>