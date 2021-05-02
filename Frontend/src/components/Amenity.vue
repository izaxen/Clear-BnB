<template>
  <div class="amenity">
    <img :src="amenity.iconUrl" alt="" srcset="" />
    <h2>{{ amenity.title }}</h2>
  </div>
</template>

<script>
export default {
  props: ['amenity'],
}
</script>

<style scoped>
h2 {
  padding: 0;
  margin: 0;
  font-size: 1rem;
}
.amenity {
  display: flex;
  flex-direction: row;
}
img {
  align-self: center;
  height: 16px;
  width: 16px;
}
</style>
