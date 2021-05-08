<template>
<div class="center">
<div class="modal-frame" v-if="$store.state.user" v-show="$store.state.isConfirmation">
  <slot name = "header">Oops, something went wrong!</slot>
  <slot name = "user">Name: {{$store.state.user.firstName}} {{$store.state.user.lastName}}</slot>
  <slot name = "startDate" :startDate="startDate">{{startDate}}</slot>
  <slot name = "startTime"></slot>
  <slot name = "endDate"></slot>
  <slot name = "endTime"></slot>
  <slot name= "address"></slot>
  <slot name = "zip"></slot>
  <slot name = "city"></slot>
  <slot name = "beds"></slot>
  <slot name = "price"></slot>
  <button @click="closeModal">Ok</button>
  </div>
</div>
  
</template>

<script>
export default {
  props:["startDate", "endDate"],

  watch:{
    '$route'(){
      this.$store.state.isConfirmation = false
      console.log('watch', this.$store.state.isConfirmation)
    }

  },

  methods: {
    closeModal(){
      this.$store.commit('setIsConfirmation', false)
    }
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