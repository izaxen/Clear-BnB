<template>
  <div v-if="!fetching" class="wrapper">
    <RentalImages :object="rentalObject" />
    <hr class="separator" />

    <div class="seller-info">
      <ul>
        <li>{{ rentalObject.availableBeds }} Beds</li>
        <li>{{ rentalObject.price }} kr /night</li>
        <li>{{ rentalObject.address }}</li>
      </ul>
      <div class="avatar">
        {{ landLord.firstName }}{{ landLord.lastName }}
        <img src="https://www.shankarainfra.com/img/avatar.png" alt="" />
      </div>
    </div>

    <hr class="separator" />
    <div class="hero">
      <div class="hero-text">
        <h2>
          {{ rentalObject.city }}
        </h2>
        <h4>
          {{ rentalObject.address }}
        </h4>
        <h5>{{ rentalObject.freeText }}</h5>
        <DisplayHotAmenity :amenities="amenities" />
      </div>
      <div class="disc">
        {{ rentalObject.description }}
      </div>
      <BookHousingForm :object="rentalObject" @receipt="saveTempReceipt" />
    </div>

    <hr class="separator" />
    <div class="hej">
      <div class="amenities">
        <AmenityLogo
          v-for="(key, value) in amenities"
          :key="key"
          :value="key"
          :name="value"
        />
      </div>
    </div>
  </div>
  <BookingConfirmation :receipt="tempReceipt" />
</template>

<script>
import DisplayHotAmenity from '../components/DisplayHotAmenity.vue'
import BookHousingForm from '../components/BookHousingForm.vue'
import AmenityLogo from '../components/AmenityLogo.vue'
import BookingConfirmation from './BookingConfirmation.vue'
import RentalImages from '../components/RentalImages.vue'

import store from '../store.js'
export default {
  components: {
    BookHousingForm,
    AmenityLogo,
    BookingConfirmation,
    DisplayHotAmenity,
    RentalImages,
  },

  data() {
    return {
      fetching: true,
      rentalObject: {},
      bookingReceipts: {},
      amenities: {},
      tempReceipt: {},
      landLord: '',
    }
  },

  async beforeRouteEnter(to, from, next) {
    await store.dispatch('getFileUrl', to.params.id)
    await store.dispatch('fetchReceipts')
    await store.dispatch('fetchRentalObjectById', to.params.id)
    await store.dispatch('fetchLandLord')

    next()
  },
  beforeRouteLeave(to, from, next) {
    this.$store.commit('setRentalObject', null)
    next()
  },

  methods: {
    saveTempReceipt(receipt) {
      this.tempReceipt = receipt
    },
  },

  async created() {
    this.rentalObject = this.$store.state.rentalObject
    this.amenities = this.rentalObject.amenities
    this.landLord = this.$store.state.landLord
    this.fetching = false
  },
}
</script>

<style scoped>
.disc {
  display: flex;
  align-items: center;
  margin: 0 1rem;
}

h2 {
  margin-top: 0;
}
.avatar {
  display: flex;
  font-size: 1rem;
  justify-content: center;
  align-items: center;
}
ul {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
li {
  margin-right: 2rem;
  font-size: 1rem;
}
.wrapper {
  margin: auto;
  padding: 1rem;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  background-color: rgba(205, 205, 205, 0.9);
  max-width: 80rem;
}
.separator {
  width: 100%;
  height: 1px;
  background-color: black;
}

.picture-text {
  position: absolute;
  top: 75%;
  left: 50%;
  transform: translate(-50%, -75%);
  color: whitesmoke;
  font-weight: 700;
  font-size: 2rem;
  min-width: 100%;
  text-align: center;
}

.pic-city {
  position: absolute;
  color: whitesmoke;
  font-weight: 700;
  top: 20px;
  left: 16px;
  font-size: 2rem;
}

.hej {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.am {
  display: flex;
  flex-direction: column;
}

.hero {
  margin: 3rem 0;
}

.hero-text {
  padding: 0 1rem;
}
.hero-picture {
  height: 50vh;
  position: relative;
}
.hero-picture img {
  filter: brightness(50%);
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 10px 0 rgba(0, 0, 0, 0.2);
}

.slider {
  display: flex;
  justify-content: space-around;
  margin: 10px;
}
.slider img {
  height: 100px;
  width: 80px;
  border-radius: 5px;
  margin: 1rem 0;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  transition: 0.5s ease;
}
.slider img:hover {
  opacity: 0.3;
}

.hero {
  display: flex;
  justify-content: space-between;
}

.amenity {
  margin-bottom: 10px;
}

.seller-info {
  margin: 1.5rem 0;
  padding-left: 1rem;
  display: flex;

  width: 60%;
  font-size: 0.8rem;
}

.seller-info img {
  height: 32px;
  width: 32px;
  border-radius: 50%;
  margin-left: 1rem;
}

.amenities {
  padding: 1rem;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

img {
  border-radius: 5px;

  width: 100%;
  height: 100%;
  display: block; /* remove extra space below image */
}

@media screen and (max-width: 600px) {
  .seller-info {
    justify-content: space-between;
    width: 100%;
    margin: 0;
  }
  ul {
    padding: 1rem 0 1rem 1rem;
  }
  li {
    font-size: 0.9rem;
    margin-left: 0;
  }
  .hero {
    display: flex;
    flex-direction: column;
    margin-top: 1rem;
  }

  .disc {
    margin-bottom: 2rem;
  }
}
</style>
