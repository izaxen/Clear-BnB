<template>
  <div class="calendar">
    <form class="box-bg" @submit.prevent>
      <div class="mb-4">
        <div v-if="searchBar" class="text">
          <!--<span class="check-in-out-text">Check in</span>
          <span class="check-in-out-text1">Check out</span>-->
        </div>
        <div v-else class="text">
          <span class="check-in-out-text">Available from</span>
          <span class="check-in-out-text1">Available to</span>
        </div>
        <DatePicker
          color="green"
          :columns="2"
          v-if="range.end != null"
          v-model="range"
          mode="date"
          :masks="masks"
          is-range
          :min-date="
            rentalObject == undefined ? new Date() : rentalObject.availableFrom
          "
          :max-date="rentalObject == undefined ? '' : rentalObject.availableTo"
          :disabled-dates="disabledDates"
        >
          <template v-slot="{ inputValue, inputEvents, isDragging }">
            <div class="date-range">
              <div
                class="single-date-box"
                :class="booking ? 'smaller-width solid-border font-smaller-thicker' : ''"
              >
                <svg
                  class="calendar-logo"
                  fill="none"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  viewBox="0 0 24 24"
                  stroke="black"
                >
                  <path
                    d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                  ></path>
                </svg>
                <input
                  class="chosen-date-box"
                  :class="[
                    isDragging ? 'text-gray-500' : 'text-black-500',
                    booking ? 'booking' : '',
                  ]"
                  :value="inputValue.start"
                  v-on="inputEvents.start"
                />
              </div>
              <span class="divider-arrow-box">
                <svg class="divider-arrow" viewBox="0 0 24 24">
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M14 5l7 7m0 0l-7 7m7-7H3"
                  />
                </svg>
              </span>
              <div
                class="single-date-box text-black-500"
                :class="booking ? 'smaller-width solid-border font-smaller-thicker' : ''"
              >
                <svg
                  class="calendar-logo"
                  fill="none"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  viewBox="0 0 24 24"
                  stroke="black"
                >
                  <path
                    d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                  ></path>
                </svg>
                <input
                  class="chosen-date-box co"
                  :class="[
                    isDragging ? 'text-gray-500' : 'text-black-500',
                    booking ? 'booking' : '',
                  ]"
                  :value="inputValue.end"
                  v-on="inputEvents.end"
                />
              </div>
            </div>
          </template>
        </DatePicker>
      </div>
    </form>
  </div>
</template>

<script>
import { Calendar, DatePicker } from 'v-calendar'

