<template>
  <div main>
    <div>
      <div class="hero-picture">
        <img :src="imageList[0]" />
        <div class="picture-text">
          {{ object.freeText }}
        </div>
        <div class="pic-city">{{ object.city }}</div>
      </div>
      <div class="slider">
        <div v-for="image in imageList" :key="image">
          <img :src="image" alt="" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['object'],
  async created() {
    this.imageList = await this.$store.state.imageList
    console.log('file listr i testpage', this.imageList)
  },
  data() {
    return {
      imageList: [],
    }
  },
}
</script>

<style scoped>
.picture-text {
  position: absolute;
  top: 75%;
  left: 50%;
  transform: translate(-50%, -75%);
  color: whitesmoke;
  font-weight: 700;
  font-size: 2rem;
  min-width: 100%;
  text-align: center;
}

.pic-city {
  position: absolute;
  color: whitesmoke;
  font-weight: 700;
  top: 20px;
  left: 16px;
  font-size: 2rem;
}
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
