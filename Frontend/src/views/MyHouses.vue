<template>
<div class="main">
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
  
.main {
  display: grid;
  position: relative;
}

.sidebar {
  position: absolute;
  top: 0;
  left: 0;
}

.list {
  justify-self: center;
  width: 70%;
}
</style>