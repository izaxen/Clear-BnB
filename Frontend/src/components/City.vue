<template>
  <div class="card">
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

}
</script>

<style scoped>
.card {
  display: flex;
  flex-wrap: wrap;
  align-content: center;
  justify-content: center;
  margin: 20px;
  border: 1px solid gray;
  border-radius: 8px;
  padding: 10px;
  cursor: pointer;
  width: 350px;
  transition: 0.4s;
}

img {
  width: 200px;
  height: 100px;
}

</style>