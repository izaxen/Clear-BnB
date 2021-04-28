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
import Amenitie from './components/Amenitie.vue'
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'

export default {
  components: {
    Navbar,
    Footer,
    Amenitie,
  },
}
</script>
