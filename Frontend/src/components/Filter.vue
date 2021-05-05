<template>
  <div class="wrapper">
    <h3>Filter</h3>
    <select v-model="city">
      <option value="">All cities</option>
      <option v-for="object in cityOption" :key="object.id" :value="object">
        {{ object }}
      </option>
    </select>
    <input type="text" v-model="text" placeholder="text" />
    <label for="vol">Price {{ range }} kr</label>
    <input type="range" v-model="range" min="300" max="1500" step="10" />
    <input type="number" v-model="beds" min="1" placeholder="Number of beds" />
  </div>

  <RentalObject
    v-for="object in filterObjects"
    :key="object.id"
    :object="object"
  />
  <div v-if="filterObjects.length == 0">No match</div>
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
      cityOption: '',
      range: 900,
      beds: '',
    }
  },

  async created() {
    await this.$store.dispatch('fetchRentalObjects')
    this.objects = await this.$store.state.rentalObjects
    let unfilteredArr = []
    this.objects.forEach((o) => {
      unfilteredArr.push(o.city)
    })

    let removedDuplicates = unfilteredArr.filter((value, index) => {
      return unfilteredArr.indexOf(value) === index
    })
    this.cityOption = removedDuplicates

    if (this.$store.state.searchObject) {
      this.city = this.$store.state.searchObject.city
      this.beds = this.$store.state.searchObject.guests
      this.$store.commit('removeSearchObject')
    }
  },

  computed: {
    filterObjects: function () {
      return this.filterObjectByBeds(
        this.filterObjectsByPrice(
          this.filterObjectsByCity(
            this.filterObjectsByDescription(this.objects)
          )
        )
      )
    },
  },

  methods: {
    filterObjectsByCity(objects) {
      if (!this.city) {
        return objects
      }
      return objects.filter((object) => object.city == this.city)
    },

    filterObjectsByDescription(objects) {
      return objects.filter((object) => object.freeText.includes(this.text))
    },

    filterObjectsByPrice(objects) {
      return objects.filter((object) =>
        object.price < this.range ? object : ''
      )
    },

    filterObjectByBeds(objects) {
      return objects.filter((object) =>
        object.availableBeds >= this.beds ? object : ''
      )
    },
  },
}
</script>

<style scoped>
.wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
input,
select {
  height: 32px;
}
</style>
