<template>
  <div class="sidebar1">
    <router-link to="/my-page/add-house"><em class="fas fa-plus-circle"></em>Add house</router-link>
    <router-link to="/my-page/my-houses"><em class="fas fa-home"></em>Houses</router-link>
    <router-link to="/my-page/my-bookings"><em class="fas fa-book"></em>Bookings</router-link>
    <router-link to="/my-page"><em class="fas fa-users"></em>Profile</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.sidebar1 {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 95%;
  font-size: 20px;
  background: #6497b1;
  height: 50%;
  padding: 5px;
  font-size: 20px;
  border: 1px solid black;
  margin: 10px auto;
  border-radius: 10px;
}
em{
  margin-right: 10px;
}

a {
  text-decoration: none;
  color: black;
  font-weight: 700;
  margin: 10px 0;
}

a:hover {
  color: rgb(29, 28, 28);
  transform: scale(1.05);
}

</style>