<template>
  <div class="container">
    <Calendar
      :rentalObject="object"
      :booking="true"
      @days-selected="recive"
      @dates="confirmDates"
    />
    <NumberOfGuests @num-guest="confirmGuest" :numOfDays="days" />

    <button @click="book" :disabled="totalPrice == 0 ? '' : disabled">
      Book
    </button>

    <LoginModal
      v-show="isModalVisible"
      @close="closeModal"
      @login="checkLogin"
    />
  </div>
</template>

<script>
import NumberOfGuests from './rentalPriceCalculator.vue'
import Calendar from './Calendar.vue'
import LoginModal from '../views/LoginModal.vue'

export default {
  props: ['object'],

  components: {
    NumberOfGuests,
    Calendar,
    LoginModal,
  },

  data() {
    return {
      days: '',
      isModalVisible: false,
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

    closeModal() {
      this.isModalVisible = false
    },

    checkLogin() {
      console.log('here')
      console.log(this.$store.state.user == null)
      console.log('here')
      if (!this.$store.state.user) {
        return
      } else {
        this.isModalVisible = false
      }
    },

    book() {
      this.$store.dispatch('postReceipt', this.receipt)
      this.$store.commit('setIsConfirmation', true)
      this.$emit('receipt', this.receipt)
      if (!this.$store.state.user) {
        this.isModalVisible = true
        return
      }
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
  background-image: linear-gradient(147deg, #b3cde0 1%, #6497b1 99%);
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

button:disabled {
  background-image: linear-gradient(147deg, #979a9c 1%, #889195 99%);
  cursor: not-allowed;
}
</style>
