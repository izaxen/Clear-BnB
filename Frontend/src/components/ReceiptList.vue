<template>
  <div v-if="userLoggedIn !== null">
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

  data(){
    return {
      user: null,
      userReceipts: []
    }
  },

  async created() { 
    this.getReceipts();
  },

  computed: {
    userLoggedIn(){
      this.user = this.$store.state.user
    },
  },

  methods: {
    async getReceipts(){
      await this.$store.dispatch('fetchReceipts')
      this.receipts = await this.$store.state.receipts
      
      this.userReceipts = this.receipts.filter((receipt) => receipt.userId === this.user.id )
    },
    
    deleteBooking(deleteReceipt){
      this.userReceipts = this.userReceipts.filter((receipt) => receipt !== deleteReceipt)
    }
  } 
}
</script>

<style scoped>

h1 {
  text-align: center;
  font-size: 40px;
}

.wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
input,
select {
  height: 32px;
}
</style>
