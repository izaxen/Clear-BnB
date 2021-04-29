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

  computed: {
    calcDays() {
      let dayInMs = 24 * 60 * 60 * 1000
      let dayOne = this.fromDate.split('-')
      dayOne = new Date(...dayOne).getTime()
      let dayTwo = this.toDate.split('-')
      dayTwo = new Date(...dayTwo).getTime()
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
  width: 45%;
  background: rgb(137, 136, 136);
  -webkit-appearance: none;
}
</style>
