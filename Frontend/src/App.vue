<template>
<div id="app">
  <header>
    <Navbar />
  </header>
  <main>
    <router-view />
  </main>
  <Footer />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'
export default {
  components: {
    Navbar,
    Footer,
  },
  created() {
    this.$store.dispatch('fetchRentalObjects')
    this.$store.dispatch('whoAmI')
  },
}
</script>

<style scoped>
  header{
    width: 100%;
  }

</style>
