<template>
  <nav>
    <div class="menu">=</div>
    <div class="links">
      <router-link to="/">Home</router-link>
      <router-link to="/my-page" v-if="loggedIn !== null">My Page</router-link>
      <router-link to="/overview">Overview</router-link>
    </div>
    <div class="search-bar">
      <SearchBar @showSearchModal="showSearchModal" />
    </div>
    <div class="Login-btn">
      <router-link to="" @click="showModalLogin" v-if="loggedIn === null">
        Login
      </router-link>
      <router-link to="" @click="logout" v-if="loggedIn !== null">
        Logout
      </router-link>
    </div>
  </nav>
  <LoginModal v-show="isModalVisible" @close="closeModal"></LoginModal>
  <SearchBarModal v-show="isSearchModalVisible" @close="exitModal" />
</template>

<script>
import LoginModal from '../views/LoginModal.vue'
import SearchBar from './SearchBar.vue'
import SearchBarModal from './SearchBarModal.vue'
export default {
  components: {
    LoginModal,
    SearchBar,
    SearchBarModal,
  },
  data() {
    return {
      isModalVisible: false,
      isSearchModalVisible: false,
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
    exitModal() {
      this.isSearchModalVisible = false
    },
    showSearchModal() {
      console.log('nav show search')
      this.isSearchModalVisible = true
    },
    logout() {
      this.$store.dispatch('logout')
      this.$router.push('/');
    },
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@300;400;700&display=swap');

nav {
  display: flex;
  justify-content: space-between;
  background-color: white;
  color: black;
  height: 4.3rem;
  box-shadow: rgb(75, 72, 72) 4px 2px 10px 0;
  align-items: center;
  font-family: 'Dosis bold', Arial, Helvetica, sans-serif;
  font-size: 22px;
}

.search-bar{
  position: absolute;
  left: 50%;
  transform: translate(-50%);
   z-index: 3;
}
.home-btns {
  grid-area: Home;
  margin-left: 30px;
}
.links{
  margin-left: 0.7rem;
}
.links a {
  margin: 10px;
}
.Login-btn {
  grid-area: Login;
  justify-self: right;
  margin-right: 1.1rem;
}

a {
  text-decoration: none;
  color: rgb(0, 0, 0);
  border-radius: 50px;
  padding: 10px;
}
a:hover {
  background: rgb(219, 240, 219);
  box-shadow: grey 1px 1px 2px;
  
}

.menu {
  margin-left: 1rem;

  display: none;
  font-size: 4rem;
}

@media screen and (max-width: 800px) {
  .links {
    display: none;
  }
  .menu {
    display: flex;
  }
}
</style>
