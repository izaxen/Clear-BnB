<template>
  <div class="mypage-container">
      <div class="sidebar"><SideBar /></div>

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
    display: grid;
    position: relative;
    align-content: center;
}

.sidebar {
    position: absolute;
    top: 0;
    left: 0;
}
.user-info{
    display: flex;
    flex-direction: column;
    font-size: 20px;
    margin-top: 30px;
    height: 100%;
    text-align: start;
    align-content: center;
    padding: 30px;

}

.info {
    background: rgb(255, 255, 255);
    border: 2px solid black;
    height: 100%;
    color: black;
    text-align: center;
    margin-top: 30px;
    width: 50%;
    justify-self: center;
    padding: 40px;
    border-radius: 10px;
}

.user-box {
    height: 60%;
}

</style>