<template>
  <div>
    <div class="container">
      <div class="link" @click="isActive = !isActive">
        <div class="num-guest-text">Number of guests {{ totalCount }}</div>
      </div>
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

  <div class="sum">
    <div>Total:</div>
    <div>{{ sum == 0 || isNaN(sum) ? 'Select all fields' : `${sum} kr` }}</div>
  </div>
</template>

<script>
export default {
  props: ['numOfDays'],
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
      this.sum = this.numOfDays * 87 * this.totalCount
    },
    numOfDays: function () {
      this.sum = this.numOfDays * 87 * this.totalCount
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
    close() {},
  },
}
</script>

<style scoped>
* {
  font-weight: 500;
  font-size: 0.9rem;
}
.link {
  margin: 0 0.5rem 0 0.5rem;

  display: block;
  height: 2rem;
  border-radius: 1px;
  position: relative;
  display: flex;
  align-items: center;
  border: 1px solid black;
  border-radius: 5px;
  background: #b3cde0;
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
  margin: 0 0.5rem;
  display: flex;
  justify-content: space-between;
}

.sum > div {
  font-size: 1.4rem;
}

button {
  width: 30px;
  height: 20px;
  border-radius: 6px;
  border: 1px solid #005b96;
}

button:hoover {
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
  font-size: 1.1rem;
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
  width: 17.5rem;
  background: #b3cde0;
  margin-left: 0.5rem;
  border-left: 1px solid black;
  border-right: 1px solid black;
  border-bottom: 1px solid black;
  border-radius: 0 0 4px 4px;
}

.close button {
  cursor: pointer;
}
</style>
