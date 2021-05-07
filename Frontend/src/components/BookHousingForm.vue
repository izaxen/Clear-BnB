<template>
  <div class="container">
    <Calendar @days-selected="receive" @dates="confirmDates" />
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
      receipt: {
        startDate: '',
        endDate: '',
        numAdult: 0,
        numChild: 0,
        totalPrice: 0,
        rentalObjectId: this.$route.params.id,
        userId: '-PNU45UnVwW-HWRbJWe_H'
      },
    }
  },

  methods: {
    receive(data) {
      this.days = data
    },

    confirmDates(from, to) {
      this.receipt.startDate = from
      this.receipt.endDate = to
    },

    confirmGuest(adults, children, sum) {
      this.receipt.numAdult = adults
      this.receipt.numChild = children
      this.receipt.totalPrice = sum
    },

    book() {
      console.log(this.receipt)

      this.$store.dispatch('postReceipt', this.receipt)
      this.$store.commit('setIsConfirmation', true)

    },
  },
}
</script>

<style scoped>
.container {
  padding: 10px;
  width: 140rem;
  border: 0.1px solid black;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 290px;
  border-radius: 5px;
}
</style>
