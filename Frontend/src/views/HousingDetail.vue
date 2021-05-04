<template>
  <div class="wrapper">
    <!-- Bilderna ska inte vara hårdkodade -->
    <div class="hero-picture">
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
      <div class="picture-text">
        {{ rentalObject.description }}
      </div>
    </div>
    <div class="slider">
      <!-- Bilderna ska inte vara hårdkodade -->
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
    </div>
    <hr class="separator" />

    <div class="seller-info">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Rem asperiores ut
      ab, officiis dolore temporibus.
      <img src="https://www.shankarainfra.com/img/avatar.png" />
    </div>

    <hr class="separator" />
    <div class="hero">
      <div class="amenity-focus"></div>

      <div class="hero-text">
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
        {{ rentalObject.description }}
      </div>
      <BookHousingForm />
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
</template>

<script>
import BookHousingForm from '../components/BookHousingForm.vue'
import AmenityLoggo from '../components/AmenityLoggo.vue'

export default {
  components: {
    BookHousingForm,
    AmenityLoggo,
  },

  data() {
    return {
      rentalObject: '',
      bookingReceipts: '',
      amenities: '',
    }
  },

  async created() {
    let id = this.$route.params.id

    //kolla detta
    let res = await fetch(`/rest/rental-objects/${id}`)
    this.rentalObject = await res.json()
    this.amenities = this.rentalObject.amenities
  },

  async mounted() {},
}
</script>

<style scoped>
.separator {
  width: 99%;
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
  padding: 1rem;
}
.hero-picture {
  height: 50vh;
  position: relative;
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

  display: flex;

  width: 50%;
  font-size: 0.8rem;
}

.seller-info img {
  height: 32px;
  width: 32px;
  border-radius: 50%;
}

.amenities {
  height: 30vh;
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
</style>
