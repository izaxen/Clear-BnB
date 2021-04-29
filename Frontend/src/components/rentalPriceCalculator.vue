<template>
  <div class="container">
    <a @click="isActive = !isActive">
      <span>Antal gäster {{ totalCount }}</span>
    </a>

    <div class="expandable" :class="{ active: isActive }">
      <div class="guest-counter">
        <div class="type">Vuxna:</div>
        <div>{{ adultCount }}</div>
        <div class="buttons">
          <button @click="adultCount++, totalCount++">+</button>
          <button @click="subtractAdult">-</button>
        </div>
      </div>
      <div class="guest-counter">
        <div class="type">Barn:</div>
        <div>{{ childrenCount }}</div>
        <div class="buttons">
          <button @click="childrenCount++, totalCount++">+</button>
          <button @click="subtractChildren">-</button>
        </div>
      </div>
    </div>
  </div>
  {{ numOfDays }}

  <div>Sum: {{ sum == 0 ? 'Inget valt' : sum }}</div>
</template>

<script>
export default {
  props: ['numOfDays'],

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
a {
  background: rgb(137, 136, 136);
  width: 100%;
  display: block;
  height: 2rem;
  border-radius: 4px;
}
a:hover {
  cursor: pointer;
  color: red;
}

span {
  align-self: center;
  justify-self: center;
}
button {
  width: 40px;
  height: 20px;
}

.expandable {
  display: none;
}

.type {
  width: 14px;
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
  justify-content: space-between;
  position: absolute;

  z-index: 100;
  display: flex;
  flex-direction: column;

  width: 280px;
  background: rgb(137, 136, 136);

  border-radius: 0 0 4px 4px;
}
</style>
