<template>
  <form @submit.prevent="loginUser">
    <input class="border-radius border-grey" v-model="email" type="text" placeholder="Enter email" />
    <input
      class="border-radius border-grey"
      v-model="password"
      required
      type="password"
      placeholder="Enter password"
    />
    <p v-if="wrongInput === true">Wrong username/password</p>
    <div>
      <button type="reset">Clear</button>
      <button @click="login">Login</button>
    </div>

    <br />
    <h1 class="logo">ClearBNB</h1>
  </form>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      password: '',
    }
  },
  computed: {
    wrongInput() {
      return this.$store.state.failedLogIn
    },
  },
  methods: {
    async login() {
      let credentials = {
        email: this.email,
        password: this.password,
      }
      await this.$store.dispatch('login', credentials)
      this.$emit('login')
    },
  },
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
  height: 40px;
  justify-self: center;
  align-self: center;
}
p {
  color: red;
}
div {
  display: flex;
  justify-content: space-around;
  margin-top:20
}
button {
  width: 120px;
  align-self: center;
  justify-self: center;
  
  margin-top: 30px;
  background-color: #007973a6;
  color: white;
  border: none;
  border-radius: 3px;
  padding: 5px;
}
button:hover {
  cursor: pointer;
  background-color: #007973a6;
  transform: scale(1.05);
}
.logo {
  font-size: 40px;
  font-weight: 900;
  font-style: italic;
  color: black;
}

input{
  padding: 5px 10px;
}
</style>
