<template>
  <div>
    <BookHousingForm />
    <Amenity v-for="am of amenities" :key="am.id" :amenity="am" />
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

<style></style>
