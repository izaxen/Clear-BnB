<template>
  <div>
    <div class="container">
      <div class="link" @click="isActive = !isActive">
        <div class="num-guest-text">Guests {{ totalCount }}</div>
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
        <button @click="isActive = !isActive">Close</button>
      </div>
    </div>
    </div>
  </div>

  <div class="sum">
    <div class="group">
      <div>Service fee:</div>
      <div>
        {{ sum == 0 || isNaN(sum) ? '' : `${Math.round(sum * 0.15)} kr` }}
      </div>
    </div>
    <div class="group">
      <div>Total:</div>
      <div>
        {{
          sum == 0 || isNaN(sum)
            ? ''
            : `${Math.round(sum * 1.15)} kr`
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
.container {
  font-size: 1.3rem;
  width: 100% ;
  position: relative;
}
.link {
  height: 2rem;
  border-radius: 1px;
  display: flex;
  align-items: center;
  border: 1px solid black;
  border-radius: 5px;
  background: rgb(201, 232, 201);
}
.close {
  display: flex;
  align-items: center;
  justify-content: flex-end;
}

.link:hover {
  cursor: pointer;
  color: red;
}

.num-guest-text {
  margin-left: 1rem;
}

.sum {
  margin: 0 0.5rem;
}

.sum > div {
  font-size: 1.2rem;
  display: flex;
  justify-content: space-between;
}

button {
  width: 30px;
  height: fit-content;
  border-radius: 6px;
  border: 1px solid #005b96;
  font-size: 15px;
  font-weight: 700;
}

button:hover {
  cursor: pointer;
  background-color: white;
}

.expandable {
  display: none;
  opacity: 0;
  transition: opacity 300ms;
  width: 100%;
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
  display: flex;
  flex-direction: column;
  padding: 10px;
  opacity: 1;
  position: absolute;
  top: 0;
  left: 0;
  z-index: 10;
  background: rgb(201, 232, 201);
  border: 1px solid black;
  border-radius: 0 0 4px 4px;
  width: 100%;
}

.group {
  font-size: 1.3rem;
}

.close button {
  cursor: pointer;
  width: fit-content;
  height: fit-content;
}

@media screen and (max-width: 600px) {
  .link {
    width: 100%;
  }

  .num-guest-text {
    font-size: 20px;
  }
}
@media screen and (max-width: 450px) {
  .container{
    margin: 10px auto
  }
  .link {
    margin: auto;
    width: 100%;
  }
  .expandable {
    width: 100%;
  }
}
</style>
