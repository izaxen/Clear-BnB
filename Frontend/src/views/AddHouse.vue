<template>
<div class="house-view">
  <div class="house-view2">
  <div class="sidebar"><SideBar /></div>
<div class=shell>
<div class="addhouse">
  <div class="row1">
  <div class="objectform">
    <Calendar @dates="inAndOutDate" />
    <AddRentalObjectForm @fetchObject="houseForm" />
  </div>

<div class="add-images">

<AddImageForm @formData="LoadFormData"/>
</div></div>

<div class="row2">
  <div class="amenities">
<AddHouseAmenities @amenitieslist ="amenitiesList" />
  </div></div>
  
</div>



<button @click="combineFormAndList">Add rental object</button>
</div>
</div>
</div>
</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue';
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'
import Calendar from '../components/Calendar.vue'
import AddImageForm from '../components/AddImageForm.vue'
import SideBar from '../components/Sidebar.vue'

export default {
  components:{
    AddHouseAmenities,
    AddRentalObjectForm,
    Calendar,
    AddImageForm,
    SideBar
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
.house-view {
  width: 100%;

}

.house-view2{
  position: relative;
}
.sidebar {
  position: absolute;
  top: 0;
  left: 0;
}

.shell{
  max-width: 65rem;
  margin: auto;
  padding: 1px;
}

.row1{
  display:grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "lhTop rhTop";
  }

.add-images{
  margin-top:15px;
  grid-area: rhTop;
}
.objectform{
  width: 290px;
  margin-right: 60px;
  margin-top:15px;
  grid-area: lhTop;
}
.amenties{
  grid-area: bottom;
  width: 100%;
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