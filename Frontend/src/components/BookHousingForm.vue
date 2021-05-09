<template>
  <div class="container">
    <Calendar :booking="true" @days-selected="recive" @dates="confirmDates" />
    <NumberOfGuests @num-guest="confirmGuest" :numOfDays="days" />
    <button @click="book">Book</button>
  </div>
</template>

<script>
import NumberOfGuests from './rentalPriceCalculator.vue'
import Calendar from './Calendar.vue'

export default {
  props: ['object'],

  components: {
    NumberOfGuests,
    Calendar,
  },

  data() {
    return {
      days: '',
      fromDate: '',
      toDate: '',
      numAdults: 0,
      numChildren: 0,
      totalPrice: 0,
    }
  },

  methods: {
    recive(data) {
      this.days = data
    },

    confirmDates(from, to) {
      this.fromDate = from
      this.toDate = to
    },

    confirmGuest(adults, children, sum) {
      this.numAdults = adults
      this.numChildren = children
      this.totalPrice = sum
    },

    book() {
      let receipt = {
        startDate: this.fromDate,
        endDate: this.toDate,
        numAdult: this.numAdults,
        numChild: this.numChildren,
        totalPrice: this.totalPrice,
        rentalObjectId: this.object.id,
        userId: '-PNU45UnVwW-HWRbJWe_H',
      }

      this.$store.dispatch('postReceipt', receipt)
    },
  },
}
</script>

<style scoped>
.container {
  padding: 10px;
  min-width: 20rem;
  border: 0.1px solid black;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 290px;
  border-radius: 5px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 5px 0 rgba(0, 0, 0, 0.2);
}

@media screen and (max-width: 340px) {
  .container {
    min-width: 12rem;
  }
}

button {
  background-image: linear-gradient(147deg, #42b883 0%, #15975c 84%);
  width: 50%;
  max-width: 300px;
  color: white;
  border: none;
  margin: 0 auto;
  border-radius: 5px;
  padding: 1rem 1.4rem;
  cursor: pointer;

  text-align: center;
}
</style>
