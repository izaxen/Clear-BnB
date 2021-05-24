<template>
  <div v-if="userLoggedIn !== null">
    <h1>Your rentals!</h1>

    <UserHouse v-for="house of userHouses" :key="house.id" :house="house" />
  </div>
</template>

<script>
import UserHouse from './UserHouse.vue'

export default {
  components: {
    UserHouse,
  },

  async created() {
    await this.$store.dispatch('fetchUserObjects', this.$store.state.user)
  },

  computed: {
    userLoggedIn() {
      this.user = this.$store.state.user
    },
    userHouses() {
      return this.$store.state.userObjects
    },
  },
}
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 40px;
}
</style>
