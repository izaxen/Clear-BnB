<template>
<div>
  <nav>
    <div @click="openMenu" class="menu">=</div>
    <div class="links">
    <router-link id="img-router" to="/"><img id="logo" src="../assets/clearbnb-grey-house.png" alt=""></router-link>
    <router-link to="/overview">Overview</router-link>
    </div>
    
    <div class="search-bar">
      <SearchBar @showSearchModal="showSearchModal" />
    </div>

  


    <div class="Login-btn">
      <router-link to="" @click="showModalLogin" v-if="loggedIn === null">
        <i class="fas fa-user-circle"></i>
      </router-link>
      <div v-if="loggedIn != null" class="show">
        <i class="fas fa-bars"></i>
        <i class="fas fa-user-circle"></i>
        <div class="user-links">
         
          <router-link to="/my-page" v-if="loggedIn !== null">
            My Page</router-link
          >
          <router-link to="" @click="logout" v-if="loggedIn !== null">
            Log out</router-link
          >
        </div>
      </div>
    </div>

    <LoginModal v-show="isModalVisible" @close="closeModal"></LoginModal>
  </nav>
  <SearchBarModal v-show="isSearchModalVisible" @close="exitModal" />
  <Hamburger
    @login="showModalLogin"
    @logout="logout"
    @show="openMenu"
    :open="showHamburger"
  />
</div>
</template>

<script>
import LoginModal from '../views/LoginModal.vue'
import SearchBar from './SearchBar.vue'
import SearchBarModal from './SearchBarModal.vue'
import Hamburger from '../components/Sidebar/HamburgerMenu.vue'

export default {
  components: {
    LoginModal,
    SearchBar,
    SearchBarModal,
    Hamburger,
  },
  data() {
    return {
      isModalVisible: false,
      isSearchModalVisible: false,
      showHamburger: false,
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
      this.$router.push('/')
    },

    openMenu() {
      this.showHamburger = !this.showHamburger
    },
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@300;400;700&display=swap');

#logo{
  margin-top: 5px;
  max-height: 50px;
  align-self: center;
}


nav {
  display: flex;
  justify-content: space-between;
  background: white;
  color: black;
  height: 4.3rem;
  box-shadow: rgb(75, 72, 72) 4px 2px 10px 0;
  align-items: center;
  font-family: 'Dosis bold', Arial, Helvetica, sans-serif;
  font-size: 22px;
}

.search-bar {
  position: absolute;
  left: 50%;
  transform: translate(-50%);
  z-index: 3;
}
.home-btns {
  grid-area: Home;
  margin-left: 30px;
}
.links {
  display: flex;
  align-items: center;
}
.links a {
  margin: 10px;
}
.Login-btn {
  justify-self: right;
  margin-right: 1.1rem;
  border-radius: 50px;
  cursor: pointer;
}

.user-links {
  display: flex;
  flex-direction: column;
  overflow: hidden;
  justify-content: center;
  align-content: center;
  position: absolute;
  top: 50px;
  right: 50px;
  width: 0;
  height: 0;
  background: white;
  border-radius: 10px;
  z-index: 10;
  transition: height 0.4s;
}

.show:hover > .user-links {
  height: 100px;
  width: 200px;
}

.fa-user-circle {
  font-size: 2rem;
  color:  #007973a6;
}

.fa-bars {
  font-size: 1.5rem;
  margin-right: 0.6rem;
}

a {
  text-decoration: none;
  color: rgb(0, 0, 0);
  border-radius: 50px;
  padding: 10px;
  text-align: center;
}
 a:hover{
  background: rgb(219, 240, 219);
 }

 #img-router:hover{
   background: none;

 }

.menu {
  margin-left: 1rem;

  display: none;
  font-size: 4rem;
}

@media screen and (max-width: 850px) {
  .links {
    display: none;
  }
  .menu {
    display: flex;
  }
}

@media screen and (max-width: 580px) {
  .search-bar {
    position: inherit;
  }

  .Login-btn {
    display: none;
  }
}
</style>
