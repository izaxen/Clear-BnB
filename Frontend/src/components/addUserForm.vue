<template>
  <form @submit.prevent="addUser">
    <input v-model ="firstName" required type="text" placeholder="Enter firstname">
    <input v-model ="lastName" required type="text" placeholder="Enter lastname">
    <input v-model ="email" required type="text" placeholder="Enter email">
    <input v-model ="phoneNumber" required type="text" placeholder="Enter phonenumber">
    <input v-model ="password" required type="text" placeholder="Enter password">
    <input v-model ="rePassword" required type="text" placeholder="Re-enter password">

    <button type="reset"></button>
    <div v-if="validatePassword">  <!-- Kan vara att detta inte funkar-->
      <button>Create user</button></div>
    <div v-else>
      Password don´t match
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

    this.$store.dispatch('postUser', user)
    this.$router.push('/user/') //Här vill jag ha userid men det skapas automatiskt på serven??
    }
  }
}
</script>

<style>
input, button{
  margin-bottom: 15px ;
  padding: 5px;
  width: 100%;
  border-radius: 7px;
  border: 1px solid black;

}

button{
  width: 100px;
  margin: 0 25px;
}
input:focus{
  outline: none;
}

</style>