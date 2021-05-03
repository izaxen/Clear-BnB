<template>
  <div v-for="(key, value) in object" :key="key">{{ key }} {{ value }}</div>
</template>

<script>
export default {
  props: ['object'],
}
</script>

<style scoped>
div {
  font-size: 0.6rem;
}
</style>
