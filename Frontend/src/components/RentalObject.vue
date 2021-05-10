<template>
  <div class="rental-card">
    <router-link :to="link">
      <img
        src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
      />
    </router-link>
    <div class="wrapper">
      <div class="hero">
        <h3>{{ object.city }}</h3>
        <h5>{{ object.address }}</h5>
        <span>From {{ from }}, to {{ to }}</span>
        <div class="small-text">Price: {{ object.price }}</div>

        <hr class="separator" />
      </div>
      <p>{{ object.freeText }}</p>
    </div>
    <div class="wrapper">
      <img class="icon" :src="wifiUrl" />
      <img class="icon" :src="petsUrl" />
      <img class="icon" :src="poolUrl" />
      <img class="icon" :src="airUrl" />
    </div>
  </div>
  <hr class="separator" />
</template>

<script>
export default {
  props: ['object'],

  data() {
    let fromDate = new Date(this.object.availableFrom).toLocaleDateString()
    let toDate = new Date(this.object.availableTo).toLocaleDateString()
    return {
      from: fromDate,
      to: toDate,
      wifiUrl: '',
      petsUrl: '',
      poolUrl: '',
      airUrl: '',
      link: '/details/' + this.object.id,
    }
  },

  created() {
    this.wifiUrl = this.object.amenities.wifi
      ? 'https://media.istockphoto.com/vectors/icon-in-flat-style-wireless-symbol-vector-id944860382'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-wifi-1914404-1620362.png'
    this.petsUrl = this.object.amenities.petsAllowed
      ? 'https://image.flaticon.com/icons/png/512/2262/2262533.png'
      : 'https://image.flaticon.com/icons/png/512/34/34704.png'
    this.poolUrl = this.object.amenities.pool
      ? 'https://cdn1.iconfinder.com/data/icons/real-estate-94/200/810-512.png'
      : 'https://thumbs.dreamstime.com/z/no-pool-icon-simple-thin-line-outline-vector-hotel-service-ban-prohibition-forbiddance-icons-ui-ux-website-mobile-172950965.jpg'
    this.airUrl = this.object.amenities.airCondition
      ? 'https://image.flaticon.com/icons/png/512/114/114735.png'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-air-conditioner-2184221-1828706.png'
  },
}
</script>

<style scoped>
h3,
h5 {
  margin: 0;
  padding: 0;
}

h5 {
  margin-bottom: 0.3rem;
}
.small-text {
  font-size: 0.9rem;
}
.rental-card {
  margin-top: 5rem;
  display: flex;
  flex-direction: row;
}

.hero {
  display: flex;
  flex-direction: column;
  width: fit-content;
}
img {
  height: 90px;
  width: 90px;
  margin-right: 1rem;
}
p {
  margin-top: 0;
}

.separator {
  width: 100%;
  height: 0.001em;
  background-color: black;
}
.wrapper {
  width: 50%;
}

.icon {
  height: 32px;
  width: 32px;
}
</style>
