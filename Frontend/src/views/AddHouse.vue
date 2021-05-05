<template>
<div class=shell>
<div class="addhouse">
  
  <div class="objectform">
    <Calendar />
<AddRentalObjectForm @fetchObject="houseForm" />
  </div>
  <div class="amenities">
<AddHouseAmenities @amenitieslist ="amenitiesList" />
  </div>
  
</div>
<button @click="combineFormAndList">Add house</button>
</div>
</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue';
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'
import Calendar from '../components/Calendar.vue'

export default {
  components:{
    AddHouseAmenities,
    AddRentalObjectForm
  },

  data(){
return{
  rentalamenities:'',
  rentalForm:'',
  
}
  },
  methods:{
  amenitiesList(list){
  this.rentalAmenities = list
    },
  houseForm(form){
   this.rentalForm = form
  },
  combineFormAndList(){
    let rentalObjects = {}
      
    let items  =  Object.entries(this.rentalForm)
    
    for(let item of items){
      let spliceRentalForm = {
        [item[0]]:item[1]
        }
      rentalObjects = Object.assign({}, rentalObjects, spliceRentalForm)
    }
    
    let completeAmanities = {
      amenities: this.rentalAmenities
    }
    rentalObjects = Object.assign({},rentalObjects, completeAmanities)
    

    this.$store.dispatch('postRentalObject', rentalObjects)

  }

  }
  
}
</script>

<style scoped>
.addhouse{
  display:flex;
}
.objectform{
  margin-right: 60px;
}

</style>