<template>
<div class="calendar">
    <form class="box-bg" @submit.prevent>
    <div class="mb-4">
            
      <div v-if="searchBar" class="text">
        <span class="check-in-out-text">Check in</span >
        <span class="check-in-out-text1">Check out</span>
      </div>
      <div v-else class="text">
        <span class="check-in-out-text">Available from</span >
        <span class="check-in-out-text1">Available to</span>
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
    "textOne",
    "searchBar"
  ],

  data() {
    return {
      
      range: {
        start: new Date(),
        end: new Date()
        },
      masks: {
        input: 'YYYY-MM-DD',
      },
      disabledDates: [],
      
    };
  },

watch:{
range: function(){
    
    this.$emit('dates', this.range.start, this.range.end)
    this.$emit('days-selected', this.findSelectedDays().length-1)
  },

},

methods:{
    findSelectedDays(){
      for(var arr=[],dt=new Date(this.range.start); dt<=this.range.end; dt.setDate(dt.getDate()+1)){
      arr.push(new Date(dt));
    }
    return arr;

    },
    findAllDisabledDates(receiptArray){
      let disabled = []
      for(let i=0; i<receiptArray.length; i++){
        for(let dt=receiptArray[i].checkInDate; dt<=this.addDays(receiptArray[i].checkOutDate, -1); dt.setDate(dt.getDate()+1)){
      disabled.push(new Date(dt));
      }
      this.disabledDates = disabled
      
    }
   },
   filterReceipts(){
     let testReceipts = [
       { 
         rentalObjectId : "1",
         checkInDate: new Date('2021-06-02'), 
         checkOutDate : new Date('2021-06-07')
       },
        { 
         rentalObjectId: "2",
         checkInDate: new Date('2021-06-03'), 
         checkOutDate : new Date('2021-06-09')
       },
        { 
         rentalObjectId: "2",
         checkInDate: new Date('2021-06-13'), 
         checkOutDate : new Date('2021-06-16')
       },
     ]
      //this.$store.state.receipts instead of testReceipts
      
     let receipts = testReceipts.filter((rec) => 
        this.rentalObject.id == rec.rentalObjectId)

        
      this.findAllDisabledDates(receipts)
   },
   addDays(firstDate, daysToAdd) {
      let secondDate = new Date(firstDate.valueOf())
      secondDate.setDate(secondDate.getDate() + daysToAdd);
      return secondDate
    }
  },
  created(){
    if(this.rentalObject!=null){
       
        this.range.start = this.rentalObject.availableFrom.valueOf() > new Date().valueOf() ? this.rentalObject.availableFrom : new Date()
        this.rentalObject.availableFrom = this.rentalObject.availableFrom.valueOf() < new Date().valueOf() ? new Date() : this.rentalObject.availableFrom  
      }
      this.range.end = this.addDays(this.range.start, 2)//.addDays()
  },
  mounted(){
    if(this.rentalObject != null){
    
    this.filterReceipts()
    }
  }
  
}
</script>

<style scoped>

.calendar{
  display: flex;
  width: 100%;
  max-width: 21rem;
  flex-direction: column;
  align-items:flex-end;
  justify-content: center;
}
.box-bg{
align-items:flex-end;
padding: 0 0.5rem;
background-color: rgb(255, 255, 255);
}
.select-date{
  text-align: left;
  
  font-size: 0..875rem;
  font-weight: 700;
  display:block;
  }

.date-range{
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-self:flex-end;

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
margin:  -0.15rem 0.5rem 0 0.5rem;

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
  font-size: 12px;
  color: #718096;
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
