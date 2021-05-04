<template>
  <div class="rental-card">
    <img
      src="https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false"
    />
    <div class="wrapper">
      <div class="hero">
        <p>{{ object.city }}</p>
        <span>From {{ from }}, to {{ to }}</span>
        <div class="small-text">Price: {{ object.price }}</div>

        <hr class="separator" />
      </div>
      <p>{{ object.freeText }}</p>
    </div>
    <div class="wrapper">
      <img :src="wifiUrl" />
      <img :src="petsUrl" />
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
    }
  },

  created() {
    console.log(this.object.amenities.wifi)
    this.wifiUrl = this.object.amenities.wifi
      ? 'https://media.istockphoto.com/vectors/icon-in-flat-style-wireless-symbol-vector-id944860382'
      : 'https://cdn.iconscout.com/icon/premium/png-512-thumb/no-wifi-1914404-1620362.png'
    this.petsUrl = this.object.amenities.petsAllowed
      ? 'https://image.flaticon.com/icons/png/512/2262/2262533.png'
      : 'https://image.flaticon.com/icons/png/512/34/34704.png'
  },
}
</script>

<style scoped>
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
</style>
