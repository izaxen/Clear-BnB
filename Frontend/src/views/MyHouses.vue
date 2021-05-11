<template>
  <div class="main1">
    <div class="sidebar"><SideBar /></div>
    <div class="overlay">
      <div class="list"><UserHouseList /></div>
    </div>
  </div>
</template>

<script>
import UserHouseList from '../components/UserHouseList.vue'
import SideBar from '../components/Sidebar.vue'
export default {
  components: {
    SideBar, UserHouseList
  },
}
</script>

<style scoped>
  
.main1 {
  display: flex;
  flex-direction: column;
  max-width: 65rem;
  margin: auto;
}

.overlay {
   box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
   border-radius: 5px;
   min-height: 72vh;
}

.sidebar {
  height: 10%;
  min-top: 10%;
  min-left: 1%;
}

.list {
  justify-self: center;
}

</style>