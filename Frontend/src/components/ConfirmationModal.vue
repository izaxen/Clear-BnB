<template>
<div class="center">
<div class="modal-frame" v-if="$store.state.user" v-show="$store.state.isConfirmation">
  <slot name = "header">Oops, something went wrong!</slot>
  <slot name = "user">Name: {{$store.state.user.firstName}} {{$store.state.user.lastName}}</slot>

  <div class="dates">
  <slot name = "startDate"></slot>
  <slot name = "startTime"></slot>
  <slot name = "endDate"></slot>
  <slot name = "endTime"></slot>
  </div>

  <div class="rentalInfo" v-if="rentalObject != undefined">
  <slot name= "address" >Adress: {{rentalObject.address}}</slot>
  <slot name = "zip">Zip-code: {{rentalObject.zipcode}}</slot>
  <slot name = "city">City: {{rentalObject.city}}</slot>
  </div>

  <slot name = "beds"></slot>
  <slot name = "price"></slot>
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
      rentalObject: {}
    }
  },

  watch:{
    '$route'(){
      this.$store.state.isConfirmation = false
    },
    '$store.state.rentalObjects'(){
      this.setRentalObject()
    }

  },

  methods: {
    closeModal(){
      this.$store.commit('setIsConfirmation', false)
    },
    setRentalObject(){
      let rentalId = this.$route.params.id
      this.rentalObject = this.$store.state.rentalObjects.find((r) => r.id == rentalId)
    }
   
  },

  created(){
    this.$store.dispatch('fetchRentalObjects')
  }

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

</style>