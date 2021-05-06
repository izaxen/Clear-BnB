<template>
  <div class="mypage-container">
      <div class="side-bar">
          <nav>
              <router-link to="/my-page/add-house">Add housing</router-link>
              <router-link to="/my-page/my-bookings">My Bookings</router-link>
              <router-link to="/my-page/my-houses">My houses</router-link>
          </nav>
        </div>
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
export default {
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
    grid-template-columns: 10% 90%;
    height: 100%;
    align-content: center;
}

.user-info{
    display: flex;
    flex-direction: column;
    font-size: 25px;
    margin-top: 80px;
    border: 2px solid black;
    height: 600px;
    text-align: start;
    align-content: center;
    padding-left: 50px;

}

.info {
    background: rgb(146, 243, 146);
    border: 2px solid black;
    height: 1000px;
    color: black;
    text-align: center;
    margin-top: 50px;
    width: 40%;
    justify-self: center;
    padding: 40px;
}

.side-bar {
    margin-top: 20px;
    height: 300px;
    text-align: center;
}

nav {
    display: flex;
    flex-direction: column;
    font-size: 28px;
}

a {
    text-decoration: none;
    color: black;
    font-weight: 900;
    margin-top: 10px;
}

a:hover {
    color: rgb(29, 28, 28);
    transform: scale(1.05);
}


</style>