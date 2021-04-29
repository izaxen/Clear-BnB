<template>
  <form @submit.prevent="loginUser">
    <input v-model="userName" required type="text" placeholder="Enter email">
    <input v-model="password" required type="text" placeholder="Enter password">
   <div>
    <button type="reset">clear</button>
    <button>login</button>
   </div>
  
    <br>
        <h1 class="logo">ClearBNB</h1>
</form>
</template>

<script>
export default {
  data(){
    return{
      userName:'',
      password:''
    }
  },

  methods:{
    validateLogin(){
      //Continue with valifdate
    }
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
    background-color: #4AAE9B;
    color: white;
    border: none;
    border-radius: 3px;
  }

  button:hover{
    cursor: pointer;
    background-color: #297567;
    transform: scale(1.05);
  
  }

  .logo{
    font-size: 40px;
    font-weight: 900;
    font-style: italic;
    color: black;
  }
</style>