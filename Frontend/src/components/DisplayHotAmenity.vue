<template>
  <div class="container">
    <div class="box1">
      <div class="card">
      <img class="icon" :src="wifiUrl" alt="img"/>
      <div class="am-text">{{ amenitiealt="img".wifi ? 'Wifi' : 'No wifi' }}</div>
    </div>
    <div class="card">
      <img class="icon" :src="petsUrl" alt="img"/>
      <div class="am-text">
        {{ amenities.petsAllowed ? 'Pets allowed' : 'No pets' }}
      </div>
     </div>
    </div>
    <div class="box2">
      <div class="card">
      <img class="icon" :src="poolUrl" alt="img"/>
      <div class="am-text">{{ amenitiealt="img".pool ? 'Pool' : 'No pool' }}</div>
    </div>
    <div class="card">
      <img class="icon" :src="airUrl" alt="img">
      <div class="am-text">
        {{ amenities.airCondition ? 'Air conditioner' : 'No air conditioner' }}
      </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['amenities'],

  data() {
    return {
      wifiUrl: '',
      petsUrl: '',
      poolUrl: '',
      airUrl: '',
    }
  },

  mounted() {
    this.wifiUrl = this.amenities.wifi
      ? 'http://assets.stickpng.com/images/580b585b2edbce24c47b2488.png'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-wifi-1914404-1620362.png'
    this.petsUrl = this.amenities.petsAllowed
      ? 'https://image.flaticon.com/icons/png/512/2262/2262533.png'
      : 'https://image.flaticon.com/icons/png/512/34/34704.png'
    this.poolUrl = this.amenities.pool
      ? 'https://cdn1.iconfinder.com/data/icons/real-estate-94/200/810-512.png'
      : 'https://www.pngrepo.com/png/114160/180/no-diving-in-pool.png'
    this.airUrl = this.amenities.airCondition
      ? 'https://image.flaticon.com/icons/png/512/114/114735.png'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-air-conditioner-2184221-1828706.png'
  },
}
</script>

<style scoped>
.am-text {
  display: flex;
  align-items: center;
  margin-left: 2rem;
}
.container {
  margin-bottom: 2rem;
  padding-left: 15px;
  font-size: 25px;
  font-weight: 700;
}
.card {
  display: flex;
  margin-bottom: 10px;
}

h2 {
  margin-left: 4rem;
}

img {
  width: 32px;
  height: 32px;
}
@media screen and (max-width: 750px) {
  .container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
    "box1 box2";
  }

  .card {
    margin: 20px;
  }
}

@media screen and (max-width: 600px) {
  .container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
    "box1 box2";
    font-size: 15px;
  }
  .box1 {
    grid-area: box1;
  }
  .box2 {
    grid-area: box2;
  }
}
@media screen and (max-width: 450px) {
  .container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
    "box1 box2";
    font-size: 15px;
  }
  .card {
    flex-direction: column;
    width: 100px;
    justify-items: center;
    font-size: 15px;
  }
  img {
    justify-self: center;
    align-self: center;
  }
  .box1 {
    display: grid;
    width: 160px;
    grid-area: box1;
  }
  .box2 {
    display: grid;
    width: 160px;
    grid-area: box2;
  }
}
@media screen and (max-width: 350px) {
  .box1 {
    width: 120px;
  }
  .box2 {
    width: 120px;
  }
}
@media screen and (max-width: 285px){
  .card {
    margin: 3px;
    text-align: center;
  }
  .am-text {
    margin: auto;
  }
  .bookingForm .container {
    height: fit-content;
    width: 140px;
  }

  .hero-amenity .container {
    padding: 0;
  }
  .container {
    display: grid;
    justify-items: center;
    align-items: center;
  }
}
</style>
