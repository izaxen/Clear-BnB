<template>
<Calendar :rentalObject="rentalObject"  :disableObject="disableObject"/>

</template>



<script>
import Calendar from '../components/Calendar.vue'

export default {
  components:{
  Calendar,
  },
  data(){
    return{
    rentalObject : new Date("2021-06-03"),
    disableObject: new Date("2021-05-25")
    }
  }

}
</script>

<style>

</style>