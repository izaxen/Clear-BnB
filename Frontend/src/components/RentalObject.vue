<template>
  <div class="rental-card" v-if="getImg">
    <div class="info-box">
    <router-link :to="link">
      <img class="picture" :src="imageList[0]" alt="img"/>
    </router-link>
    <div class="wrapper">
      <div class="hero">
        <h3>{{ object.city }}</h3>
        <h5>{{ object.address }}</h5>
        <span>From {{ from }}, to {{ to }}</span>
        <div class="small-text">Price: {{ object.price }}$</div>

        <hr class="separator" />
        <p>{{ object.freeText }}</p>
      </div>
    </div>
    </div>
    <div class="icons-wrapper">
      <div class="icons">
        <img class="icon" :src="wifiUrl" />
        <img class="icon" :src="petsUrl" />
        <img class="icon" :src="poolUrl" />
        <img class="icon" :src="airUrl" />
      </div>
    </div>
  </div>
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
      imageList: []
    }
  },

  created() {
    if(this.object.amenities != undefined){
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
    }
  },
  computed: {
    async getImg(){
      await this.$store.dispatch('getFileUrl', this.object.id)
      this.imageList = this.$store.state.imageList
    }
  },
}
</script>

<style scoped>
h3,
h5 {
  margin: 0;
  padding: 0;
  font-size: 1.7rem;
  font-weight:600;
}

h5 {
  margin-bottom: 0.3rem;
  font-size: 1.4rem;
}
.small-text {
  margin-top: 0.5rem;
  font-size: 1.1rem;
  font-weight:600;
}

span{
  font-size: 1.2rem;
  font-weight: 500;
}
.rental-card {
  margin: 1rem 2rem;
  background-color: white;
  display: flex;
  flex-direction: row;
  padding: 0.5rem 0.5rem;
  /*box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.4), 0 1px 1px 0 rgba(0, 0, 0, 0.3);*/
  border: 1px solid rgb(173, 169, 169);
  box-shadow: 1px 2px 3px 0 rgb(173, 169, 169);
  color: black;
  border-radius: 7px;
  justify-content: space-between;
  width: 80%;
  min-width: 250px;
}

.info-box{
  display: flex;
  flex-direction: row;
  max-width: 60rem;
}

.hero {
  display: flex;
  flex-direction: column;
  margin-right: 1rem;
}
a{
  display: flex;
  align-items: center;
  justify-content: center;
}
img {
  height: 250px;
  width: 250px;
  margin-right: 1rem;
  border-radius: 3px;
  object-fit: cover;
}

.picture{
 border: 1px solid rgb(136, 132, 132);
}

p {
  margin-top: 0;
}
.icons {
  display: flex;
  justify-content: space-around;
  flex-direction: column;
  margin-right: 0.7rem;
  height: 100%;
}

.separator {
  width: 100%;
  height: 0.001em;
  background-color: black;
}
.wrapper {
  display: flex;
  align-items: center;
}

.icon {
  height: 32px;
  width: 32px;
  margin: 0.5rem 0;
}

@media screen and (max-width: 840px) {
  .wrapper{
    align-items: flex-start;
    max-height: 250px;
    overflow: hidden;
  }
  
}
@media screen and (max-width: 600px) {
  .icons{
    flex-direction: row;
    margin-right: 0;
    margin-bottom: 0.5rem;
  }

  .icons-wrapper{
    width: 80%;
  }

  .rental-card {
    flex-direction: column;
    justify-content: center;
    align-items: center;
    max-width: 330px;
    padding: 0;
  }

  .info-box{
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 70%;
  }

  .wrapper{
    justify-content: center;
    align-items: center;
    text-align: center;
  }

  img{
    height: 200px;
    width: 200px;
    margin: 0.7rem 0;
  }

  .hero{
    margin: 0;
  }

}
</style>
