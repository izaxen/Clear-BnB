<template>
  <div class="modal">
    <form class="search-box">
      <div class="card">
        <p class="city-name">City</p>
        <select @click="showCityNames" class="box1" v-model="city">
          <option :value="cityName" selected>--Citys--</option>
          <option v-for="city in citys" :key="city" :value="city">
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
          <button type="button" @click="addGuests">+</button>
          <button type="button" @click="subtractGuest">-</button>
        </div>
      </div>

      <a class="search-big" href="#">
        <em class="fas fa-search" @click="addSearch"></em>
      </a>
    </form>
    <div class="x" @click="close">X</div>
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
      citys: [],
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
        this.citys.push(cityName.city)
      }

      let removedDuplicates = this.citys.filter((value, index) => {
        return this.citys.indexOf(value) === index
      })
      this.citys = removedDuplicates
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
      this.citys = []
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
.modal {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: grid;
  justify-content: center;
  align-items: center;
  z-index: 10;
}
option {
  color: rgb(0, 0, 0);
  font-weight: 600;
  background: #59deff93;
  padding: 10px;
  font-size: 17px;
}

.card {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-bottom: 5px;
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
  font-size: 0.8rem;
  color: gray;
}

p {
  font-size: 1rem;
}

.box1 {
  border-right: 1px solid gray;
  cursor: pointer;
}
.box4 {
  width: 20rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.person-div {
  font-size: 1rem;

  display: flex;
  flex-direction: row;
}

.person-div p {
  font-size: 1rem;
}
.search-box {
  display: flex;
  flex-direction: column;
  background: #fbfbfb;

  padding: 10px;
  width: 100%;
  align-items: center;
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
  color: rgb(113, 128, 150);
  height: 28px;
  font-size: 15px;
  transition: 0.4s;
  width: 6rem;

  border: 1px solid black;
  border-radius: 5px;
  background: #e9e9e9;
}

.box4:hover {
  cursor: pointer;
}

.fa-search {
  font-size: 1.4rem;
  color: red;
}

.x {
  cursor: pointer;
}
</style>
