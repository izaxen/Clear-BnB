<template>
  <div class="container">
    <Calendar @days-selected="recive" />
    <NumberOfGuests :numOfDays="a" />
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

  data() {
    return {
      a: '',
    }
  },

  methods: {
    recive(hej) {
      this.a = hej
      console.log(this.a)
    },
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
