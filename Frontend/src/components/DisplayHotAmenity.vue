<template>
  <div class="container">
    <div class="card">
      <img class="icon" :src="wifiUrl" />
      <div class="am-text">{{ amenities.wifi ? 'Wifi' : 'No wifi' }}</div>
    </div>
    <div class="card">
      <img class="icon" :src="petsUrl" />
      <div class="am-text">
        {{ amenities.petsAllowed ? 'Pets allowed' : 'No pets' }}
      </div>
    </div>
    <div class="card">
      <img class="icon" :src="poolUrl" />
      <div class="am-text">{{ amenities.pool ? 'Got pool' : 'No pool' }}</div>
    </div>
    <div class="card">
      <img class="icon" :src="airUrl" />
      <div class="am-text">
        {{ amenities.airCondition ? 'Air conditioner' : 'No air conditioner' }}
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
      ? 'https://media.istockphoto.com/vectors/icon-in-flat-style-wireless-symbol-vector-id944860382'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-wifi-1914404-1620362.png'
    this.petsUrl = this.amenities.petsAllowed
      ? 'https://image.flaticon.com/icons/png/512/2262/2262533.png'
      : 'https://image.flaticon.com/icons/png/512/34/34704.png'
    this.poolUrl = this.amenities.pool
      ? 'https://cdn1.iconfinder.com/data/icons/real-estate-94/200/810-512.png'
      : 'https://thumbs.dreamstime.com/z/no-pool-icon-simple-thin-line-outline-vector-hotel-service-ban-prohibition-forbiddance-icons-ui-ux-website-mobile-172950965.jpg'
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
}
.card {
  display: flex;
}

h2 {
  margin-left: 4rem;
}

img {
  width: 32px;
  height: 32px;
}
</style>
