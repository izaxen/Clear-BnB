<template>
  <div v-if="userLoggedIn !== null">
    <Receipt 
    v-for="receipt of userReceipts"
    :key="receipt.id"
    :receipt="receipt"
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
    await this.$store.dispatch('fetchReceipts')
    this.receipts = await this.$store.state.receipts
    
    this.userReceipts = this.receipts.filter((receipt) => receipt.userId === this.user.id )
  },

  computed: {
    userLoggedIn(){
      this.user = this.$store.state.user
    }
  },

  methods: {
  } 
}
</script>

<style scoped>
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
