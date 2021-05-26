<template>
  <div >
    <h1>Your bookings!</h1>
    <Receipt
      v-for="receipt of userReceipts"
      :key="receipt.id"
      :receipt="receipt"
      @deleteBooking="deleteBooking"
    />
  </div>
</template>

<script>
import Receipt from './Receipt.vue'
export default {
  components: {
    Receipt,
  },

  computed: {
    userReceipts() {
      return this.$store.state.userReceipts
    },
  },

  methods: {
    deleteBooking(deleteReceipt) {
      this.$store.dispatch('deleteReceipt', deleteReceipt.id)
    },
  },
}
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 40px;
}

@media screen and (max-width: 550px) {
  h1 {
    font-size: 30px;
  }
}
</style>
