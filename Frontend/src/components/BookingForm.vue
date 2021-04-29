<template>
  <a @click="isActive = !isActive">
    <span>Antal gäster {{ totalCount }}</span>
  </a>
  <div class="expandable" :class="{ active: isActive }">
    <div class="guest-counter">
      Vuxna: {{ adultCount }}
      <div class="buttons">
        <button @click="adultCount++, totalCount++">+</button>
        <button @click="subtractAdult">-</button>
      </div>
    </div>
    <div class="guest-counter">
      Barn: {{ childrenCount }}
      <div class="buttons">
        <button @click="childrenCount++, totalCount++">+</button>
        <button @click="subtractChildren">-</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      adultCount: 0,
      childrenCount: 0,
      totalCount: 0,
      isActive: false,
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

.guest-counter {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.active {
  justify-content: space-between;
  position: absolute;
  z-index: 100;
  display: flex;
  flex-direction: column;
  background: grey;
  width: 200px;
}
</style>
