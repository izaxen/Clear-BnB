<template>
<div main>
  <div>
    <div class="hero-picture">
      <img :src="imageList[0]">
    </div>
    <div class="slider">
      <div v-for="image in imageList" >
      <img :src="image" alt="">
    </div>
  </div>
  </div>
  
  
</div>
</template>

<script>
export default {
async created(){
  
  this.imageList = await this.$store.state.imageList
  console.log('file listr i testpage', this.imageList)
},
data(){
  return{
    imageList: [],
  }
}
}
</script>

<style scoped>

.hero {
  margin: 3rem 0;
}
.hero-text {
  padding: 0 1rem;
}
.hero-picture {
  height: 50vh;
  position: relative;
}
.hero-picture img {
  filter: brightness(50%);
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 10px 0 rgba(0, 0, 0, 0.2);
}
.slider {
  display: flex;
  
  justify-content: space-around;
  margin: 10px;
}
.slider img {
  height: 100px;
  width: 80px;
  border-radius: 5px;
  margin: 1rem 0;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  transition: 0.5s ease;
}
.slider img:hover {
  opacity: 0.3;
}
.hero {
  display: flex;
  justify-content: space-between;
}

img {
  border-radius: 5px;
  width: 100%;
  height: 100%;
  display: block; /* remove extra space below image */
}

</style>