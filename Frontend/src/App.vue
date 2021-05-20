<template>
  <header>
    <Navbar />
  </header>
  <main>
    <router-view />
  </main>
  <Footer />
</template>

<script>
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'
export default {
  components: {
    Navbar,
    Footer,
  },
  async created() {
    // await this.$store.dispatch('whoAmI')
    await this.$store.dispatch('fetchReceipts')
    await this.$store.dispatch('fetchCityNames')
  },
}
</script>

<style scoped>
header {
  width: 100%;
  z-index: 1;
}
</style>
