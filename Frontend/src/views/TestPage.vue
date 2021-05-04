<template>
<Calendar :textOne="textOne" :rentalObject="rentalObject"/>
<add-rental-object-form />
</template>



<script>
import Calendar from '../components/Calendar.vue'
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'

export default {
  components:{
  Calendar,
  AddRentalObjectForm,
  },
  data(){
    return{
    /*rentalObject : {
      availableFrom : new Date('2021-06-01'),
      availableTo : new Date('2021-07-01')
      },*/
    rentalObject: {
      id: "2",
      availableFrom: new Date("2021-01-03"),
      availableTo: new Date("2021-07-01")
    }

    
    }
  }

}
</script>

<style>

</style>