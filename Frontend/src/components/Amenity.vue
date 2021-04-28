<template>
  <div class="amenity">
    <img :src="amenity.iconUrl" alt="" srcset="" />
    <h2>{{ amenity.text }}</h2>
  </div>
</template>

<script>
export default {
  props: ['amenity'],
}
</script>

<style scoped>
.amenity {
  display: flex;
  flex-direction: row;
}
img {
  align-self: center;
  height: 32px;
  width: 32px;
}
</style>
