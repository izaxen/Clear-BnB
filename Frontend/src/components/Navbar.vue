<template>
  <nav>
    <div class="home-btns">
      <router-link to="/">Home</router-link>
      <router-link to="/my-page" v-if="loggedIn !== null">My Page</router-link>
      <router-link to="/test-page">Test Page</router-link>
      <router-link to="/overview">Overview</router-link>
    </div>
    <div class="Login-btn">
      <router-link to="" @click="showModalLogin" v-if="loggedIn === null"
        >Login</router-link
      >
      <router-link to="" @click="logout" v-if="loggedIn !== null"
        >Logout</router-link
      >
      <LoginModal v-show="isModalVisible" @close="closeModal"></LoginModal>
    </div>

    <div class="search-bar"><SearchBar /></div>
  </nav>
</template>

<script>
import LoginModal from '../views/LoginModal.vue'
import SearchBar from './SearchBar.vue'
export default {
  components: {
    LoginModal,
    SearchBar,
  },
  data() {
    return {
      isModalVisible: false,
    }
  },
  computed: {
    loggedIn() {
      if (this.$store.state.user !== null) return (this.isModalVisible = false)
      return this.$store.state.user
    },
  },
  methods: {
    showModalLogin() {
      this.isModalVisible = true
    },
    closeModal() {
      this.isModalVisible = false
    },
    logout() {
      this.$store.dispatch('logout')
      this.$router.push('/');
    },
  },
}
</script>

<style scoped>
.search-bar {
  grid-area: Search;
  justify-self: center;
}
nav {
  display: grid;
  grid-template-columns: 1fr 2fr 1fr;
  grid-template-areas: 'Home Search Login';
  padding: 10px;
  background: #6497b1;
  color: black;

  box-shadow: 0 0 5px 2px;
  align-items: center;

  border-bottom: 1px solid rgb(167, 167, 167);
}
.home-btns {
  grid-area: Home;
  margin-left: 30px;
}
.home-btns a {
  margin: 10px;
}
.Login-btn {
  grid-area: Login;
  justify-self: right;
  margin-right: 40px;
}
a {
  text-decoration: none;
  color: rgb(0, 0, 0);
}
a:hover {
  text-decoration: underline;
}
</style>
