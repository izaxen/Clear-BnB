<template>
  <div class="home-view">
    <div class="banner">
      <div class="banner-img">
        <img src="https://www.gbtt.com/images/gbtt-travel-banner.jpg" alt="" />
      </div>
      <h1>Take a vacation!</h1>
      <em class="fas fa-info-circle" id="info1"
        ><div class="info-modal"><p>Egypt</p></div></em
      >
      <em class="fas fa-info-circle" id="info2"
        ><div class="info-modal"><p>New York</p></div></em
      >
      <em class="fas fa-info-circle" id="info3"
        ><div class="info-modal"><p>Rome</p></div></em
      >
      <em class="fas fa-info-circle" id="info4"
        ><div class="info-modal"><p>Paris</p></div></em
      >
      <em class="fas fa-info-circle" id="info5"
        ><div class="info-modal"><p>USA</p></div></em
      >
      <em class="fas fa-info-circle" id="info6"
        ><div class="info-modal"><p>London</p></div></em
      >
      <em class="fas fa-info-circle" id="info7"
        ><div class="info-modal"><p>Pisa</p></div></em
      >
      <em class="fas fa-info-circle" id="info8"
        ><div class="info-modal"><p>India</p></div></em
      >
      <em class="fas fa-info-circle" id="info9"
        ><div class="info-modal"><p>Rio de janeiro</p></div></em
      >
      <em class="fas fa-info-circle" id="info10"
        ><div class="info-modal"><p>Peru</p></div></em
      >
    </div>
    <div class="locations">
      <CitiesList />
    </div>
  </div>
</template>

<script>
import CitiesList from '../components/CitiesList.vue'

export default {
  components: {
    CitiesList,
  },
}
</script>

<style scoped>
.home-view {
  padding: 20px;
  display: grid;
  justify-content: center;
  align-self: center;
  min-height: 90vh;
  background-color: white;
  max-width: 80rem;
  margin: auto;
}

.locations {
  justify-self: center;
}
.banner {
  position: relative;
  z-index: 0;
}

.info-modal {
  overflow: hidden;
  text-align: center;
  font-size: 20px;
  background: white;
  width: 0;
  height: 0;
  z-index: 3;
  transition: 0.4s;
  border-radius: 10px;
}

.fa-info-circle {
  font-size: 40px;
}

.fa-info-circle:hover {
  cursor: pointer;
}

.fa-info-circle:hover > .info-modal {
  width: 150px;
  height: 150px;
  background: white;
}

#info1 {
  position: absolute;
  left: 88%;
  top: 50%;
  z-index: 1;
}

#info2 {
  position: absolute;
  left: 85%;
  top: 30%;
  z-index: 1;
}

#info3 {
  position: absolute;
  left: 73%;
  top: 40%;
  z-index: 1;
}

#info4 {
  position: absolute;
  left: 55%;
  top: 30%;
  z-index: 1;
}

#info5 {
  position: absolute;
  left: 47%;
  top: 40%;
  z-index: 1;
}

#info6 {
  position: absolute;
  left: 40%;
  top: 17%;
  z-index: 1;
}
#info7 {
  position: absolute;
  left: 35%;
  top: 25%;
  z-index: 1;
}
#info8 {
  position: absolute;
  left: 22%;
  top: 40%;
  z-index: 1;
}

#info9 {
  position: absolute;
  left: 12%;
  top: 35%;
  z-index: 1;
}

#info10 {
  position: absolute;
  left: 5%;
  top: 55%;
  z-index: 1;
}

img {
  width: 100%;
  height: 600px;
  margin: 0;
}

h1 {
  color: rgb(0, 0, 0);
  background: rgba(99, 214, 243, 0.13);
  border-radius: 15px;
  padding: 10px;
  font-size: 40px;
  position: absolute;
  top: 0;
  left: 40%;
  font-weight: 800;
  margin: 0;
  z-index: 1;
}
</style>
