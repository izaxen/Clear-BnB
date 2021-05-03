<template>
  <div>
    <BookHousingForm />
    <Amenity v-for="(value, name) in amenities" :key="name" :amenity="value" />
    {{ value }} {{ name }}
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
    this.rentalObject = await fetch(`/rest/rental-objects/${id}`)
      .then((res) => res.json())
      .then((this.amenities = res.amenities))

    console.log(this.amenities)
  },
}
</script>

<style></style>
