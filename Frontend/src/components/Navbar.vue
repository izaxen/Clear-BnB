<template>
  <nav>
    <router-link to ="/">Home</router-link>
    |
    <router-link to="/my-page">My Page</router-link>
    |
    <router-link to="/Login" @click="showModal">Login</router-link>
    <Modal
      v-show="isModalVisible"
      @close="closeModal"
    />
   
  </nav>
</template>

<script>
import Modal from '../views/LoginModal.vue'
export default {
  components: {
    Modal
  },
  data(){
    return {
      isModalVisible: false
    };
  },
  
  methods: {
    showModal() {
        this.isModalVisible = true;
      },
      closeModal() {
        console.log('inside close modal');
        this.isModalVisible = false;
      }
  }

}
</script>

<style scoped>
nav {
  padding: 10px;
  background-image: linear-gradient(
    rgb(208, 255, 164),
    rgba(77, 224, 9, 0.787)
  );

box-shadow: 0 0 5px 5px;
}
a{
  text-decoration: none;
  color: rgb(0, 0, 0);
  
}

a:hover{
  text-decoration: underline;
}


</style>