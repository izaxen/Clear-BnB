<template>
  <div class="container">
    <Calendar :booking="true" @days-selected="receive" @dates="confirmDates"
      ><template v-slot:start><p class="font-bigger">Check in</p></template
      ><template v-slot:end><p class="font-bigger">Check out</p></template>
    </Calendar>
    <NumberOfGuests
      @num-guest="confirmGuest"
      :numOfDays="days"
      :price="object.price"
    />
    <button @click="book" :disabled="receipt.totalPrice == 0 ? '' : disabled" 
    class="mouse-cursor-gradient-tracking">
      <span>Book</span>
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
   mounted(){
     let button = document.querySelector('.mouse-cursor-gradient-tracking')
     console.log(button)
      button.addEventListener('mousemove', e => {
      let rect = e.target.getBoundingClientRect()
      let x = e.clientX - rect.left;
      let y = e.clientY - rect.top;
      button.style.setProperty('--x', x + 'px')
      button.style.setProperty('--y', y + 'px')
    });
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

      // emailjs.send(serviceID, templateID, templateParams, userID).then(
      //   function (response) {
      //     console.log('SUCCESS!', response.status, response.text)
      //   },
      //   function (error) {
      //     console.log('FAILED...', error)
      //   }
      // )
    },
  },
}
</script>

<style scoped>

.font-bigger{
  font-size: 1.3rem;
  margin-bottom:0.2rem;
}

.container {
  background-color: rgba(247, 247, 247, 0.938);
  padding: 10px;
  width: 300px;
  border: 0.1px solid black;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  border-radius: 5px;
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 5px 0 rgba(0, 0, 0, 0.2);
}

.calendar {
  align-self: center;
  font-size: 20px;
}

button {
  width: calc(100% - 20px);
  min-height: 3rem;
  border-radius: 5px;
   box-shadow: gray 1px 1px 1px 1px;
  font-weight: 600;
  text-align: center;
  margin-bottom: 1rem;
  background-color: #007973a6;
  padding: 0;
}

button:disabled {
  cursor: not-allowed;
}

.mouse-cursor-gradient-tracking {
  position: relative;
  padding: 0.5rem 1rem;
  font-size: 1.2rem;
  border: none;
  cursor: pointer;
  outline: none;
  overflow: hidden;
  color: white;
}

.mouse-cursor-gradient-tracking span {
  position: relative;
}

.mouse-cursor-gradient-tracking::before {
  --size: 0;
  content: '';
  position: absolute;
  left: var(--x);
  top: var(--y);
  width: var(--size);
  height: var(--size);
  background: radial-gradient(circle at center, 
  #1bafa8a6 0%,#007973a6 30%, rgb(53, 82, 53)55%, rgb(109, 133, 109)70%, transparent);
  transform: translate(-55%, -50%);
  transition: width 0.8s ease;
}

.mouse-cursor-gradient-tracking:hover::before {
  --size: 900px;
}

button span{
  padding: 2rem 5rem;
  width: 200px;
}

@media screen and (max-width: 600px) {
  .container {
    align-self: center;
    width: 300px;
  }
}
@media screen and (max-width: 450px) {
  .container {
    min-width: 300px;
    min-height: 300px;
  }
}

@media screen and (max-width: 330px){
  
  .container{
    transform: scale(0.85);
  }
}
</style>
