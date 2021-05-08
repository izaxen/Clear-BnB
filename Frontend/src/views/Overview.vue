<template>
  <div>
    <Filter />
  </div>
</template>

<script>
import Filter from '../components/Filter.vue'
export default {
  components: {
    Filter,
  },

  created(){
    this.$store.dispatch('fetchRentalObjects')
  }
}
</script>

<style scoped>
div {
  max-width: 65rem;
  margin: auto;
}
</style>
