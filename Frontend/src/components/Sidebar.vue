<template>
  <div class="sidebar1">
    <router-link to="/my-page/add-house"><em class="fas fa-plus-circle"></em>Add housing</router-link>
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
  flex-direction: column;
  width: 100%;
  font-size: 20px;
  background: #6497b1;
  height: 50%;
  padding: 20px;
  font-size: 25px;
  border: 1px solid black;
  margin: 30px 10px;
  border-radius: 10px;
}
em{
  margin-right: 10px;
}

a {
  text-decoration: none;
  color: black;
  font-weight: 700;
  margin: 10px;
}

a:hover {
  color: rgb(29, 28, 28);
  transform: scale(1.05);
}
</style>