<template>
  <div class="amenitie"></div>
  <img :src="rentalObject.iconUrl" alt="" srcset="" />
  <h2>{{ rentalObject.text }}</h2>
</template>

<script>
export default {
  props: ['rentalObject'],
}
</script>

<style></style>
