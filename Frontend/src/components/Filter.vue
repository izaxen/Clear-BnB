<template>
  <div class="wrapper container">
    <div class="filter">
      <div class="right-box">
        <div class="input-holder">
      <select class="city" v-model="city">
        <option value="">All cities</option>
        <option v-for="object in cityOption" :key="object.id" :value="object">
          {{ object }}
        </option>
      </select>
        <input class="number-input"
         type="number"
         v-model="beds"
         min="1"
         placeholder="Beds"
        />
        </div>
      <input class="search" type="text" v-model="text" placeholder="Search..." />
      </div>
      <div class="price-box"><label class="price" for="vol">Price {{ range }} kr</label>
      <input type="range" v-model="range" min="300" max="1500" step="10" />
      </div>
    </div>
  </div>

  <RentalObject
    v-for="object in filterObjects"
    :key="object.id"
    :object="object"
  />
  <div class="no-match" v-if="filterObjects.length == 0">No match</div>
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
            this.filterObjectsByText(this.objects)
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

    filterObjectsByText(objects) {
      return objects.filter((object) => object.freeText.toUpperCase().includes(this.text.toUpperCase()) || object.description.toUpperCase().includes(this.text.toUpperCase()) || object.address.toUpperCase().includes(this.text.toUpperCase()))
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
.filter {
  margin-top: 0.2rem;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.no-match {
  font-size: 3rem;
}

.wrapper {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 2rem;
  background-color: rgb(245, 245, 245);
  box-shadow: 1px 1px 2px 1px rgb(175, 170, 170);
  width: 100%;
  font-size: 1.2rem;
}

.container {
  padding: 2rem;
}
input,
select {
  height: 32px;
  border-radius: 5px;
  border: 1px solid rgb(126, 126, 126);
  color: black;
}

.number-input{
  width: 20%;
}

.price-box{
  display: flex;
  height: 32px;
  align-items: center;
  flex-direction: column;
  align-self: flex-end;
  margin-bottom: 0.5rem;
}

.price{
  margin-right: 1rem;
}

.city{
  width: 47%;
  margin-right: 3%;
}

.search{
  margin-top: 0.5rem;
  width: 70%;
}

input[type=range]{
    -webkit-appearance: none;
    border: none;
    background-color: rgb(245, 245, 245);
    width: 150px;
}

input[type=range]::-webkit-slider-runnable-track {
    width: 50px;
    height: 0.4rem;
    background: rgb(219, 240, 219);
    border: 1px solid rgb(134, 128, 128);
    border-radius: 10px;
}

input[type=range]::-moz-range-track{
    width: 150px;
    height: 0.3rem;
    background: rgb(219, 240, 219);
    border: 1px solid rgb(134, 128, 128);
    border-radius: 10px;
}

input[type=range]:focus::-webkit-slider-runnable-track {
    background: rgba(210, 241, 210, 0.329);
}


input[type=range]::-webkit-slider-thumb {
    -webkit-appearance: none;
    border: none;
    height: 1rem;
    width: 0.7rem;
    border-radius: 30px 1px 30px 1px;
    border: 1px solid rgb(27, 65, 27);
    background: #007973;
    margin-top: -0.3rem;
}

input[type=range]::-moz-range-thumb{
    border: none;
    height: 0.9rem;
    width: 0.6rem;
    border-radius: 30px 1px 30px 1px;
    border: 1px solid rgb(27, 65, 27);
    background: #007973;
    margin-top: -0.3rem;
}


@media screen and (max-width: 840px) {

}

@media screen and (max-width: 600px) {
  .price-box{
    flex-direction: column;
  }

  .input-holder, .right-box{
   display: flex;
   align-items: center;
   justify-content: center;
   margin-top: 0.5rem;
  }

  .right-box{
   flex-direction: column;
  }
  .price-box{
    align-self: center;
    margin: 1.2rem;
  }

  .filter {
    flex-direction: column;
    justify-content:center;
    width: 20rem;
    flex-shrink: 2;
  }

  .wrapper{
    justify-content: center;
    padding: 0;
  }
}
</style>
