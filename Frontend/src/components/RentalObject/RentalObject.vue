<template>
  <div class="rental-card" v-if="getImg">
    <div class="info-box">
      <router-link :to="link">
        <div v-if="fetching" class="picture empty" />
        <img v-else class="picture" :src="imageList[0]" alt="img" />
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
        <i class="icon" :class="wifi"></i>
        <i class="icon" :class="pets"></i>
        <i class="icon" :class="pool"></i>
        <i class="icon" :class="aircon"></i>
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
      wifi: '',
      pets: '',
      pool: '',
      aircon: '',
      link: '/details/' + this.object.id,
      imageList: [],
      fetching: true,
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
      this.fetching = true
      await this.$store.dispatch('getFileUrl', this.object.id)
      this.imageList = await this.$store.state.imageList
      this.fetching = false
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
  padding: 0.2rem 0.3rem;
  /*box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.4), 0 1px 1px 0 rgba(0, 0, 0, 0.3);*/
  border: 1px solid rgb(173, 169, 169);
  box-shadow: 1px 2px 3px 0 rgb(173, 169, 169);
  color: black;
  border-radius: 7px;
  justify-content: space-between;
  width: 80%;
  min-width: 250px;
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
  height: 180px;
  width: 180px;
  margin-right: 1rem;
  border-radius: 3px;
  object-fit: cover;
}

.picture {
  border: 1px solid rgb(136, 132, 132);
}

.empty {
  height: 180px;
  width: 180px;
  background: lightgray;
  margin-right: 16px;
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
  padding: 0.5rem 0.2rem;
}

.icon {
  height: 32px;
  width: 32px;
  margin: 0.7rem 0 0;
}

@media screen and (max-width: 840px) {
  .wrapper {
    align-items: flex-start;
    max-height: 250px;
    overflow: hidden;
  }
}
@media screen and (max-width: 600px) {
  .icons {
    flex-direction: row;
    margin-right: 0;
    margin-bottom: 0.5rem;
  }

  .icons-wrapper {
    width: 80%;
  }

  .rental-card {
    flex-direction: column;
    justify-content: center;
    align-items: center;
    max-width: 100%;
    padding: 0;
  }

  .info-box {
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    width: 70%;
  }

  .wrapper {
    justify-content: center;
    align-items: flex-start;
  }

  img {
    height: 200px;
    width: 200px;
    margin: 0.7rem 0;
  }

  .hero {
    margin: 0;
  }
}
</style>
