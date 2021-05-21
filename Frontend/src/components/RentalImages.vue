<template>
  <div main>
    <div>
      <div class="hero-picture">
        <div class="pic1">
          <img :src="imageList[0]" alt="img"/>
          <div class="pic-city">{{ object.city }}</div>
          </div>
        <div class="pic2"><img :src="imageList[1]" alt="img"/></div>
        <div class="pic3">
          <img :src="imageList[2]" alt="img"/>
          <button type="button" class="modal" @click="showPic">More pictures</button>
        </div>
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
  methods: {
    showPic(){
      this.$emit('showPic')
      console.log('Clicked on modal');
    }
  }
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
  transition: 0.4s;
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
  position: relative;
}

.modal {
  position: absolute;
  right: 4px;
  bottom: 4px;
  height: 40px;
  width: 150px;
  opacity: 0.9;
}

.modal:hover {
  cursor: pointer;
  opacity: 1;
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

@media screen and (max-width: 750px){
  .hero-picture {
    display: grid;
    grid-gap: 8px;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr;
    grid-template-areas:
    "pic1 pic1"
    "pic2 pic3";
    height: 580px;
  }
  .pic1 {
    height: 300px;
  }
  .pic2{
    height: 23vh;
  }
  .pic3{
    height: 23vh;
  }
}
@media screen and (max-width: 450px){
  .hero-picture {
    height: 570px;
  }
}
@media screen and (max-width: 400px){
  .hero-picture {
    height: 570px;
  }
  .modal {
    width: 120px;
  }
}
@media screen and (max-height: 840px){
  .hero-picture {
    height: 500px;
  }
}
@media screen and (max-height: 740px){
  .hero-picture {
    height: 480px;
  }
}
@media screen and (max-height: 670px){
  .hero-picture {
    height: 460px;
  }
}
</style>
