<template>
  <div main>
    <div>
      <div class="hero-picture">
        <div class="pic1">
          <img :src="imageList[0]" alt="img"/>
          <div class="pic-city">{{ object.city }}</div>
          </div>
        <div class="pic2"><img :src="imageList[1]" alt="img"/></div>
        <div class="pic3"><img :src="imageList[2]" alt="img"/></div>
        <div class="picture-text">
          <p>{{ object.freeText }}</p>
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
  left: 30%;
  transform: translate(-50%);
  color: whitesmoke;
  padding: 5px;
  font-weight: 700;
  font-size: 1rem;
  width: 50%;
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
  display: grid;
  grid-gap: 8px;
  grid-template-columns: 1fr 0.4fr;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
  "pic1 pic2"
  "pic1 pic3";
  height: 50vh;
}
.pic1{
  width: 100%;
  height: 50vh;
  grid-area: pic1;
  position: relative;
}
.pic2{
  width: 100%;
  height: 24vh;
  grid-area: pic2;
}
.pic3{
  width: 100%;
  height: 25vh;
  grid-area: pic3;
}

.hero-picture img {
  filter: brightness(80%);
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.3), 0 3px 10px 0 rgba(0, 0, 0, 0.2);
}
.hero {
  display: flex;
  justify-content: space-between;
}

img {
  border-radius: 5px;
  width: 100%;
  height: 100%;
  transition: 0.2s;
}

</style>
