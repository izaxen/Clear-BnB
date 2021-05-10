<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <slot name="header">
          <h1 v-if="!isVisibility">Login here</h1>
          <h1 v-if="isVisibility">Register here</h1>
        </slot>
        <button type="button" class="btn-close" @click="close">x</button>
      </header>

      <section class="modal-body">
        <slot name="body">
          <LoginForm v-if="!isVisibility" @login="sendLog" />
          <AddUserForm v-if="isVisibility" @close="close" />
        </slot>
      </section>

      <footer class="modal-footer">
        <slot name="footer"></slot>
        <button
          v-if="!isVisibility"
          type="button"
          class="btn-modal"
          @click="registerForm"
        >
          Register
        </button>
        <button
          v-if="isVisibility"
          type="button"
          class="btn-modal"
          @click="registerForm"
        >
          Login
        </button>
      </footer>
    </div>
  </div>
</template>

<script>
import store from '../store.js'
import AddUserForm from '../components/addUserForm.vue'
import LoginForm from '../components/LoginForm.vue'
export default {
  data() {
    return {
      isVisibility: false,
    }
  },
  components: {
    AddUserForm,
    LoginForm,
  },
  computed: {
    loginCheck() {
      return
    },
  },
  name: 'Modal',
  methods: {
    close() {
      this.$emit('close')
      this.isVisibility = false
      store.commit('setFailedLogin', false)
    },

    sendLog() {
      this.$emit('login')
    },

    registerForm() {
      this.isVisibility = !this.isVisibility
      store.commit('setFailedLogin', false)
    },
  },
}
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: grid;
  justify-content: center;
  align-items: center;
  z-index: 10;
}
.modal {
  text-align: center;
  background: #ffffff;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  width: 400px;
  height: 500px;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 15% 75% 10%;
  border-radius: 5px;
  padding: 10px;
  z-index: 11;
}
.modal-header {
  position: relative;
  border-bottom: 1px solid #eeeeee;
  color: #05b3df;
  justify-content: space-between;
}
.modal-footer {
  display: grid;
  grid-template-columns: 1fr;
  border-top: 1px solid #eeeeee;
}
.modal-body {
  position: relative;
  padding: 20px 10px;
}
.btn-close {
  position: absolute;
  top: 0;
  right: 0;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: #05b3df;
  background: transparent;
}
.btn-modal {
  color: white;
  background: #05b3df;
  border: none;
  border-radius: 3px;
  width: 100px;
  margin: 3px;
  align-self: center;
  justify-self: center;
}
.btn-modal:hover {
  cursor: pointer;
  transform: scale(1.05);
  background-color: #05b3df;
}
</style>
