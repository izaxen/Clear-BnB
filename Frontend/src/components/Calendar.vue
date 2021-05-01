<template>
  <div>
    <input v-model="fromDate" v-bind="calcDays" type="date" />
    <input v-model="toDate" v-bind="calcDays" type="date" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      fromDate: '',
      toDate: '',
    }
  },

  watch: {
    toDate: function () {
      let dayOne = new Date(this.fromDate)
      let dayTwo = new Date(this.toDate)
      if (dayOne && dayTwo) {
        return this.$emit('dates', dayOne, dayTwo)
      }
    },
  },

  computed: {
    calcDays() {
      let dayInMs = 24 * 60 * 60 * 1000

      let dayOne = new Date(this.fromDate).getTime()
      let dayTwo = new Date(this.toDate).getTime()
      let diff = Math.abs((dayOne - dayTwo) / dayInMs)

      return this.$emit('days-selected', diff)
    },
  },
}
</script>

<style scoped>
div {
  justify-content: space-between;
  display: flex;
  flex-direction: row;
}
input {
  -webkit-appearance: none;
  box-shadow: none !important;
}

input {
  height: 2rem;

  font-size: 0.8rem;
  width: 48%;
  background: rgb(137, 136, 136);
  border: 1px solid black;
}
</style>
