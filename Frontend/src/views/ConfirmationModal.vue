<template>
<div class="modal-frame">
  <slot name = "header">Your choices have been saved!</slot>
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
</div>
  
</template>

<script>
export default {

}
</script>

<style scoped>


.modal-frame{
  display: flex;
  border: 3px solid black;
  width: 100px;
  flex-direction: column;
  align-self: center;
  justify-self: center;
}

</style>