<template>
  <div v-if="userLoggedIn !== null">
    <h1>Your rentals!</h1>
    <UserObject 
    v-for="house of userObjects"
    :key="house.id"
    :house="house"
    />
    
  </div>
</template>

<script>
import UserObject from './UserObject.vue'
export default {
  components: {
    UserObject
  },

  data(){
      return {
      user: null,
      userObjects: []
    }
  },

  async created() {
    await this.$store.dispatch('fetchRentalObjects')
    this.houses = await this.$store.state.rentalObjects
    this.userObjects = this.houses.filter((house) => house.userId === this.user.id )
  },

  computed: {
    userLoggedIn(){
      this.user = this.$store.state.user
    }
  },
}
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 40px;
}


</style>