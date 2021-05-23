<template>
  <div class="container">
    <Calendar :booking="true" @days-selected="receive" @dates="confirmDates" />
    <NumberOfGuests
      @num-guest="confirmGuest"
      :numOfDays="days"
      :price="object.price"
    />

    <button @click="book" :disabled="receipt.totalPrice == 0 ? '' : disabled">
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
import emailjs from 'emailjs-com'

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
        userId: '',
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
      if (!this.$store.state.user) {
        return
      } else {
        this.isModalVisible = false
      }
    },

    book() {
      if (!this.$store.state.user) {
        this.isModalVisible = true
        return
      }
      this.receipt.userId = this.$store.state.user.id
      this.sendEmail()
      this.$store.dispatch('postReceipt', this.receipt)
      this.$store.commit('setIsConfirmation', true)
      this.$emit('receipt', this.receipt)
    },

    sendEmail() {
      let templateParams = {
        to_name: this.$store.state.user.firstName,
        email: this.$store.state.user.email,
        check_in: this.receipt.startDate,
        check_out: this.receipt.endDate,
        price: this.receipt.totalPrice,
        city: this.$store.state.rentalObject.city,
        address: this.$store.state.rentalObject.address,
        num_booked: this.$store.state.rentalObject.address,
        from_name: 'Clear BnB',
      }

      let serviceID = 'service_6txoxfd'
      let templateID = 'template_v1jnjqf'
      let userID = 'user_PITuQ6yClqXAIlNw6sizK'

      emailjs.send(serviceID, templateID, templateParams, userID).then(
        function (response) {
          console.log('SUCCESS!', response.status, response.text)
        },
        function (error) {
          console.log('FAILED...', error)
        }
      )
    },
  },
}
</script>

<style scoped>
.container {
  background-color: rgba(255, 255, 255, 0.717);
  padding: 10px;
  width: 350px;
  border: 0.1px solid black;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 290px;
  border-radius: 5px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 5px 0 rgba(0, 0, 0, 0.2);
}

.calendar {
  align-self: center;
  font-size: 20px;
}

@media screen and (max-width: 600px) {
  .container {
    align-self: center;
    width: 350px;
  }
}
@media screen and (max-width: 450px){
  .container {
    height: 20px;
  }
}

button {
  background: rgb(201, 232, 201);

  width: 50%;
  max-width: 300px;
  font-size: 1.4rem;
  border: none;
  margin: 0 auto;
  border-radius: 5px;
  padding: 0.6rem 1.4rem;
  cursor: pointer;
  border: 1px solid black;
  text-align: center;
}

button:disabled {
  background: rgb(166, 166, 166);

  cursor: not-allowed;
}
</style>
