<template>
  <input v-model="textSearch" type="text" placeholder="search city..." />

  <RentalObject
    v-for="object of filterObjects"
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

  // -> filtreratobject från store
  // -> filtreratobject från store eller store.state.rentalObjects?

  computed: {
    filterObjects() {
      return this.$store.state.rentalObjects.filter(
        (object) => !object.city.indexOf(this.name)
      )
    },
  },
}
</script>

<style scoped></style>
