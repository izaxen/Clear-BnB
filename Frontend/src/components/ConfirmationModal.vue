<template>
<div class="center">
<div class="modal-frame" v-if="$store.state.user" v-show="$store.state.isConfirmation">
  <slot name = "header">Oops, something went wrong!</slot>
  <slot name = "user">Name: {{$store.state.user.firstName}} {{$store.state.user.lastName}}</slot>

  <div class="dates">
  <div class="start-date"><slot name = "start-date-text"></slot>
  <slot name = "start-time"></slot>
  <p>{{startDateString}}</p></div>
  <div class="end-date">
  <slot name = "end-date-text"></slot>
  <p>{{endDateString}}</p>
  <slot name = "end-time"></slot>
  </div>
  </div>
  <slot name = "beds"></slot>
  <slot name = "price"></slot>

  <div class="rental-info" v-if="rentalObject != undefined">
  <slot name= "address" >Adress: {{rentalObject.address}}</slot>
  <slot name = "city">City: {{rentalObject.city}}</slot>
  <slot name = "zip">Zip-code: {{rentalObject.zipCode}}</slot>
  </div>

  
  <button @click="closeModal">Ok</button>
  </div>
</div>
  
</template>

<script>
export default {
  props:["startDate", "endDate"],

  data(){
    return{
      rentalId: null,
      rentalObject: {},
      endDateString: '',
      startDateString: '',
    }
  },

  watch:{
    '$route'(){
      this.$store.state.isConfirmation = false
    },
    '$store.state.rentalObjects'(){
      this.setRentalObject()
    },
    startDate(){
    this.startDateString = this.getDateAsString(this.startDate)
    console.log('startDate')
    },
    endDate(){
    this.endDateString = this.getDateAsString(this.endDate)
    },

  },

  methods: {
    closeModal(){
      this.$store.commit('setIsConfirmation', false)
    },
    setRentalObject(){
      let rentalId = this.$route.params.id
      this.rentalObject = this.$store.state.rentalObjects.find((r) => r.id == rentalId)
    },
    getDateAsString(date){
    let year = date.getFullYear();
    let month = date.getMonth() + 1
    let day = date.getDate()
    if(day < 10){
      day = '0' + day
    }
    if(month < 10){
      month = '0' + month 
    }

    return 'yyyy-mm-dd', year + "-" + month + "-" + day
    }
   
  },
  created(){
    this.$store.dispatch('fetchRentalObjects')
  },
}

</script>

<style scoped>


.modal-frame{
  display: flex;
  flex-direction: column;
  border: 3px solid black;
  width: 60%;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 30%;
  background-color: whitesmoke;
  }

.center{
  display: flex;
  justify-content: center;
  text-align: center;
  width: 100%;
}

div{
  display: flex;
  flex-direction: column;
}

.rental-info{
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  margin-bottom: 20px;
}

</style>