<template>
  <div>
    <div class="detail-pictures">
      <div class="pic-1">
        <img
          src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        />
      </div>
      <div class="pic-2">
        <img
          src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        />
      </div>
      <div class="pic-3">
        <img
          src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        />
      </div>
      <div class="pic-5">
        <img
          src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
        />
      </div>
    </div>

    <div class="seller-info">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Rem asperiores ut
      ab, officiis dolore temporibus. Nesciunt, laudantium beatae incidunt illo
      nihil eum, nemo maiores, non tempore nobis adipisci excepturi quas?
    </div>

    <hr class="separator" />
    <div class="hero">
      <div class="amenity-focus">
        <li>
          <ul>
            1
          </ul>
          <ul>
            1
          </ul>
          <ul>
            1
          </ul>
          <ul>
            1
          </ul>
          <ul>
            1
          </ul>
          <ul>
            1
          </ul>
        </li>
      </div>
      <div class="hero-text">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus nisi
        saepe dicta dolore quidem quo odit aliquid fugiat cumque laboriosam?
        Itaque maiores sapiente aliquam beatae ratione magni consectetur
        assumenda quisquam?Lorem ipsum dolor sit amet consectetur adipisicing
        elit. Minima quidem, suscipit laudantium quia ea omnis voluptatibus
        porro repellendus molestias earum dolor, quos accusamus cum error
        quibusdam pariatur architecto. Repudiandae, delectus.
      </div>
      <BookHousingForm />
    </div>

    <hr class="separator" />
    <div class="hej">
      <div class="am">
        <Amenity
          v-for="am of rentalObject.amenities"
          :key="am.id"
          :amenity="am"
        />
      </div>
      <div class="am">
        <Amenity
          v-for="am of rentalObject.amenities"
          :key="am.id"
          :amenity="am"
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
    this.amenities = await fetch(
      `/rest/rental-objects/${id}/amenities/`
    ).then((res) => res.json())
  },
}
</script>

<style scoped>
.separator {
  width: 100%;
  height: 1px;
  background-color: black;
}

.hej {
  display: flex;
  justify-content: space-evenly;
}

.am {
  display: flex;
  flex-direction: column;
}

.hero-text {
  padding: 1rem;
}
.detail-pictures {
  display: flex;
  min-height: 50vh;
}

@media screen and (max-width: 800px) {
  .pic-5 {
    display: none;
  }
}
@media screen and (max-width: 600px) {
  .pic-5,
  .pic-2,
  .pic-3 {
    display: none;
  }
}

.hero {
  display: flex;
  justify-content: space-between;
}

img {
  object-fit: cover;
  width: 100%;
  min-height: 100%;
}

.amenity {
  margin-bottom: 10px;
}
</style>
