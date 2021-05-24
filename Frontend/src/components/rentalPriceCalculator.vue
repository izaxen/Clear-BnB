<template>
  <div class="center">
    <div class="container">
      <div class="link" @click="isActive = !isActive">
        <div class="num-guest-text">Guests: {{ totalCount }}</div>
      </div>
      <div class="expandable" :class="{ active: isActive }">
      <div class="guest-counter">
        <div class="type">Adult:</div>
        <div>{{ adultCount }}</div>
        <div class="buttons">
          <button @click="adultCount++, totalCount++">+</button>
          <button @click="subtractAdult">-</button>
        </div>
      </div>
      <div class="guest-counter">
        <div class="type">Children:</div>
        <div>{{ childrenCount }}</div>
        <div class="buttons">
          <button @click="childrenCount++, totalCount++">+</button>
          <button @click="subtractChildren">-</button>
        </div>
      </div>
      <div class="close">
        <span>Close</span>
        <button @click="isActive = !isActive">X</button>
      </div>
    </div>
    </div>
  </div>

  <div class="sum">
    <div class="group">
      <div>Service fee:</div>
      <div>
        {{ sum == 0 || isNaN(sum) ? '15%' : `${Math.round(sum * 0.15)} $` }}
      </div>
    </div>
    <div class="group">
      <div>Total:</div>
      <div>
        {{
          sum == 0 || isNaN(sum)
            ? 'Select all fields'
            : `${Math.round(sum * 1.15)} $`
        }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['numOfDays', 'pricePerNight', 'price'],
  emits: ['num-guest'],

  data() {
    let data = {
      adultCount: 0,
      childrenCount: 0,
      totalCount: 0,
      isActive: false,
      sum: 0,
    }
    data = Object.assign({}, data, this.numOfDays)
    return data
  },

  watch: {
    totalCount: function () {
      this.sum = this.numOfDays * this.price * this.totalCount
    },
    numOfDays: function () {
      this.sum = this.numOfDays * this.price * this.totalCount
    },
    sum: function () {
      this.$emit('num-guest', this.adultCount, this.childrenCount, this.sum)
    },
  },

  methods: {
    subtractAdult() {
      this.adultCount == 0
        ? (this.adultCount = 0)
        : (this.adultCount--, this.totalCount--)
    },
    subtractChildren() {
      this.childrenCount == 0
        ? (this.childrenCount = 0)
        : (this.childrenCount--, this.totalCount--)
    },
  },
}
</script>

<style scoped>
.center{
  display: flex;
  justify-content: center;
  width: 100%;
}
.container {
  display: flex;
  font-size: 1.3rem;
  margin-top: 10px;
  justify-content: center;
  background-color: rgb(255, 255, 255);
  width:calc(100% - 20px);
  padding: 10px;
  border-radius: 7px;
  border: 1px solid black;
}
.link {
  margin: 0 0.5rem 0 0.5rem;
  width: 100%;
  display: block;
  height: 2rem;
  position: relative;
  display: flex;
  align-items: center;
  border-radius: 5px;
}
.close {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin: 1rem 0 1rem 1rem;
}

.link:hover {
  cursor: pointer;
  color: red;
}

.num-guest-text {
  margin-left: 1rem;
}

.sum {
  margin: 0.5rem 0.5rem;
  width: 93%;
  margin: 0.7rem;
  background-color: rgb(226, 224, 224);
  background: rgb(219, 240, 219);
  
  padding: 0.3rem;
}

.sum > div {
  font-size: 1.2rem;
  display: flex;
  justify-content: space-between;
}

button {
  width: 30px;
  height: 20px;
  border-radius: 6px;
  border: 1px solid #005b96;
}

button:hover {
  cursor: pointer;
}

.expandable {
  display: none;
  opacity: 0;
  transition: opacity 300ms;
}

.type {
  width: 14px;
  font-size: 1.1rem;
}

div {
  font-size: 1.3rem;
}

.guest-counter {
  margin-bottom: 5px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.custom-select {
  width: 100%;
}

.active {
  padding: 10px 5px 10px 5px;
  opacity: 1;
  justify-content: space-between;
  position: absolute;
  z-index: 100;
  display: flex;
  flex-direction: column;
  width: 16rem;
  background: white;
  border: 1px solid black;
  border-radius: 0 0 4px 4px;
  margin-top: 40px;
}

.group {
  font-size: 1.3rem;
  margin: 0.3rem 0;
}

.close button {
  cursor: pointer;
}

@media screen and (max-width: 600px) {
  .link {
    width: 50%;
  }

  .num-guest-text {
    font-size: 0.9rem;
  }
}
</style>
