<template>
  <div class="center">
    <div class="container">
      <div class="link" @click="isActive = !isActive">
        <p class="num-guest-text">Guests:</p>
        <p class="num-guest-text">{{ totalCount }}</p>
      </div>
      <div class="expandable" :class="{ active: isActive }">
      <div class="guest-counter">
        <div class="type">Adults</div>
        <div class="buttons">
          <button @click="subtractAdult">-</button>
          <div class="count">{{ adultCount }}</div>
          <button @click="adultCount++, totalCount++">+</button>
        </div>
      </div>
      <div class="guest-counter">
        <div class="type">Children</div>
        <div class="buttons">
          <button @click="subtractChildren">-</button>
          <div class="count">{{ childrenCount }}</div>
          <button @click="childrenCount++, totalCount++">+</button>
        </div>
      </div>
      <div class="close">
        
        <button class="exit" @click="isActive = !isActive">Close</button>
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
  background-color: rgb(255, 254, 254);
  width:calc(100% - 20px);
  padding: 10px;
  border-radius: 7px;
  border: 1px solid black;
}
.link {
  display: flex;
  width: 100%;
  height: 2rem;
  position: relative;
  align-items: center;
  border-radius: 5px;
  justify-content: space-between;
}
.close {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin: 1rem 0 -0.2rem;
}

.count{
  display: flex;
  justify-content: center;
  width: 2rem;
}

.link:hover {
  cursor: pointer;
  color: red;
}

.num-guest-text {
  margin: 0 0.5rem;
  display: flex;
  justify-content: space-between;
}

.sum {
  margin: 0.5rem 0.5rem;
  width: 93%;
  margin: 0.7rem;
  background-color: rgba(236, 235, 235, 0.397);
  border-radius: 7px;
  padding: 0.3rem;
}

.sum > div {
  font-size: 1.2rem;
  display: flex;
  justify-content: space-between;
}

.buttons{
  display: flex;
  flex-direction: row;
  margin-right: 0.3rem;
  align-items: flex-end;
}

button {
  display: flex;
  width: 1.2rem;
  height: 1.2rem;
  padding: 0.6rem;
  justify-content: center;
  align-items: center;
  border-radius: 70px;
  background-color: rgb(219, 240, 219);
  border: 1px solid rgb(219, 240, 219);
  box-shadow: gray 0.6px 1px 1px 0.6px;
}

button:hover {
  cursor: pointer;
  background-color: rgb(191, 204, 191);
  border: 1px solid rgb(206, 204, 204);
}

.expandable {
  display: none;
  opacity: 0;
  transition: opacity 300ms;
}

.type {
  margin: 0.5rem 0 0 0.5rem;
  width: 5rem;
  font-size: 1.1rem;
  font-weight: 600;
}

div {
  font-size: 1.3rem;
}

.guest-counter {
  margin-bottom: 0.7rem;
  height: 2rem;
  align-items: center;
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
  width: 16.2rem;
  background: white;
  border: 1px solid black;
  border-radius: 7px;
  /*margin-top: 40px;*/
  margin-top: -1rem;
}

.group {
  font-size: 1.3rem;
  margin: 0.3rem 0;
}

.exit{
  background-color: rgb(228, 228, 228);
  border: 1px solid rgb(228, 228, 228);
  width: 5rem;
  padding: 0.7rem 0;
  cursor: pointer;
}

.exit:hover{
   background-color: rgb(201, 200, 200);
}

@media screen and (max-width: 600px) {
  .num-guest-text {
    font-size: 1rem;
  }
}

@media screen and (max-width: 450px){
  .container{
    width: 290px;
  }
  .active{
    width: 290px;
  }
}

@media screen and (max-width: 330px) {
    .container{
    width: 250px;
  }
   .num-guest-text {
    font-size: 1.2rem;
  }
  .active{
    width: 250px;
  }
}
</style>
