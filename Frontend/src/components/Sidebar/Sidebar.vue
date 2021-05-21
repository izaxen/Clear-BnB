<template>
  <div class="sidebar1">
    <router-link to="/my-page/add-object"
      ><em class="fas fa-plus-circle"></em>Add rental object</router-link
    >
    <router-link to="/my-page/my-objects"
      ><em class="fas fa-home"></em>Rental objects</router-link
    >
    <router-link to="/my-page/my-bookings"
      ><em class="fas fa-book"></em>Bookings</router-link
    >
    <router-link to="/my-page"
      ><em class="fas fa-users"></em>Profile</router-link
    >
  </div>
</template>

<script>
export default {}
</script>

<style scoped>

.sidebar1 {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  font-size: 20px;
  background: rgb(245,245,245);
  border: 1px solid rgb(63, 63, 63);
  border-right-style: none;
  border-top-style:none;
  border-left: none;
  margin: 0 auto;
  padding: 10px 0 ;
  align-content: center;
  
  
}
em {
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
  background-color: rgb(219,243,219) ;
}

@media screen and (max-width: 1100px) {
  .sidebar1 {
    max-width: 40rem;
    font-size: 15px;
  }
}
@media screen and (max-width: 700px) {
  .sidebar1 {
    max-width: 27rem;
    font-size: 15px;
  }
}

@media screen and (max-width: 500px) {
  .sidebar1 {
    flex-direction: row;
    max-width: 27rem;
    font-size: 15px;
    text-align: center;
  }
  em{
    display: flex;
    flex-direction: column;
  }
}
</style>
