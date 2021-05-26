<template>
  <div class="sidebar1">
    <router-link to="/my-page/add-object"
      ><em class="fas fa-plus-circle"></em><p>Add house</p></router-link
    >
    <router-link to="/my-page/my-objects"
      ><em class="fas fa-home"></em><p>Houses</p></router-link
    >
    <router-link to="/my-page/my-bookings"
      ><em class="fas fa-book"></em><p>Bookings</p></router-link
    >
    <router-link to="/my-page"
      ><em class="fas fa-users"></em><p>Profile</p></router-link
    >
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.sidebar1 {
  display: flex;
  justify-content: space-evenly;
  font-size: 20px;
  background: rgb(245,245,245);
  border: 1px solid rgb(63, 63, 63);
  border-left: none;
  border-right: none;
  border-top: none;
  padding: 5px 0 ;
  align-content: center;
}
em {
  display: flex;
  flex-direction: column;
  margin-right:3px;
  justify-content: center;
}

a {
  display: flex;
  text-decoration: none;
  color: black;
  font-weight: 700;
  margin: 10px 0;
}
p{
  margin-top: 5px;
  margin-bottom: 0;
}

a:hover p {
  border-radius:5px;
  color: rgb(29, 28, 28);
  text-decoration: underline;
  text-decoration-thickness: 3px;
  border-radius: 5px;
}
@media screen and (max-width: 360px) {
  a {
    flex-direction: column;
  }
}

@media screen and (max-width: 500px) {
  .sidebar1 {
    max-width: 100%;
    font-size: 15px;
    text-align: center;
  }
}
@media screen and(min-width: 501px){
  
  .sidebar1{
  display:none;}
}
</style>
