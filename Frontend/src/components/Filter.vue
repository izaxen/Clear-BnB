<template>
  <input v-model="textSearch" type="text" placeholder="search city..." />

  <!-- <rentalObjects
    v-for="object of rentalObjects"
    v-bind:key="recipe.id" 
    v-bind:recipe="recipe" 
  /> -->
</template>

<script>
export default {
  components: {},

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
            return recipe
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
