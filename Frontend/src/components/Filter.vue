<template>
  <h3>Filter</h3>
  <select v-model="city">
    <option value="">All cities</option>
    <option v-for="object in objects" :key="object.id" :value="object.city">
      {{ object.city }}
    </option>
  </select>
  <input type="text" v-model="text" placeholder="text" />
  <label for="vol">Price {{ range }} kr</label>
  <input type="range" v-model="range" min="300" max="1000" step="10" />

  <RentalObject
    v-for="object in filterObjects"
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
      text: '',
      city: '',
      objects: [],
      range: 600,
    }
  },

  async created() {
    await this.$store.dispatch('fetchRentalObjects')
    this.objects = await this.$store.state.rentalObjects
    if (this.$store.state.searchObject) {
      this.city = this.$store.state.searchObject.city
      this.$store.commit('removeSearchObject')
    }
  },

  computed: {
    filterObjects: function () {
      return this.filterObjectsByPrice(
        this.filterObjectsByCity(this.filterObjectsByDescription(this.objects))
      )
    },
  },

  methods: {
    filterObjectsByCity(objects) {
      if (!this.city) {
        return objects
      }
      let aa = objects.filter((object) => object.city == this.city)
      console.log(aa)
      return aa
    },

    filterObjectsByDescription(objects) {
      return objects.filter((object) => object.freeText.includes(this.text))
    },

    filterObjectsByPrice(objects) {
      console.log(this.range)
      return objects.filter((object) =>
        object.price < this.range ? object : ''
      )
    },
  },
}
</script>

<style scoped></style>
