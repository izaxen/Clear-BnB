<template>
  <div class="Bookings-page">
    <div class="sidebar">
      <SideBar />
    </div>
    <div class="list">
      <ReceiptList /></div>
  </div>
</template>

<script>
import SideBar from '../components/Sidebar.vue'
import ReceiptList from '../components/ReceiptList.vue'
export default {
  components: {
    ReceiptList, SideBar
  }
}
</script>

<style scoped>

.Bookings-page {
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