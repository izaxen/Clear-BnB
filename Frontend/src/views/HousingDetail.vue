<template>
  <Amenity v-for="am of rentalObject.amenities" :key="am.id" :amenity="am" />
  <BookingForm />
</template>

<script>
import Amenity from '../components/Amenity.vue'
import BookingForm from '../components/BookingForm.vue'

export default {
  components: {
    Amenity,
    BookingForm,
  },

  data() {
    return {
      rentalObject: null,
    }
  },

  async created() {
    let id = this.$route.params.id
    this.rentalObject = await fetch(`/rest/rental-objects/${id}`).then((res) =>
      res.json()
    )
  },
}
</script>

<style></style>
