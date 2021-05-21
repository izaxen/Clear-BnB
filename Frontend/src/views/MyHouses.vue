<template>
  <div class="main1">
    <div class="overlay">
      <div class="sidebar"><SideBar /></div>
      <div class="list"><UserHouseList /></div>
    </div>
  </div>
</template>

<script>
import UserHouseList from '../components/UserHouseList.vue'
import SideBar from '../components/Sidebar.vue'
export default {
  components: {
    SideBar,
    UserHouseList,
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
  background-color: rgba(205, 205, 205, 0.9);
  height: 100%;
}

.sidebar {
  height: 10%;
}

.list {
  justify-self: center;
}
</style>
