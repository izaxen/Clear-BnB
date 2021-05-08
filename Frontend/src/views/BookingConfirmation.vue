<template>
  <ConfirmationModal>
   <template v-slot:header>
      <h2>Your booking has been confirmed!</h2>
    </template>
    <template v-slot:startDate>
    </template>
    <template v-slot:startTime>
      
    </template>
    <template v-slot:endDate>
}
    </template>
    <template v-slot:endTime>

    </template>
    <template v-slot:address>
      
    </template>
    <template v-slot:zip>

    </template>
    <template v-slot:city>

    </template>
    <template v-slot:beds>

    </template>
    <template v-slot:price>

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

data(){
  return{
    rentalObject: {},
    user: {},
    receipt: this.receipt,
  }
},

</script>

<style>

</style>