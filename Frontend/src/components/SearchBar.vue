<template>
  <!-- v-if="$route.path !='/overview'" -->
  <form class="search-box">
    <select @click="showCityNames" class="box1" v-model="city">
      <option :value="cityName" selected>--Citys--</option>
      <option v-for="city in citys" :key="city" :value="city">
        {{ city }}
      </option>
    </select>
    <Calendar
      @days-selected="receive"
      @dates="confirmDates"
      @defaultDates="confirmDates"
      @dateArray="getDateArray"
      :searchBar="searchBar"
    />
    <div class="box4">
      <p>{{ guests }} {{ guestText }}</p>
      <div class="person-div">
        <!--<p>Guests: {{guests}}</p>-->
        <button type="button" @click="addGuests">+</button>
        <button type="button" @click="subtractGuest">-</button>
      </div>
    </div>

    <a class="search-btn" href="#">
      <em class="fas fa-search" @click="addSearch"></em>
    </a>
  </form>
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
      /* else if(this.guests === 0 )
      this.guests = 0*/
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
      //här vill jag att vi resettar hela formen, får inte rätt på det - A
      event.toElement.parentElement.parentElement.reset()
      this.$router.push('/overview')
    },
  },
}
</script>

<style scoped>
option {
  color: rgb(0, 0, 0);
  font-weight: 600;
  background: #59deff93;
  padding: 10px;
  font-size: 17px;
}

button {
  height: 20px;
  width: 20px;
  align-self: center;
  margin-left: 5px;
}

.person-div {
  display: flex;
  overflow: hidden;
  justify-content: center;
  align-content: center;
  position: absolute;
  text-align: left;
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
}
.box4 {
  border-left: 1px solid gray;
}
.search-box {
  display: flex;
  background: #fbfbfb;
  height: 60px;
  border-radius: 40px;
  padding: 10px;
  width: fit-content;
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
  border: none;
  background: none;
  outline: none;
  padding: 2px;
  color: rgb(113, 128, 150);
  font-size: 15px;
  transition: 0.4s;
  width: 150px;
}

.box4 {
  position: relative;
  display: grid;
  justify-content: center;
  align-content: center;
  padding: 2px;
  color: rgb(113, 128, 150);
  font-size: 20px;
  transition: 0.4s;
  line-height: 40px;
  width: 150px;
}

.box4:hover {
  cursor: pointer;
}
</style>
