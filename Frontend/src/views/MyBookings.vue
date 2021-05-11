<template>
  <div class="Bookings-page">
    <div class="sidebar"><SideBar /></div>
    <div class="overlay">
      <div class="list"><ReceiptList /></div>
    </div>
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
  max-width: 65rem;
  margin: auto;
}

.overlay {
   box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
   border-radius: 5px;
   min-height: 72vh;
   width: 100%;
}

.sidebar {
  height: 10%;
  min-top: 10%;
  min-left: 1%;
}

.list {
  justify-self: center;
  margin: auto;
}
</style>