<template>
<div class=shell>
<div class="addhouse">
  
  <div class="objectform">
<AddRentalObjectForm />
  </div>
  <div class="amenities">
<AddHouseAmenities />
  </div>
  
</div>
<button @click="">Add house</button>
</div>
</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue';
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'

export default {
  components:{
    AddHouseAmenities,
    AddRentalObjectForm
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