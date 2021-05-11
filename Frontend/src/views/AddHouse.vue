<template>
<div class=shell>
  <h1>Add rental object</h1>
  <div class="addhouse">
    <div class="row1">
      <div class="objectform">
      <Calendar @dates="inAndOutDate" />
      <AddRentalObjectForm ref="formClearFields" @fetchObject="houseForm" />
      </div>

<div class="add-images">
<h3>Add pictures</h3>
<AddImageForm @formData="LoadFormData"/>
</div></div>

<div class="row2">
  <div class="amenities">
  <AddHouseAmenities @amenitieslist ="amenitiesList" />
  </div>  
  </div>
  
</div>

<div class="row3">
<label id="add-rental" @click="combineFormAndList; $refs.formClearFields.clearFields()">Add rental object</label>
</div>
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
  clearList: {},
  
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
  display: grid;
  grid-template-rows:auto auto auto;
  grid-template-areas: 
  "top"
  "mid"
  "bottom";


}

.shell{
  max-width: 65rem;
  margin: auto;
  padding: 1px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
}

.row1{
  grid-area: top;
  display:grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "lhTop rhTop";
  
  }
  .row2{
    grid-area: mid;
    display: flex;
    justify-content: center;
  }

  .row3{
    grid-area: bottom;
    margin: 20px;
    display: flex;
    justify-content: center;
  }

.add-images{
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

h3{
  display: flex;
  justify-content: flex-start;
  margin:15px;
}

label{
  padding: 3px;
  border:1px solid black;
  border-radius: 10px;
  font-size: 90%;
  background-color: rgb(233, 233, 233);
 }

 h1{
   margin: 10px;
   display: flex;
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

  .row1{
  grid-area: top;
  display:grid;
  grid-template-rows: auto auto;
  grid-template-areas: 
  "lhTop"
  "rhTop";
  }

}

</style>