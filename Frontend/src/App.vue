<template>
  <header></header>

  <Amenitie v-for="ab of this.a.amenities" :key="ab.id" :rentalObject="ab" />
  <main>
    <router-view />
  </main>
</template>

<script>
import Amenitie from './components/Amenitie.vue'
export default {
  components: {
    Amenitie,
  },
}
</script>
