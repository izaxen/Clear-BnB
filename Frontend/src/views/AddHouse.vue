<template>
<div class=shell>
<div class="addhouse">
  
  <div class="objectform">
    <Calendar @dates="inAndOutDate" />
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
    AddRentalObjectForm,
    Calendar
  },

  data(){
return{
  rentalamenities:'',
  rentalForm:'',
  fromDate:'',
  toDate:'',  
  user: null,
}
  },
  methods:{
  amenitiesList(list){
  this.rentalAmenities = list
    },
  houseForm(form){
   this.rentalForm = form
  },
  inAndOutDate(from,to){
    this.fromDate = from
    this.toDate = to
  },
  combineFormAndList(){
    let rentalObjects = {}
    this.user = this.$store.state.user
    let items  =  Object.entries(this.rentalForm)
    
    for(let item of items){
      let spliceRentalForm = {
        [item[0]]:item[1]
        }
      rentalObjects = Object.assign({}, rentalObjects, spliceRentalForm)
    }
    
    let completeAmanities = {amenities: this.rentalAmenities}
    let availableTo = {availableTo:this.toDate}
    let availableFrom = {availableFrom:this.fromDate}
    let userId = {userId: this.user.id}

    rentalObjects = Object.assign({},rentalObjects, completeAmanities, availableTo,availableFrom, userId)
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
  width: fit-content;
  margin-right: 60px;
}

</style>