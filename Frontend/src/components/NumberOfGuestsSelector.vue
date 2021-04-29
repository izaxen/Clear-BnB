<template>
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

  <div>Sum: {{ calculatedPrice }}</div>
</template>

<script>
export default {
  props: ['numOfDays'],

  data() {
    return {
      adultCount: 0,
      childrenCount: 0,
      totalCount: 0,
      isActive: false,
      sum: 0,
    }
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

    computed: {
      calculatedPrice() {
        console.log(this.numOfDays)
      },
    },
  },
}
</script>

<style scoped>
a:hover {
  cursor: pointer;
  color: red;
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
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.active {
  padding: 10px 5px 10px 5px;
  justify-content: space-between;
  position: absolute;
  z-index: 100;
  display: flex;
  flex-direction: column;
  background: rgba(128, 128, 128, 0.521);
  width: 200px;
  border-radius: 4px;
}
</style>
