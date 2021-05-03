<template>
<div>
  <BookHousingForm />
  <Amenity v-for="am of amenities" :key="am.id" :amenity="am" />
  <Calendar :rentalObject="rentalObject"  :disableObject="disableObject"/>
</div>
</template>

<script>
import Amenity from '../components/Amenity.vue'
import Calendar from '../components/Calendar.vue'
import BookHousingForm from '../components/BookHousingForm.vue'

export default {
  components: {
    Amenity,
    Calendar,
    BookHousingForm,
  },

  data() {
    return {
      rentalObject: null,
      bookingReceipts: null,
      amenities: null,
    }
  },

  async created() {
    let id = this.$route.params.id
    this.rentalObject = await fetch(`/rest/rental-objects/${id}`).then((res) =>
      res.json()
    )
    //this.$store.dispatch('fetchReceipts', id)
    this.amenities = await fetch(
      `/rest/rental-objects/${id}/amenities/`
    ).then((res) => res.json())
  },
}
</script>

<style></style>
