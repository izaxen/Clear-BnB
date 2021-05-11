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
  async created() {
    await this.$store.dispatch('fetchRentalObjects')
    await this.$store.dispatch('whoAmI')
    await this.$store.dispatch('fetchReceipts')
  },
}
</script>

<style scoped>
  header{
    width: 100%;
  }

</style>
