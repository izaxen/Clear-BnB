<template>
  <input type="text" placeholder="calandar - From date" />
  <input type="text" placeholder="calandar - To date" />
  <NumberOfGuests :numOfDays="10" />
</template>

<script>
import NumberOfGuests from '../components/NumberOfGuestsSelector.vue'

export default {
  components: {
    NumberOfGuests,
  },
}
</script>

<style></style>
