<template>
<div>
<h3>Accessable amenities</h3>
<form class="addhouse" @submit.prevent>
  
<div class="box-amenities">
  
    <div v-for="(key, value) in amenities" :key="key" class= "amenities">
    <div class="amen">
     
      <AmentiyLoggo
      :value="key"
      :name="value"
  />  
    <input type="checkbox" :value="value"  class="checkboxx" v-model="selectedAmenities">
    </div>
  </div>
</div>
</form>
</div>
</template>

<script>
import AmentiyLoggo from './AmenityLoggo.vue'

export default {

watch:{
selectedAmenities: function(){
  this.addAmenitiesToList()
},
},

    methods:{
    addAmenitiesToList(){
      let selected = Object.values(this.selectedAmenities)
      let filterList = Object.keys(this.amenities)
      let newList={}
      let addToNewList
      for(let amenity of filterList){
        if(!selected.includes(amenity)){
        addToNewList={
        [amenity]:false
        }
      }
      else{
        addToNewList={ [amenity]:true }
      }
      newList = Object.assign({},newList,  addToNewList)
      }
    
    this.$emit('amenitieslist', newList)
      }
    },

  data(){
  return{
    amenities: {
      wifi:true,//
      smartTv: true,//
      partyAllowed: true,//
      petsAllowed: true,//
      smokingAllowed: true,//
      fireplace: true,//
      parking: true,//
      freeParking: true,//
      selfCheckIn: true,//
      airCondition: true,//
      hairDryer: true,//
      dishwasher: true,//
      pool: true,//
      bathtub: true,//
      iron: true,//
      elevator: true,//
      kitchen: true,//
      heating: true,//
      bedroomEssentials: true,//
      bathroomEssentials: true,//
      coffeeMaker: true,//
  },
  selectedAmenities:[],
  }
  },
  
  components:{
    AmentiyLoggo
  }
}

</script>

<style scoped>

h3{
  display: flex;
  justify-content: center;
}
.addhouse{
  margin-top: 30px;
}

.amen{
  display: flex;
  justify-content: space-between;
  width:  160px;
}

.amenities{
  display: flex;
  float: left;
  width: 200px;
  margin-bottom: 15px;
  margin-left: 15px;
  background-color: rgba(240, 240, 240, 0.548);
  }

@media only screen and (max-width: 575px){
  h3{
    margin: 15px;
    justify-content: flex-start;
  }
}

</style>