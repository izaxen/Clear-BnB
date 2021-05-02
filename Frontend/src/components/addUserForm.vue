<template>
  <form @submit.prevent="addUser">
    <input v-model ="firstName" required type="text" placeholder="Enter firstname">
    <input v-model ="lastName" required type="text" placeholder="Enter lastname">
    <input v-model ="email" required type="text" placeholder="Enter email">
    <input v-model ="phoneNumber" required type="text" placeholder="Enter phonenumber">
    <input v-model ="password" required type="text" placeholder="Enter password">
    <input v-model ="rePassword" required type="text" placeholder="Re-enter password">

  <div class="register-btn">
    <button type="reset">clear</button>
    <div v-if="validatePassword">  <!-- Kan vara att detta inte funkar-->
      <button>create user</button></div>
    <div v-else>
      Password don´t match
    </div>
  </div>
    </form>  
</template>



<script>
export default {
  computed:{
    validatePassword(){
      console.log('Valiedate', this.password, this.rePassword)
      return (this.rePassword === this.password)
    }
  },
  data(){
    return{
      firstName:'',
      lastName:'',
      email:'',
      phoneNumber:'',
      password:'',
      rePassword:''
    }
  },
  methods:{
    addUser(){
      let user={
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phoneNumber: this.phoneNumber,
        password: this.password
      }
      console.log('User', user)
    this.$store.dispatch('registerUser', user)
    }
  }
}
</script>

<style scoped>
input {
  margin: 8px;
  text-decoration: none;
  width: 300px;
  height: 25px;
  justify-self: center;
  align-self: center;
}
button{
  width: 120px;
  margin: 10px 10px;
  background-color: #05b3df;
  color: white;
  border: none;
}
button:hover {
  cursor: pointer;
  background-color: #05b3df;
  transform: scale(1.05);
}
input:focus{
  outline: none;
}
.register-btn {
  display: flex;
  justify-content: center;
}
</style>