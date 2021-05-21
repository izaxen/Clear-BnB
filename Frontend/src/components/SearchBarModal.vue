<template>
  <div class="modal-backdrop">
    <div class="modal-frame">
      <form class="search-box">
        
        <div class="city-search">
          
          <select @click="showCityNames" class="box1" v-model="city">
            <option :value="cityName" selected>--Cities--</option>
            <option v-for="city in cities" :key="city" :value="city">
              {{ city }}
            </option>
          </select>
        </div>
        
        
        <div class="calendar-search">
          <Calendar
            @days-selected="receive"
            @dates="confirmDates"
            @defaultDates="confirmDates"
            @dateArray="getDateArray"
            :searchBar="searchBar"
          />
        </div>


        <div class="choose-guest border-radius">
          <div class="person-div">
          <p>{{ guests }} {{ guestText }}</p>
            <div class="plus-add-btn border-radius">
            <label id="add-btn" @click="addGuests">+</label>
            <label id="sub-btn" @click="subtractGuest">-</label>
            </div>
          </div>
        

        <div class="search">
        <a class="search-big" href="#">
          <em class="fas fa-search" @click="addSearch"></em>
        </a>
        </div>

        <div class="close-btn">
         <label id="close" @click="close">Go back</label>
         </div></div>
      </form>

     
    </div>
  </div>
  
</template>

<script>
import Calendar from './Calendar.vue'

export default {
  components: {
    Calendar,
  },

  data() {
    return {
      searchBar: true,
      city: '',
      cities: [],
      cityName: '',
      guests: 1,
      guestText: 'Guest',
      days: '',
      fromDate: '',
      toDate: '',
      dateArray: [],
    }
  },

  methods: {
    receive(data) {
      this.days = data
    },

    confirmDates(from, to) {
      this.fromDate = from
      this.toDate = to
    },
    getDateArray(array) {
      this.dateArray = array
    },

    showCityNames() {
      let getCitys = this.$store.state.rentalObjects
      for (let cityName of getCitys) {
        this.cities.push(cityName.city)
      }

      let removedDuplicates = this.cities.filter((value, index) => {
        return this.cities.indexOf(value) === index
      })
      this.cities = removedDuplicates
    },

    changeGuestText() {
      this.guestText = this.guests === 1 ? 'Guest' : 'Guests'
    },
    addGuests() {
      this.guests++
      this.changeGuestText()
    },
    subtractGuest() {
      if (this.guests > 0) {
        this.guests--
        this.changeGuestText()
      }
    },

    close() {
      console.log('close modal')
      this.$emit('close')
      this.isVisibility = false
    },

    addSearch(event) {
      let search = {
        city: this.city,
        guests: this.guests,
        startDate: this.fromDate,
        endDate: this.toDate,
        dateArray: this.dateArray,
      }
      this.$emit('close')
      this.$store.commit('setSearchObject', search)
      this.$router.push('/overview')

      //nollställer data
      this.cities = []
      this.cityName = ''
      this.guests = 1
      this.guestText = 'Guest'
      this.days = ''
      this.fromDate = ''
      this.toDate = ''
      this.dateArray = ''
    },
  },
}
</script>

<style scoped>

.modal-frame {
  display: grid;
  grid-template-rows: 25% 25% 25% 25%;
  grid-template-areas: 
  "top"
  "mid-top"
  "mid-bot"
  "bot";
  overflow-x: auto;
  color: black;
  border: 1px solid #011f4b;
  box-shadow: rgb(49, 48, 48) 0px 3px 3px;
  width: 350px;
  height:px;
  background-color: rgb(205,205,205);
  border-radius: 5px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

.city-search{
  grid-area: top;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin: 15px
}

.city-name {
  margin: 0;
  padding: 0;
  font-size: 0.8rem;
  color: gray;
}

.calendar-search{
  grid-area: mid-top ;
  display:flex;
  justify-content: center;
  margin: 0 5px;
}

.choose-guest{
  grid-area: mid-bot;
  display: grid;
  grid-template-columns: 33% 34% 33%;
  grid-template-areas:
  "lh mid rh";
  margin: 15px;
  background-color: rgb(245,245,245);
  justify-items: center;
}

.search{
  grid-area: mid;
  display: flex;
  justify-content: center;
  align-items: center;
  
}

.person-div {
  grid-area: lh;
  display: flex;
  flex-direction: column;
  justify-items: center;
    
}

.person-div p {
  font-size: 1rem;
  margin: 10px 10px -5px 10px;
  align-self: center;
}

label{
  margin: 0 10px;
}

#add-btn, #sub-btn{
  font-size: xx-large;
  margin-top: -5px
}

#add-btn:hover,#sub-btn:hover {
  scale: 1.3;
}

.plus-add-btn{
  display:flex;
  align-items: center;
  margin: 10px;
  background: rgb(201, 232, 201);
}

option {
  color: rgb(0, 0, 0);
  font-weight: 600;
  background: rgb(219,240,219);
  padding: 10px;
  font-size: 17px;
  border-radius:35px;
}

.box1 {
  border-right: 1px solid gray;
  cursor: pointer;
}

.box1:hover > .search-btn {
  background: #000000;
}

.box1 {
  margin-left: 1rem;
  outline: none;
  padding: 2px;
  color: rgb(113, 128, 150);
  height: 28px;
  font-size: 15px;
  transition: 0.4s;
  width: 6rem;
  border: 1px solid black;
  border-radius: 5px;
  background: rgb(245,245,245);
}


.fa-search {
  font-size: 40px;
  color:  #007973a6;
}

.close-btn{
  display:flex;
  align-items: flex-end;
  }

  #close{
    text-align: center;
    width: 67px;
    background: rgb(219,240,219);
    margin: 10px;
    cursor: pointer;
    background: rgb(201, 232, 201);
    border-radius: 5px;
    border: 1px solid black;
    padding: 3px;
    
  
  }

</style>
