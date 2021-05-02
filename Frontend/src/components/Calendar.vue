<template>
<div class="calendar">
  
  <form class="box-bg" @submit.prevent>
    <div class="mb-4">
      <span class="select-date">Choose date</span >
      <div class="text">
        <span class="check-in-out-text">Check in</span >
        <span class="check-in-out-text1">Check out</span >
      </div>
      <DatePicker
        v-model="range"
        mode="date"
        :masks="masks"
        is-range
        :min-date="rentalObject==undefined ? new Date() : rentalObject.availableFrom"
        :max-date="rentalObject==undefined ? '' : rentalObject.availableTo"
        :disabled-dates="disabledDates"
      >
        <template v-slot="{ inputValue, inputEvents, isDragging }">
          <div class="date-range">
            <div class="single-date-box">
              <svg
                class="calendar-logo"
                fill="none"
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                ></path>
              </svg>
              <input
                class="chosen-date-box text-gray-900"
                :class="isDragging ? 'text-gray-600' : 'text-gray-900'"
                :value="inputValue.start"
                v-on="inputEvents.start"
              />
            </div>
            <span class="divider-arrow-box">
              <svg
                class="divider-arrow"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M14 5l7 7m0 0l-7 7m7-7H3"
                />
              </svg>
            </span>
            <div class="single-date-box text-gray-900">
              <svg
                class="calendar-logo"
                fill="none"
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                ></path>
              </svg>
              <input
                class="chosen-date-box co"
                :class="isDragging ? 'text-gray-600' : 'text-gray-900'"
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
import { Calendar, DatePicker } from 'v-calendar';

export default {
  components: {
    Calendar,
    DatePicker,
  },
  props:[
    "rentalObject",
    "disabledDates"
  ],

  data() {
    return {
      
      range: {
        start: new Date(),
        end: new Date()
        },
      masks: {
        input: 'YYYY-MM-DD',
      }
      
    };
  },

watch:{
range: function(){
  console.log('this.rentalObject', this.rentalObject)
    this.$emit('dates', this.range.start, this.range.end)
    this.$emit('days-selected', this.addDaysToArray().length-1)
  },

},


  methods:{
    addDaysToArray(){
      for(var arr=[],dt=new Date(this.range.start); dt<=this.range.end; dt.setDate(dt.getDate()+1)){
      arr.push(new Date(dt));
    }
    return arr;

    },
    findAllDisabledDates(){
    for(var arr=[],dt=new Date(this.range.start); dt<=this.range.end; dt.setDate(dt.getDate()+1)){
      arr.push(new Date(dt));
    }
   }
  },

  created(){
    this.$store.dispatch('fetchReceipts')
        
    Date.prototype.addDays = function() {
      var date = new Date(this.valueOf());
      date.setDate(date.getDate() + 2);
      return date
    }
    //this.range.start = rentalObject.availableFrom
  
      if(this.rentalObject!=null){
        this.range.start = this.rentalObject.availableFrom.valueOf() > new Date().valueOf() ? this.rentalObject.availableFrom : new Date()
        this.rentalObject.availableFrom = this.rentalObject.availableFrom.valueOf() < new Date().valueOf() ? new Date() : this.rentalObject.availableFrom  
      }
      this.range.end = this.range.start.addDays()
  }
  
}
</script>

<style scoped>
.calendar{
  display: flex;
  width: 100%;
  max-width: 21rem;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.box-bg{
box-shadow: 0 4px 6px -1px rgba(0,0,0,.1),0 2px 4px -1px rgba(0,0,0,.06);
padding: 1.5rem;
border-radius: .25rem;
background-color: rgb(255, 255, 255);

}
.mb-4{
  margin-bottom: 1rem;
}
.select-date{
  text-align: left;
  margin-bottom: 0.5rem;
  font-size: 0..875rem;
  font-weight: 700;
  display:block;
  }

.date-range{
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  display: flex;
}
.single-date-box{
  position: relative;
  flex-grow:1;
  border-radius: 0;
}

.calendar-logo{
width: 1rem;
position: absolute;
pointer-events: none;
margin: 0 0.5rem;
height: 100%;

}
.chosen-date-box{
width: 100%;
padding: 0.25rem 0.25rem 0.25rem 2rem;
flex-grow:1;
border-width: 1px;
border-radius: 0.25rem;
background-color:rgb(233, 233, 233) ;
line-height: inherit;
overflow: visible;
font-family: inherit;
font-size: 100%;
margin: 0;

}
.divider-arrow-box{
margin:0.5rem;
flex-shrink: 0;
}
.divider-arrow{
  width: 1rem;
  stroke: currentColor;
  height: 1rem;
  display: block;
}

.text{
  display: flex;
  justify-content:space-around;
}
.check-in-out-text1{
  margin-left: 2rem;
}
.check-in-out-text{
  margin-left: 0.2;
}

.text-gray-600 {
    --text-opacity: 1;
    color: #718096;
    color: rgba(113,128,150,var(--text-opacity));}

    .text-gray-900 {
    --text-opacity: 1;
    color: #1a202c;
    color: rgba(26,32,44,var(--text-opacity));}

</style>