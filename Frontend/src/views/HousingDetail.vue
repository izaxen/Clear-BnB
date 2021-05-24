<template>
  <div v-if="!fetching" class="wrapper">
    <RentalImages :object="rentalObject" @showPic="openModal"/>
    <hr class="separator" />

    <div class="seller-info">
      <ul>
        <li>{{ rentalObject.availableBeds }} Beds</li>
        <li>{{ rentalObject.price }} kr /night</li>
        <li>{{ rentalObject.address }}</li>
      </ul>
      <div class="avatar">
        {{ landLord.firstName }} {{ landLord.lastName }}
        <img src="https://www.shankarainfra.com/img/avatar.png" alt="" />
      </div>
    </div>

    <hr class="separator" />
    <div class="hero">
      <div class="hero-text">
        <h2>{{ rentalObject.city }}</h2>
        <h4>{{ rentalObject.address }}</h4>
      </div>
      <div class="hero-amenity"><DisplayHotAmenity :amenities="amenities" /></div>
      <div class="bookingForm"><BookHousingForm :object="rentalObject" @receipt="saveTempReceipt" /></div>
    </div>
    <div class="disc">
        {{ rentalObject.description }}
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
    <div class="overlay" v-show="showPic">
      <div class="modal" v-show="showPic" @click="none">
      <div class="imgcontainer" v-for="img in imageList" :key="img">
          <img :src="img" alt="">
      </div>
      <button class="close" @click="closeModal">X</button>
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
      imageList: [],
      showPic: false,
    }
  },

  async beforeRouteEnter(to, from, next) {
    await store.dispatch('getFileUrl', to.params.id)
    await store.dispatch('fetchRentalReceipts', to.params.id)
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
    openModal(){
      this.showPic = true
      console.log('set modal true');
    },
    closeModal(){
      this.showPic = false
      console.log('clicked close modal');
    },
  },

  async created() {
    this.imageList = await this.$store.state.imageList
    this.rentalObject = this.$store.state.rentalObject
    this.amenities = this.rentalObject.amenities
    this.landLord = this.$store.state.landLord
    this.fetching = false  
  },
}
</script>

<style scoped>
.close {
  position: absolute;
  top: 8px;
  right: 8px;
  z-index: 5;
  height: 50px;
  width: 50px;
  font-size: 20px;
  font-weight: 700;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  height: 100vh;
  width: 100%;
  background: rgba(0, 0, 0, 0.698);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 3;
}


.modal {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(450px, 1fr));
  grid-gap: 3px;
  padding: 5px;
  background: rgba(255, 255, 255, 0.883);
  width: 8  0%;
  max-height: 900px;
  max-width: 60%;
  overflow: scroll;
  overflow: auto;
  position: absolute;
  z-index: 5;
}

.disc {
  display: flex;
  align-items: center;
  margin: 3rem 1rem;
  font-size: 25px;
}

h2 {
  margin-top: 0;
}
.avatar {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
}
ul {
  display: flex;
  align-items: center;
  padding: 0;
  width: 100%;
  list-style-type: none;
}
li {
  margin-right: 2rem;
}
.wrapper {
  margin: auto;
  padding: 1rem;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  background-color: rgba(255, 255, 255, 0.89);
  max-width: 65rem;
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
  display: grid;
}

.am {
  display: flex;
  flex-direction: column;
}

.hero {
  margin: 15px 0;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 0.7fr 1fr;
  grid-template-areas:
  "box1 box3"
  "box2 box3";
}
.hero-amenity {
  grid-area: box2;
}
.bookingForm{
  display: grid;
  justify-content: flex-end;
  grid-area: box3;
  margin-bottom: 20px;
}

.hero-text {
  padding: 0 1rem;
  font-size: 30px;
  grid-area: box1;
}
.hero-text h4,h2 {
  margin: 0;
}
.hero-text h4 {
  font-weight: 200;
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

.amenity {
  margin-bottom: 10px;
}

.seller-info {
  margin: 1rem 0;
  padding-left: 1rem;
  display: flex;
  width: 100%;
  font-weight: 700;
  font-size: 30px;
}

.seller-info img {
  height: 52px;
  width: 52px;
  border-radius: 50%;
  margin-left: 20px;
  margin-right: 20px;
}

.amenities {
  padding: 1rem;
  justify-self: center;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: auto auto auto auto;
  grid-column-gap: 80px;
}

img {
  border-radius: 5px;

  width: 100%;
  height: 100%;
  display: block; /* remove extra space below image */
}
@media screen and (max-width: 1100px) {
  .amenities{
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: auto auto auto;
    grid-column-gap: 80px;
  }
}
@media screen and (max-width: 920px) {
  .seller-info {
    font-size: 20px;
  } 
  .modal {
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    width: 80%;
  }
}
@media screen and (min-height: 1000px) {
  .modal {
    height: 80%;
  }
}
@media screen and (max-height: 850px) {
  .modal {
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    height: 80%;
  }
}
@media screen and (max-width: 750px) {
  .bookingForm{
    justify-content: center;
  }

  .avatar {
    display: none;
  }
  ul {
    display: flex;
    justify-content: space-evenly;
  }

  .hero-text {
    text-align: center;
    margin-bottom: 20px;
  }

  .hero {
    grid-template-columns: 1fr;
    grid-template-rows: auto auto auto;
    grid-template-areas:
    "box1"
    "box2"
    "box3";
  }
  .amenities{
    width: 100%;
    justify-items: center;
  }
}

@media screen and (max-width: 600px) {
  .seller-info {
    justify-content: space-between;
    width: 100%;
    margin: 0;
  }

  .disc {
    margin-bottom: 2rem;
    font-size: 20px;
  }
  .amenities{
    grid-template-columns: 1fr 1fr;
    grid-template-rows: auto auto auto;
    grid-column-gap: 40px;
  }
  .modal {
    max-width: 70%;
  }

}
@media screen and (max-width: 450px){
  .bookingForm {
    max-width: 450px;
  }
  .bookingForm .container {
    height: 250px;
    width: 320px;
  }
}
@media screen and (max-width: 400px){
  .bookingForm .container {
    height: 250px;
    width: 260px;
  }

  .hero-amenity .container {
    padding: 0;
  }
}
</style>
