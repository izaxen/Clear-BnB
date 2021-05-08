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

<AddImageForm @formData="LoadFormData"/>

<button @click="combineFormAndList">Add house</button>
</div>

</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue';
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'
import Calendar from '../components/Calendar.vue'
import AddImageForm from '../components/AddImageForm.vue'


export default {
  components:{
    AddHouseAmenities,
    AddRentalObjectForm,
    Calendar,
    AddImageForm
  },

  data(){
return{
  rentalamenities:'',
  rentalForm:'',
  fromDate:'',
  toDate:'',  
  user: null,
  formData: '',
  
}
  },
  methods:{
LoadFormData(formData){
  this.formData= formData
  },

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
  async combineFormAndList(){
    let rentalObjects = this.rentalForm
    this.user = this.$store.state.user
 
    let completeAmanities = {amenities: this.rentalAmenities}
    let availableTo = {availableTo:this.toDate}
    let availableFrom = {availableFrom:this.fromDate}
    let userId = {userId: this.user.id}

    rentalObjects = Object.assign({},rentalObjects, completeAmanities, availableTo,availableFrom, userId)
    let rentalId = await this.$store.dispatch('postRentalObject', rentalObjects)
    
    let object = {
      formData: this.formData,
      rentalId: rentalId
    }
    
    this.$store.dispatch('uploadFiles', object )
  }
  }
}
</script>

<style scoped>
.addhouse{
  display:flex;
  
  
  
  
  
}
.objectform{
  width: 290px;
  margin-right: 60px;
  margin-top:15px;
}
.amenties{
  flex-shrink: 2;
}

@media only screen and (max-width: 575px){
  .addhouse{
    display: flex;
    flex-wrap:wrap;
    margin-right: 0;
    justify-content: center;
  }

  .objectform{
    width: 100%;
    
    
  }

}

</style>