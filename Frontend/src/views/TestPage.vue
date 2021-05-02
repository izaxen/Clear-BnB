<template>
<Calendar :disabledDates="disableObject"/>

</template>



<script>
import Calendar from '../components/Calendar.vue'

export default {
  components:{
  Calendar,
  },
  data(){
    return{
    /*rentalObject : {
      availableFrom : new Date('2021-06-01'),
      availableTo : new Date('2021-07-01')
      },*/
    disableObject: new Date("2021-05-25")
    }
  }

}
</script>

<style>

</style>