<template>
<Calendar :textOne="textOne" :disabledDates="disableObject" :rentalObject="rentalObject"/>
<AddRentalObjectForm />
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
    disableObject: new Date("2021-05-25"),
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