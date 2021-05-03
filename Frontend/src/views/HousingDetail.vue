<template>
  <div>
    <div class="hero-picture">
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
      <div class="picture-text">
        {{ rentalObject.description }}
      </div>
    </div>
    <div class="slider">
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
      </div>
      <BookHousingForm />
    </div>

    <hr class="separator" />
    <div class="hej">
      <div class="am">
        <Amenity
          v-for="(name, value) in amenities"
          :key="name"
          :amenity="value"
        />
      </div>
      <div class="am">
        <Amenity
          v-for="(name, value) in amenities"
          :key="name"
          :amenity="value"
        />
      </div>
    </div>
  </div>
</template>

<script>
import Amenity from '../components/Amenity.vue'
import BookHousingForm from '../components/BookHousingForm.vue'

export default {
  components: {
    Amenity,
    BookHousingForm,
  },

  data() {
    return {
      rentalObject: null,
      amenities: null,
    }
  },

  async created() {
    let id = this.$route.params.id
    this.rentalObject = await fetch(`/rest/rental-objects/${id}`).then((res) =>
      res.json()
    )

    this.amenities = this.rentalObject.amenities

    console.log(this.amenities)
  },
}
</script>

<style scoped>
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

.hero-text {
  padding: 1rem;
}
.hero-picture {
  height: 50vh;
  position: relative;
  z-index: -1;
}

.slider {
  display: flex;
  justify-content: space-around;
  margin: 10px;
}
.slider img {
  height: 100px;
  width: 80px;
}

.hero {
  display: flex;
  justify-content: space-between;
}

.amenity {
  margin-bottom: 10px;
}

.seller-info {
  margin: 10px;
  display: flex;

  width: 50%;
  font-size: 0.8rem;
}

.seller-info img {
  height: 32px;
  width: 32px;
  border-radius: 50%;
}

img {
  width: 100%;
  height: 100%;
  display: block; /* remove extra space below image */
}
</style>