export default {
  components: {
    Calendar,
    DatePicker,
  },
  props: ['textOne', 'searchBar', 'booking'],

  data() {
    return {
      receipts: null,
      rentalObject: '',
      range: {
        start: new Date(),
        end: null,
      },
      masks: {
        input: 'YYYY-MM-DD',
      },
      disabledDates: [],
    }
  },

  watch: {
    range: function () {
      this.$emit('dates', this.range.start, this.range.end)
      this.$emit('days-selected', this.findSelectedDays().length - 1)
      this.$emit('dateArray', this.findAllNights())
    },
  },

  methods: {
    findAllNights() {
      let allDates = this.findSelectedDays()
      allDates.pop()
      return allDates
    },
    findSelectedDays() {
      for (
        var arr = [], dt = new Date(this.range.start);
        dt <= this.range.end;
        dt.setDate(dt.getDate() + 1)
      ) {
        arr.push(new Date(dt))
      }
      return arr
    },
    findAllDisabledDates() {
      let disabled = []
      for (let i = 0; i < this.receipts.length; i++) {
        for (
          let dt = new Date(this.receipts[i].startDate);
          dt <= this.addDays(new Date(this.receipts[i].endDate), -1); //-1 to avoid disabling the check-out date
          dt.setDate(dt.getDate() + 1)
        ) {
          disabled.push(new Date(dt))
        }
        this.disabledDates = disabled
      }
      this.findFirstAvailable()
    },
    async filterReceipts() {
      this.receipts = await this.$store.state.receipts.filter(
        (rec) => this.rentalObject.id == rec.rentalObjectId
      )
      this.findAllDisabledDates()
    },
    addDays(firstDate, daysToAdd) {
      let secondDate = new Date(firstDate.valueOf())
      secondDate.setDate(secondDate.getDate() + daysToAdd)
      return secondDate
    },
    findFirstAvailable() {
      let startDate = new Date(this.range.start)
      console.log('startDate', startDate)
      let endDate = this.addDays(startDate, 1)
      for (let j = 0; j < this.disabledDates.length; j++) {
        if (
          (startDate.getDate() === this.disabledDates[j].getDate() &&
            startDate.getMonth() === this.disabledDates[j].getMonth()) ||
          (endDate.getDate() === this.disabledDates[j].getDate() &&
            endDate.getMonth() === this.disabledDates[j].getMonth())
        ) {
          startDate = this.addDays(this.disabledDates[j], 1)
          endDate = this.addDays(this.disabledDates[j], 2)
          j = 0
        }
      }
      this.range.start = startDate
      this.range.end = this.addDays(endDate, 1)
    },
    checkDateEquality(firstDate, secondDate) {
      return firstDate.valueOf() == secondDate.valueOf()
    },
  },
  async created() {
    this.rentalObject = this.$store.state.rentalObject
    if (this.rentalObject != undefined) {
      this.range.start =
        this.rentalObject.availableFrom.valueOf() > new Date().valueOf()
          ? this.rentalObject.availableFrom
          : new Date()
      this.rentalObject.availableFrom =
        this.rentalObject.availableFrom.valueOf() < new Date().valueOf()
          ? new Date()
          : this.rentalObject.availableFrom
    }
    if (this.rentalObject != undefined) {
      await this.filterReceipts()
    }
    this.range.end = this.addDays(this.range.start, 2)
  },
}
</script>

<style scoped>
.calendar {
  /* font-family: 'Yanone Kaffeesatz', 'Lucida Grande', Lucida, Verdana, sans-serif; */

  display: flex;
  width: 100%;
  max-width: 21rem;
  flex-direction: column;
  justify-content: center;
  
  
}

.booking {
  background: rgb(201, 232, 201) !important;

  border-radius: 7px;
  border: 1px solid black;
  height: 2rem;
}
.box-bg {
  padding: 0 0.5rem;
}
.select-date {
  text-align: left;
  font-size: 0.875rem;
  font-weight: 700;
  display: block;
}

.date-range {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-self: flex-end;
}
.solid-border{
  font-size: 1.1rem;
  border: 1px solid black;
  border-radius: 7px;
}

.font-smaller-thicker{
}

.single-date-box {
  align-self: center;
  position: relative;
  flex-grow: 1;
  width: 8.5rem;
}
.smaller-width {
  width: 7rem;
}

.calendar-logo {
  width: 1rem;
  position: absolute;
  pointer-events: none;
  margin: 0 0.5rem 0 0.5rem;
  height: 100%;
}

.chosen-date-box {
  width: 100%;
  padding: 0.25rem 0.25rem 0.25rem 2rem;
  flex-grow: 1;
  border: none;
  line-height: inherit;
  overflow: visible;
  font-family: inherit;
  font-size: 100%;
}
.divider-arrow-box {
  margin: 0.5rem;
  flex-shrink: 0;
}
.divider-arrow {
  width: 1rem;
  stroke: currentColor;
  height: 1rem;
  display: block;
}

.text {
  display: flex;
  justify-content: space-around;
  font-size: 1rem;
}
.check-in-out-text1 {
  margin-left: 2rem;
}
.check-in-out-text {
  margin-left: 0.2;
}

.text-gray-500 {
  --text-opacity: 1;
  color: rgba(8, 8, 8, 0.61);
  font-weight: 500;
}

.text-black-500 {
  --text-opacity: 1;
  color: black, var(--text-opacity);
  font-weight: 500;
}
</style>
