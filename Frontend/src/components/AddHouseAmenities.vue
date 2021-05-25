<template>
  <div class="shell-amenities border-radius">
    <h3>Accessible amenities</h3>
    <div class="box-amenities">
      <div v-for="(key, value) in amenities" :key="key" class="amenities">
        <div class="amen">
          <AmentiyLoggo :value="key" :name="value" :site="true" />
          <input
            type="checkbox"
            :value="value"
            class="checkboxx"
            v-model="selectedAmenities"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AmentiyLoggo from './AmenityLogo.vue'

export default {
  watch: {
    selectedAmenities: function () {
      this.addAmenitiesToList()
    },
  },

  methods: {
    addAmenitiesToList() {
      let selected = Object.values(this.selectedAmenities)
      console.log('selected ', Object.values(this.selectedAmenities))
      let filterList = Object.keys(this.amenities)

      let newList = {}
      let addToNewList
      for (let amenity of filterList) {
        if (!selected.includes(amenity)) {
          addToNewList = {
            [amenity]: false,
          }
        } else {
          addToNewList = { [amenity]: true }
        }
        newList = Object.assign({}, newList, addToNewList)
      }

      this.$emit('amenitieslist', newList)
    },
  },

  data() {
    return {
      amenities: {
        wifi: true, //
        smartTv: true, //
        partyAllowed: true, //
        petsAllowed: true, //
        smokingAllowed: true, //
        fireplace: true, //
        parking: true, //
        freeParking: true, //
        selfCheckIn: true, //
        airCondition: true, //
        dishwasher: true, //
        pool: true, //
        bathtub: true, //
        iron: true, //
        elevator: true, //
        kitchen: true, //
        heating: true, //
        bedroomEssentials: true, //
        bathroomEssentials: true, //
        coffeeMaker: true, //
      },
      selectedAmenities: [],
    }
  },

  components: {
    AmentiyLoggo,
  },
}
</script>

<style scoped>
.border-radius{
  border-radius:5px;
}

.shell-amenities {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 15px;
  background-color: rgb(245, 245, 245);
  border: 1px solid gray;
  width: 100%;
  
}
.box-amenities {
  margin-top: 30px;
  margin-bottom: 30px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}

h3 {
  display: flex;
  justify-content: center;
}

.amen {
  display: flex;
  justify-content: space-between;
  width: 160px;
}

.amenities {
  display: flex;
  float: left;
  width: 180px;
  margin-bottom: 15px;
  margin-left: 15px;
}

@media only screen and (max-width: 575px) {
  h3 {
    margin: 15px;
    justify-content: flex-start;
  }
}
</style>
