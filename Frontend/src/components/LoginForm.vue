<template>
  <form @submit.prevent="loginUser">
    <input v-model="userName" required type="text" placeholder="Enter email">
    <input v-model="password" required type="text" placeholder="Enter password">
   
    <button type="reset">Clear</button>
    <button>Login</button>
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

<style>

</style>