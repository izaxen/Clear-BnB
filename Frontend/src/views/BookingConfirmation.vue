<template>
  <ConfirmationModal>
    <template v-slot:header>
      <h2>I got this!</h2>
    </template>
  </ConfirmationModal>
</template>

<script>
import ConfirmationModal from '../components/ConfirmationModal.vue'

export default {
components:{
  ConfirmationModal,
},

data(){
  return{
    rentalObject: {},
    user: {},
    bookingReceipt: {},
  }
}
}
</script>

<style>

</style>