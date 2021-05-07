<template>
<div class="modal-frame" v-show="$store.state.isConfirmation">
  <slot name = "header">Oops, something went wrong!</slot>
  <slot name = "user"></slot>
  <slot name = "startDate"></slot>
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
  
</template>

<script>
export default {
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
  width: 100px;
  height: 100vh;
  justify-self: center;
  align-self: center;
  }

</style>