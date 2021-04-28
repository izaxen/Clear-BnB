<template>
  <Amenity v-for="am of rentalObject.amenities" :key="am.id" :amenity="am" />
</template>

<script>
import Amenity from '../components/Amenity.vue'

export default {
  components: {
    Amenity,
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
