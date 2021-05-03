<template>
  <form @submit.prevent="loginUser">
    <input v-model="email" type="text" placeholder="Enter email">
    <input v-model="password" type="text" placeholder="Enter password">
    <p v-if="wrongInput===true">Wrong username/password</p>
   <div>
    <button type="reset">clear</button>
    <button @click="login">login</button>
   </div>
  
    <br>
        <h1 class="logo">ClearBNB</h1>
</form>
</template>

<script>
export default {
  data(){
    return{
      email:'',
      password:''
    }
  },
  computed: {
    wrongInput(){
      return this.$store.state.failedLogIn
    }
  },
  methods:{
    login() {
      let credentials = {
        email: this.email,
        password: this.password
      }
      this.$store.dispatch('login', credentials) 
    },
    
  }
}
</script>

<style scoped>
  form {
    display: grid;
    grid-template-columns: 1fr;
  }
  input {
    margin: 4px;
    text-decoration: none;
    width: 300px;
    height: 25px;
    justify-self: center;
    align-self: center;
  }
  p{
    color: red;
  }
  div {
    display: flex;
    justify-content: center;
  }
  button {
    width: 100px;
    align-self: center;
    justify-self: center;
    margin-right: 10px;
    margin-top: 20px;
    background-color: #05b3df;
    color: white;
    border: none;
    border-radius: 3px;
  }
  button:hover{
    cursor: pointer;
    background-color: #05b3df;
    transform: scale(1.05);
  
  }
  .logo{
    font-size: 40px;
    font-weight: 900;
    font-style: italic;
    color: black;
  }
</style>