<template>
  <div class="overview">
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
.overview {
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  max-width: 65rem;
  margin: auto;
  background-color: rgba(205, 205, 205, 0.6);
  height: 100%;
}
</style>
