<template>
  <form @submit.prevent="addUser">
    <input
      v-model="firstName"
      required
      type="text"
      placeholder="Enter firstname"
    />
    <input
      v-model="lastName"
      required
      type="text"
      placeholder="Enter lastname"
    />
    <input v-model="email" required type="text" placeholder="Enter email" />
    <input
      v-model="phoneNumber"
      required
      type="text"
      placeholder="Enter phonenumber"
    />
    <input
      v-model="password"
      required
      type="text"
      placeholder="Enter password"
    />
    <input
      v-model="rePassword"
      required
      type="text"
      placeholder="Re-enter password"
    />
    <p v-if="userTaken === true">User already exists</p>
    <div class="register-btn">
      <button type="reset">clear</button>
      <div v-if="validatePassword">
        <!-- Kan vara att detta inte funkar-->
        <button>create user</button>
      </div>
      <div v-else>Password don´t match</div>
    </div>
  </form>
</template>

<script>
import store from '../../store.js'
export default {
  computed: {
    validatePassword() {
      console.log('Valiedate', this.password, this.rePassword)
      return this.rePassword === this.password
    },
    userTaken() {
      return (this.userExists = this.$store.state.failedLogIn)
    },
  },
  data() {
    return {
      firstName: '',
      lastName: '',
      email: '',
      phoneNumber: '',
      password: '',
      rePassword: '',
      userExists: false,
    }
  },
  methods: {
    addUser() {
      let user = {
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phoneNumber: this.phoneNumber,
        password: this.password,
      }

      this.$store.dispatch('registerUser', user)
      if (this.userExists === true) {
        console.log('inside test')
        return
      } else {
        console.log('User', user)
        store.commit('setFailedLogin', false)
        //this.$emit('close');
      }
    },
  },
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
button {
  width: 120px;
  margin: 10px 10px;
  background-color: rgb(130, 193, 130);
  color: white;
  border: none;
  border-radius: 5px;
}
button:hover {
  cursor: pointer;
  background-color: rgb(130, 193, 130);
  transform: scale(1.05);
}
input:focus {
  outline: none;
}
.register-btn {
  display: flex;
  justify-content: center;
}

p {
  color: red;
  font-weight: 800;
  text-decoration: underline;
}
</style>
