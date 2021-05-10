<template>
  <div v-if="userLoggedIn !== null">
    <UserHouse 
    v-for="house of userHouses"
    :key="house.id"
    :house="house"
    />
    
  </div>
</template>

<script>
import UserHouse from '../components/UserHouse.vue'
export default {
  components: {
    UserHouse
  },

  data(){
      return {
      user: null,
      userHouses: []
    }
  },

  async created() {
    await this.$store.dispatch('fetchRentalObjects')
    this.houses = await this.$store.state.rentalObjects
    this.userHouses = this.houses.filter((house) => house.userId === this.user.id )
  },

  computed: {
    userLoggedIn(){
      this.user = this.$store.state.user
    }
  },
}
</script>

<style>

</style>