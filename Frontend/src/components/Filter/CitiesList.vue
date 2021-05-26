<template>
  <!-- key should be an unique value -->
  <div class="city-list">
    <div class="big-text">{{ text }}</div>
    <div class="location-box">
      <City v-for="city of rentalObjects" :key="city.id" :city="city" />
    </div>
    <div class="arrow-btns">
      <button class="slide-arrow" @click="slideLeft">
        <em class="far fa-arrow-alt-circle-left slide-arrow"></em>
      </button>
      <button class="slide-arrow" @click="slideRight">
        <em class="far fa-arrow-alt-circle-right slide-arrow"></em>
      </button>
    </div>
  </div>
</template>

<script>
import City from './City.vue'
export default {
  props: ['text', 'objects'],

  components: {
    City,
  },

  data() {
    return {
      start: 0,
      end: 2,
    }
  },
  computed: {
    rentalObjects() {
      return this.objects.slice(this.start, this.end)
    },
  },
  methods: {
    slideRight() {
      if (this.start === 4) return
      this.start = this.start + 2
      this.end = this.end + 2
    },
    slideLeft() {
      if (this.start < 1) return
      this.start = this.start - 2
      this.end = this.end - 2
    },
  },
}
</script>

<style scoped>
.slide-arrow {
  background: none;
  border: none;
}
.arrow-btns {
  display: flex;
  align-content: center;
  justify-content: center;
  margin-bottom: 20px;
  font-size: 40px;
}
.slide-arrow:hover > .slide-arrow {
  transform: scale(1.2);
  cursor: pointer;
  background: rgba(219, 240, 219, 0.6);
  border-radius: 50%;
}

.far {
  background: rgba(193, 187, 187);
  border-radius: 50%;
}
button {
  width: 100px;
  justify-self: center;
  margin-bottom: 10px;
}
.city-list {
  justify-items: center;
  /* margin: auto; */
}
.location-box {
  display: flex;
  width: 100%;
  justify-content: space-between;

  /* width: 70rem; */
}

.location-box > div:nth-child(odd) {
  margin-right: 10px;
}
.location-box > div:nth-child(even) {
  margin-left: 10px;
}
.big-text {
  color: white;
  font-size: 40px;
  font-weight: 900;
}

@media screen and (max-width: 400px) {
  .location-box {
    display: flex;
    flex-direction: column;
  }

  .location-box > div:nth-child(odd) {
    margin-right: 0;
  }
  .location-box > div:nth-child(even) {
    margin-left: 0;
  }
}
</style>
