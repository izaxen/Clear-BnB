<template>
  <div class="card" @click="goToHouse">
    <!-- v-bind: (short ':') binds an attribute
          to a reactive varaible -->
    <img src="http://www.dib.mn/wp-content/uploads/2017/11/Bilgee-house-big.jpg" alt="">
    <h3>{{ city.city }}</h3>
    <p>{{ city.freeText }}</p>
  </div>
</template>

<script>
export default {
  props: ['city'],

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.city.id)
    }
  }
}
</script>

<style scoped>
.card {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
  "box1 box2"
  "box3 box3";
  align-content: center;
  justify-content: center;
  margin: 20px;
  box-shadow: 10px 10px 15px 5px rgb(75, 75, 75);
  border-radius: 8px;
  padding: 10px;
  cursor: pointer;
  width: 380px;
  height: 220px;
  transition: 0.4s;
}
img {
  width: 200px;
  height: 100px;
  grid-area: box1;
}

h3 {
  margin-left: 10px;
  grid-area: box2;
}

p {
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