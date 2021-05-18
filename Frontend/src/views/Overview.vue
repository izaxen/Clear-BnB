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

  created() {
    this.$store.dispatch('fetchRentalObjects')
  },
}
</script>

<style scoped>
div {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  max-width: 80rem;
  margin: auto;

  min-height: 90vh;
  background-color: rgba(205, 205, 205, 0.9);
}
</style>
