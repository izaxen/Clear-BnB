<template>
  <form class="search-box">
    <div class="card">
      <select @click="showCityNames" class="box1" v-model="city">
        <option :value="cityName" selected>- City -</option>
        <option v-for="city in cities" :key="city" :value="city">
          {{ city }}
        </option>
      </select>
    </div>
    <div class="calendar" ref="search">
      <Calendar
        @days-selected="receive"
        @dates="confirmDates"
        @defaultDates="confirmDates"
        @dateArray="getDateArray"
        :searchBar="searchBar"
      />
    </div>
    <div class="box4">
      <p>{{ guests }} {{ guestText }}</p>
      <div class="person-div">
        <!--<p>Guests: {{guests}}</p>-->
        <button type="button" @click="addGuests">+</button>
        <button type="button" @click="subtractGuest">-</button>
      </div>
    </div>
    <a class="search-big" href="#">
      <em class="fas fa-search" @click="addSearch"></em>
    </a>

    <a class="search-small" href="#">
      <em class="fas fa-search" @click="showSearchModal"></em>
    </a>
  </form>
</template>

<script>
import Calendar from './Calendar.vue'

export default {
  components: {
    Calendar,
  },

  emits: ['showSearchModal'],

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
      if (this.guests > 1) {
        this.guests--
        this.changeGuestText()
      }
    },

    showSearchModal() {
      console.log('show search')
      this.$emit('showSearchModal')
    },

    addSearch(event) {
      let search = {
        city: this.city,
        guests: this.guests,
        startDate: this.fromDate,
        endDate: this.toDate,
        dateArray: this.dateArray,
      }

      this.$store.commit('setSearchObject', search)
      this.cities = []
      this.cityName = ''
      this.guests = 1
      this.guestText = 'Guest'
      this.days = ''
      this.fromDate = ''
      this.toDate = ''
      this.dateArray = ''
      this.$router.push('/overview')
    },
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Crimson+Text:ital,wght@0,400;0,600;0,700;1,400;1,600;1,700&display=swap');

option {
  color: rgb(0, 0, 0);
  font-weight: 600;
  background: white;
  padding: 10px;
  font-size: 22px;
  font-family: 'Crimson Text', serif;
}

.card {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding-right: 7px;
  border-right: 1px solid gray;
}

button {
  height: 20px;
  width: 20px;
  align-self: center;
  margin-left: 5px;
}

.city-name {
  margin: 0;
  padding: 0;
  color: gray;
}

.person-div {
  display: flex;
  overflow: hidden;
  justify-content: center;
  align-content: center;
  position: absolute;
  font-size: 15px;
  font-weight: 800;
  width: 0;
  height: 0;
  background: white;
  top: 100%;
  left: 16%;
  border-radius: 10px;
  z-index: 10;
  transition: height 0.4s;
}

.box4:hover > .person-div {
  height: 70px;
  width: 100px;
}

.box1 {
  border-right: 1px solid gray;
  cursor: pointer;
}
.box4 {
  border-left: 1px solid gray;
}
.search-box {
  display: flex;
  border-radius: 40px;
  padding: 10px;
  align-items: center;
  height: 3.1rem;
  border: 1px solid rgb(175, 163, 163);
  font-family: 'Crimson Text', serif;
  color: black;
}

.box1:hover > .search-btn {
  background: #4aae9b;
}
.search-btn {
  color: #e84118;
  float: right;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: white;
  display: flex;
  justify-content: center;
  align-items: center;
}
.box1 {
  margin-left: 1rem;
  border: none;
  background: none;
  outline: none;
  padding: 2px;
  padding-left: 1px;
  transition: 0.4s;
  border-radius: 5px;
  width: 9rem;
}

.box4 {
  position: relative;
  display: grid;
  justify-content: center;
  align-content: center;
  padding: 2px;
  font-size: 20px;
  transition: 0.4s;
  width: 8rem;
  height: 28px;
}

.box4:hover {
  cursor: pointer;
}

.fa-search {
  font-size: 1.4rem;
  color: red;
}

.search-small {
  display: none;
  text-decoration: none;
}

@media screen and (max-width: 1200px) {
  .box4 {
    display: none;
  }
  .search-box {
    width: 100%;
  }
}
@media screen and (max-width: 1030px) {
  .box1 {
    display: none;
  }
}
@media screen and (max-width: 880px) {
  .box4,
  .box1,
  .card,
  .links {
    display: none;
  }
}
@media screen and (max-width: 580px) {
  .box4,
  .box1,
  .card,
  .calendar,
  .search-big {
    display: none;
  }
  .search-small {
    display: flex;
  }
  .search-box {
    border-radius: 100%;
    padding: 13px;
  }
}
</style>
