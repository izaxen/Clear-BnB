<template>
  <div class="container">
    <Calendar />
    <NumberOfGuests :numOfDays="10" />
  </div>
</template>

<script>
import NumberOfGuests from './rentalPriceCalculator.vue'
import Calendar from './Calendar.vue'

export default {
  components: {
    NumberOfGuests,
    Calendar,
  },
}
</script>

<style scoped>
.container {
  padding: 10px;
  width: 300px;
  background: rgb(216, 216, 216);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 250px;
}
</style>
