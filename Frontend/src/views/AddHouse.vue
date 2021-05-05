<template>
<div class="addhouse">
<AddRentalObjectForm />
<AddHouseAmenities />
  
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

<style>

</style>