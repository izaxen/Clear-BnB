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

  max-width: 65rem;
  margin: auto;
  min-height: 50rem;
}
</style>
