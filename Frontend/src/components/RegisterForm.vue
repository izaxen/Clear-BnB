<template>
  <form @submit.prevent="addUser">
    <input v-model ="firstName" required type="text" placeholder="Enter firstname">
    <input v-model ="lastName" required type="text" placeholder="Enter lastName">
    <input v-model ="email" required type="text" placeholder="Enter email">
    <input v-model ="phoneNumber" required type="text" placeholder="Enter phoneNumber">
    <input v-model ="password" required type="text" placeholder="Enter password">
    <input v-model ="rePassword" required type="text" placeholder="Re-enter password">

    <button type="reset"></button>
    <div v-if="password === rePassword">  <!-- Kan vara att detta inte funkar-->
      <button>Create user</button></div>
    <div v-else>
      Password don´t match
    </div>
    </form>
    
</template>



<script>
export default {

  data(){
    return{
      firstName:'',
      lasteName:'',
      email:'',
      phoneNumber:'',
      password:''
    }
  },
  methods:
  addUser(){
    
  }
}
</script>

<style>

</style>