<template>
  <div class="mypage-container">
    <div class="overlay">
      <div class="sidebar"><SideBar /></div>
      <div class="info">
        <div class="user-box">
          <h1>My Info</h1>
          
          <div v-if="!user"></div>

          <div v-else class="user-info">
            <label @click="openEdit()">Edit</label>
            <h3>Firstname: {{ user.firstName }}</h3>
            <h3>Lastname: {{ user.lastName }}</h3>
            <h3>Email: {{ user.email }}</h3>
            <h3>Phone: {{ user.phoneNumber }}</h3>
            <h3>Address: {{ user.address }}</h3>
            <h3>City: {{ user.city }}</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SideBar from '../components/Sidebar/Sidebar.vue'
import store from '../store.js'
export default {
  components: { SideBar },

  computed: {
    user() {
      return this.$store.state.user
    },
  },

  async beforeRouteEnter(to, from, next) {
    if (!store.state.user) {
      await store.dispatch('whoAmI')
      if (store.state.user) {
        next()
      } else {
        next((vm) => {
          vm.$router.push('/')
        })
      }
    } else {
      next()
    }
  },
  methods:{
    openEdit(){
    this.$router.push('/my-page/edit-user')
    }
  }
}
</script>

<style scoped>
img{
  align-self: flex-end;
  height: 30px;
  width: 30px;
}
.mypage-container {
  display: flex;
  flex-direction: column;
  margin: auto;
  max-width: 65rem;
  height: 100%;
}
.overlay {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  background-color: rgba(205, 205, 205, 0.6);
  height: 100%;
}


.user-info {
  display: flex;
  flex-direction: column;
  font-size: 20px;
  
  height: 60%;
  text-align: start;
  padding: 30px;
}

.info {
  background: rgb(255, 255, 255);
  border: 2px solid black;
  color: black;
  text-align: center;
  margin: 20px auto 20px auto;
  width: 700px;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 5px 5px 10px 2px rgba(144, 144, 144, 0.603);
  transition: 0.4s;
}

.user-box {
  height: 60%;
}

label {
  align-self: flex-end;
  cursor: pointer;
  background: rgb(201, 232, 201);
  border-radius: 5px;
  border: 1px solid black;
  padding: 0.3rem 0.7rem;
  cursor: pointer;
  text-align: center;
}

label:hover {
  background: #c4eafd;
  cursor: pointer;
}

@media screen and (max-width: 850px) {
  .info {
    width: 500px;
  }
  .user-info {
    font-size: 15px;
  }
}
@media screen and (max-width: 560px) {
  .info {
    width: 350px;
  }
  .user-info {
    font-size: 15px;
  }
}


@media screen and (max-width: 400px) {
  .sidebar1 {
    max-width: 40rem;
    font-size: 15px;
  }
  .info {
    margin: 20px auto 20px auto;
    width: 250px;
    padding: 10px;
    font-size: 15px;
  }
  .user-info {
    font-size: 12px;
  }
}
</style>
