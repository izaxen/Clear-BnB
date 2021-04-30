<template>
  <nav>
    <router-link to ="/">Home</router-link>
    <router-link to="/my-page" v-if="loggedIn!==null">My Page</router-link>
    <router-link to="" @click="showModalLogin" v-if="loggedIn===null">Login</router-link>
    <router-link to="" @click="logout" v-if="loggedIn!==null">Logout</router-link>
    <LoginModal v-show="isModalVisible" @close="closeModal"></LoginModal>
  </nav>
</template>

<script>
import LoginModal from '../views/LoginModal.vue'
export default {
  components: {
    LoginModal
  },
  data(){
    return {
      isModalVisible: false
    };
  },

  computed: {
    loggedIn(){
      if(this.$store.state.user !== null)
        return this.isModalVisible = false;
      return this.$store.state.user
    }
  },
  
  methods: {
    showModalLogin() {
        this.isModalVisible = true;
    },
    closeModal() {
       console.log('inside close modal');
       this.isModalVisible = false;
    },
    logout(){
      this.$store.dispatch('logout')
    }
  }

}
</script>

<style scoped>
nav {
  padding: 10px;
  background-image: linear-gradient(
    #bff8ee,
    #4AAE9B
  );
  color: black;
  font-weight: 800;
  box-shadow: 0 0 5px 2px;
  text-align: center;
  font-size: 20px;
}

a{
  text-decoration: none;
  color: rgb(0, 0, 0);
  margin: 20px;
  
}

a:hover{
  text-decoration: underline;
}


</style>