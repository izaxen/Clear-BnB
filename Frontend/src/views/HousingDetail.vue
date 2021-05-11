<template>
  <div v-if="!fetching" class="wrapper">
    <!-- Bilderna ska inte vara hårdkodade -->
    <div class="hero-picture">
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        alt=""
      />
      <div class="picture-text">
        {{ rentalObject.freeText }}
      </div>
      <div class="pic-city">{{ rentalObject.city }}</div>
    </div>
    <div class="slider">
      <!-- Bilderna ska inte vara hårdkodade -->
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        alt=""
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        alt=""
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        alt=""
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        alt=""
      />
    </div>
    <hr class="separator" />

    <div class="seller-info">
      <ul>
        <li>{{ rentalObject.availableBeds }} Beds</li>
        <li>{{ rentalObject.price }} kr /night</li>
        <li>{{ rentalObject.address }}</li>
      </ul>
      <div class="avatar">
        {{ user.firstName }}{{ user.lastName }}
        <img src="https://www.shankarainfra.com/img/avatar.png" alt="" />
      </div>
    </div>

    <hr class="separator" />
    <div class="hero">
      <div class="amenity-focus"></div>

      <div class="hero-text">
        <DisplayHotAmenity :amenities="amenities" />
        {{ rentalObject.description }}
      </div>
      <BookHousingForm :object="rentalObject" @receipt="saveTempReceipt" />
    </div>

    <hr class="separator" />
    <div class="hej">
      <div class="amenities">
        <AmenityLoggo
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
import AmenityLoggo from '../components/AmenityLoggo.vue'
import BookingConfirmation from './BookingConfirmation.vue'

import store from '../store.js'
export default {
  components: {
    BookHousingForm,
    AmenityLoggo,
    BookingConfirmation,
    DisplayHotAmenity,
  },

  data() {
    return {
      fetching: true,
      rentalObject: {},
      bookingReceipts: {},
      amenities: {},
      tempReceipt: {},
      user: '',
    }
  },

  async beforeRouteEnter(to, from, next) {
    await store.dispatch('fetchReceipts')

    await store.dispatch('fetchRentalObjectById', to.params.id)

    next()
  },

  methods: {
    saveTempReceipt(receipt) {
      this.tempReceipt = receipt
      console.log('körd')
    },

    async fetch() {
      let id = this.$route.params.id
      let res = await fetch(`/rest/rental-objects/${id}`)
      this.rentalObject = await res.json()
      this.amenities = this.rentalObject.amenities

      this.user = await fetch(`/rest/users/${this.rentalObject.userID}`)
    },
  },

  async created() {
    this.rentalObject = this.$store.state.rentalObject
    this.amenities = this.rentalObject.amenities
    this.fetching = false
  },
}
</script>

<style scoped>
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
  max-width: 65rem;
  margin: auto;
  padding: 1rem;
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
  height: 60vh;
  display: flex;
  flex-direction: column;
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

  .hero-text {
    margin-bottom: 2rem;
  }
}
</style>
