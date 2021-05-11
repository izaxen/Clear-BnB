<template>
<div class="main1">
  <div class="sidebar"><SideBar /></div>
  <div class="list"><UserHouseList /></div>
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
}

.sidebar {
  height: 10%;
  min-top: 10%;
  min-left: 1%;
}

.list {
  justify-self: center;
  width: 70%;
  margin: auto;
}

</style>