<template>
<div class=shell>
<div class="addhouse">
  
  <div class="objectform">
<AddRentalObjectForm />
  </div>
  <div class="amenities">
<AddHouseAmenities @amenitieslist ="aaa" />
  </div>
  
</div>
<button @click="aaa">Add house</button>
</div>
</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue';
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'

export default {
  components:{
    AddHouseAmenities,
    AddRentalObjectForm
  },
  methods:{
    aaa(list){
  console.log('aaa')
  console.log(list)
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