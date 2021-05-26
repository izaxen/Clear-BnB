<template>
  <div class="main1">
    <div class="overlay">
      <div class="sidebar"><SideBar /></div>
      <div class="list"><UserHouseList /></div>
    </div>
  </div>
</template>

<script>
import UserHouseList from './UserHouseList.vue'
import SideBar from '../Sidebar/Sidebar.vue'
import store from '../../store.js'

export default {
  components: {
    SideBar,
    UserHouseList,
  },

  data() {
    return {}
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
}
</script>

<style scoped>
.main1 {
  display: flex;
  flex-direction: column;
  max-width: 65rem;
  margin: auto;
  height: 100%;
}

.overlay {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  background-color: rgba(205, 205, 205, 0.6);
  height: 100%;
}

.sidebar {
  height: fit-content;
}

.list {
  justify-self: center;
}
</style>
