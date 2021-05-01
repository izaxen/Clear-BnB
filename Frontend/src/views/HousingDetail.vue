<template>
<div>
  <Calendar :rentalObject="rentalObject"  :disableObject="disableObject"/>
  <Amenity v-for="am of rentalObject.amenities" :key="am.id" :amenity="am" />
</div>
</template>

<script>
import Amenity from '../components/Amenity.vue'
import Calendar from '../components/Calendar.vue'

export default {
  components: {
    Amenity,
    Calendar,
  },

  data() {
    return {
      rentalObject: null,
      bookingReceipts: null,
    }
  },

  async created() {
    let id = this.$route.params.id
    this.rentalObject = await fetch(`/rest/rental-objects/${id}`).then((res) =>
      res.json()
    )
    //this.$store.dispatch('fetchReceipts', id)
  },
}
</script>

<style></style>
