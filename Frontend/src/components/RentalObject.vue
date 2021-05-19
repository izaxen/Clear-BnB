<template>
  <div class="rental-card" v-if="getImg">
    <div class="info-box">
      <router-link :to="link">
        <img :src="imageList[0]" alt="img" />
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
        <i :class="wifi"></i>
        <i :class="pets"></i>
        <i :class="pool"></i>
        <i :class="aircon"></i>
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
      wif: '',
      pets: '',
      pool: '',
      aircon: '',
      link: '/details/' + this.object.id,
      imageList: [],
    }
  },

  created() {
    if (this.object.amenities != undefined) {
      this.wifi = this.object.amenities.wifi
        ? 'fas fa-wifi'
        : 'fas fa-wifi-slash'
      this.pets = this.object.amenities.petsAllowed
        ? 'fas fa-paw'
        : 'fas fa-do-not-enter'
      this.pool = this.object.amenities.pool
        ? 'fas fa-swimming-pool'
        : 'fas fa-tint-slash'
      this.aircon = this.object.amenities.airCondition
        ? 'fas fa-wind'
        : 'fas fa-slash'
    }
  },
  computed: {
    async getImg() {
      await this.$store.dispatch('getFileUrl', this.object.id)
      this.imageList = this.$store.state.imageList
    },
  },
}
</script>

<style scoped>
h3,
h5 {
  margin: 0;
  padding: 0;
  font-size: 1.7rem;
  font-weight: 600;
}

h5 {
  margin-bottom: 0.3rem;
  font-size: 1.4rem;
}
.small-text {
  margin-top: 0.5rem;
  font-size: 1.1rem;
  font-weight: 600;
}

span {
  font-size: 1.2rem;
  font-weight: 500;
}
.rental-card {
  margin: 1rem 2rem;
  background-color: white;
  display: flex;
  flex-direction: row;
  padding: 0.8rem 2rem;
  box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.4), 0 1px 1px 0 rgba(0, 0, 0, 0.3);
  color: black;
  border-radius: 10px;
  justify-content: space-between;
}

.info-box {
  display: flex;
  flex-direction: row;
  max-width: 60rem;
}

.hero {
  display: flex;
  flex-direction: column;
  margin-right: 1rem;
}
a {
  display: flex;
  align-items: center;
  justify-content: center;
}
img {
  height: 100px;
  width: 100px;
  margin-right: 1rem;
  border-radius: 10px;
}
p {
  margin-top: 0;
}
.icons {
  display: flex;
  justify-content: space-around;
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

@media screen and (min-width: 841px) {
  hr {
    display: none;
  }
}

@media screen and (max-width: 840px) {
  .rental-card > * {
  }
  .icons-wrapper {
    width: 168px;
  }
}
@media screen and (max-width: 600px) {
  .rental-card {
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .info-box {
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 70%;
  }

  .wrapper {
    width: 50%;
  }

  img {
    margin: 0.7rem 0;
  }

  .hero {
    margin: 0;
  }
}
</style>
