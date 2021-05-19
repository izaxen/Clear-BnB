<template>
  <div @click="openMenu" v-bind:class="[open ? 'active' : null, 'content']">
    <router-link to="/"><em class="fas fa-home"></em>Home</router-link>

    <router-link to="/my-page" v-if="loggedIn !== null">
      <i class="fas fa-user"></i>
      My Page</router-link
    >

    <router-link to="/overview">
      <i class="fas fa-filter"></i>
      Overview
    </router-link>

    <router-link to="" @click="login" v-if="loggedIn === null">
      <i class="fas fa-sign-in-alt"></i>
      Login
    </router-link>
    <router-link to="" @click="logout" v-if="loggedIn !== null">
      <i class="fas fa-sign-out-alt"></i>
      Logout
    </router-link>
  </div>
</template>

<script>
export default {
  props: ['open'],

  methods: {
    openMenu() {
      this.$emit('show', !this.open)
    },

    login() {
      this.$emit('login')
    },

    logout() {
      this.$emit('logout')
    },
  },

  computed: {
    loggedIn() {
      if (this.$store.state.user !== null) return (this.isModalVisible = false)
      return this.$store.state.user
    },
  },
}
</script>

<style scoped>
.content {
  display: none;
  flex-direction: row;
  z-index: 50;
  min-width: 100%;
  min-height: 10vh;
  background: rgb(219, 240, 219);

  /* fixa med display none */
  transform: translateY(-200%);
  transition: all 0.4s;
  justify-content: space-around;
  align-items: center;
  font-size: 1.2rem;
}

a {
  text-decoration: none;
  color: black;
}

.links {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}

.active {
  display: flex;
  transform: translateY(0);
}
</style>
