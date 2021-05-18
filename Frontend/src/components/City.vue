<template>
  <div class="card" @click="goToHouse" v-if="getImg">
    <!-- v-bind: (short ':') binds an attribute
          to a reactive varaible -->
    <img :src="imageList[0]" alt="">
    <h3>{{ city.city }}</h3>
    <p>{{ city.description }}</p>
  </div>
</template>

<script>
export default {
  props: ['city'],
  data(){
    return {
      imageList: []
    }
  },

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.city.id)
    }
  },
  computed: {
    async getImg(){
      await this.$store.dispatch('getFileUrl', this.city.id)
      this.imageList = this.$store.state.imageList
    }
  },
}
</script>

<style scoped>
.card {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
  "box1 box2"
  "box1 box3";
  align-content: center;
  justify-content: center;
  margin: 20px;
  box-shadow: 10px 10px 25px 5px rgba(158, 158, 158, 0.603);
  border-radius: 8px;
  padding: 10px;
  cursor: pointer;
  width: 380px;
  height: 220px;
  transition: 0.4s;
}
.card:hover {
  transform: scale(1.1);
}
img {
  width: 200px;
  height: 190px;
  border-radius: 5px;
  grid-area: box1;
  transition: 0.3s;
}

h3 {
  margin-left: 10px;
  grid-area: box2;
}

p {
  overflow:hidden;
  margin-left: 10px;
  grid-area: box3;
}

 @media screen and (max-width: 925px) {
    .card {
      grid-template-columns: 1fr;
      grid-template-rows: 1fr 1fr 1fr;
      grid-template-areas:
      "box1"
      "box2" 
      "box3";
      width: 250px;
      height: 290px;
    }
}
</style>