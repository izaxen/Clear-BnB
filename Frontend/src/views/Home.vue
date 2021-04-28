<template>
  <h1>Home</h1>

  <!-- Bara för att testa restAPIN -->
  <div v-for="object in rentalObjects" :key="object.id">
    <Amenity v-for="a in object.amenities" :key="a.id" :amenity="a" />
  </div>
  <!-- HIT -->
</template>

<script>
import Amenity from '../components/Amenity.vue'

export default {
  components: {
    Amenity,
  },

  computed: {
    rentalObjects() {
      return this.$store.state.rentalObjects
    },
  },
}
</script>

<style></style>
