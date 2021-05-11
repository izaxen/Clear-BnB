<template>
  <div class="mypage-container">
      <div class="sidebar"><SideBar /></div>
    <div class="overlay">
      <div class="info">
          <div class="user-box">
              <h1>My Info</h1>
              <div class="user-info" v-if="userLoggedIn !== null">
                  <h3>Firstname: {{user.firstName}}</h3>
                  <h3>Lastname: {{user.lastName}}</h3>
                  <h3>Email: {{user.email}}</h3>
                  <h3>Phone: {{user.phoneNumber}}</h3>
                  <h3>Address: {{user.address}}</h3>
                  <h3>City: {{user.city}}</h3>
              </div>
          </div>
      </div>
   </div>
   </div>
</template>

<script>
import SideBar from '../components/Sidebar.vue'
export default {
    components: {SideBar},
    data(){
        return {
            user: null
        }
    },

    computed: {
        userLoggedIn(){
           return this.user = this.$store.state.user
        }
    },
}
</script>

<style scoped>

.mypage-container {
  display: flex;
  flex-direction: column;
  max-width: 65rem;
  margin: auto;
  
}
.overlay {
   box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
   border-radius: 5px;
}

.sidebar {
  height: 10%;
  min-top: 10%;
  min-left: 1%;
}

.user-info{
    display: flex;
    flex-direction: column;
    font-size: 20px;
    margin-top: 30px;
    height: 100%;
    text-align: start;
    padding: 30px;
}

.info {
    background: rgb(255, 255, 255);
    border: 2px solid black;
    height: 100%;
    color: black;
    text-align: center;
    margin: 20px auto 20px auto;
    width: 50%;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 10px 10px 15px 5px rgb(75, 75, 75);
}

.user-box {
    height: 60%;
}

@media screen and (max-width: 1100px) {
    .sidebar1 {
      max-width: 40rem;
      font-size: 15px;
    }
}


</style>