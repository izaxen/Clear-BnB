<template>
  <input v-model="textSearch" type="text" placeholder="search city..." />

  <RentalObject
    v-for="object of rentalObjects"
    :key="object.id"
    :object="object"
  />
</template>

<script>
import RentalObject from './RentalObject.vue'
export default {
  components: {
    RentalObject,
  },

  data() {
    return {
      textSearch: '',
    }
  },

  computed: {
    rentalObjects() {
      if (this.textSearch) {
        return this.$store.state.rentalObjects.filter((object) => {
          let city = object.city.toLowerCase()
          let search = this.textSearch.toLowerCase()
          if (city.includes(search)) {
            return object
          }
        })
      } else {
        return this.$store.state.rentalObjects
      }
    },
  },
}
</script>

<style scoped></style>
