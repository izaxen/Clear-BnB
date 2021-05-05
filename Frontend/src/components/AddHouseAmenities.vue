<template>
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
</template>

<script>
import AmentiyLoggo from './AmenityLoggo.vue'

export default {

watch:{
selectedAmenities: function(){
    let selected = Object.values(this.selectedAmenities)
    let filterList = Object.keys(this.amenities)
     
    let newList ={}
    let addToNewList
    for(let amenity of filterList){
       if(!selected.includes(amenity)){
      addToNewList={
      [amenity]:false
    }
      }
      else{
        addToNewList={
          [amenity]:true
        }
      }
      newList = Object.assign({},newList,  addToNewList)
      }
    
    console.log('newlist', newList)
    } 

 },

 methods:{
   addToObject(){
     console.log('addToobjekt')
     return 'hhh'
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

.amen{
  display: flex;
  justify-content: space-between;
  width:  160px;
}

.amenities{
  display: flex;
  float: left;
  width: 200px;
  margin-bottom: 25px;
  margin-left: 15px;
  }

.amenities:nth-child(3n+1){
clear: both;
}

</style>