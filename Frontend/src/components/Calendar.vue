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
      let a = this.fromDate.split('-')
      a = new Date(...a).getTime()
      let b = this.toDate.split('-')
      b = new Date(...b).getTime()
      let c = Math.abs((a - b) / dayInMs)

      return this.$emit('days-selected', c)
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
