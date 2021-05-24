<template>
  <div class="Bookings-page">
    <div class="overlay">
      <div class="sidebar"><SideBar /></div>
      <div v-if="!userReceipts"></div>
      <div v-else class="list"><ReceiptList /></div>
    </div>
  </div>
</template>

<script>
import SideBar from '../components/Sidebar.vue'
import ReceiptList from '../components/ReceiptList.vue'
import store from '../store.js'
export default {
  components: {
    ReceiptList,
    SideBar,
  },

  async beforeRouteEnter(to, from, next) {
    if (!store.state.user) {
      await store.dispatch('whoAmI')
      if (store.state.user) {
        let id = store.state.user.id
        await store.dispatch('fetchUserReceipts', id)
        next()
      } else {
        next((vm) => {
          vm.$router.push('/')
        })
      }
    } else {
      let id = store.state.user.id
      await store.dispatch('fetchUserReceipts', id)
      next()
    }
  },

  computed: {
    userReceipts() {
      return this.$store.state.userReceipts
    },
  },
}
</script>

<style scoped>
.Bookings-page {
  display: flex;
  flex-direction: column;
  max-width: 65rem;
  margin: auto;
  height: 100%;
}

.overlay {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  width: 100%;
  background-color: rgba(205, 205, 205, 0.9);
  height: 100%;
}

.sidebar {
  height: 10%;
}

.list {
  justify-self: center;
  margin: auto;
}
</style>
