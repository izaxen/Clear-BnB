<template>
  <div class="height">
    <div class="shell">
      <div class="sidebar"><SideBar /></div>
      <div class="header"><h1>Add rental object</h1></div>
      <div class="addhouse">
        <div class="row1">
          <div class="objectform border-radius">
            <div class="calendar">
              <Calendar :addHouse="true" @dates="inAndOutDate" />
            </div>
            <AddRentalObjectForm
              @fetchObject="houseForm"
            />
          </div>

          <div class="add-images border-radius">
            <h3>Add 6 pictures</h3>
            <AddImageForm @formData="LoadFormData" />
          </div>
        </div>

        <div class="row2">
          <div class="amenities">
            <AddHouseAmenities @amenitieslist="amenitiesList" />
          </div>
        </div>
      </div>

      <div class="row3">
        <label
          v-if="!checkRentalForm"
          id="add-rental"
          @click="combineFormAndList()"
          >Add rental object</label
        >
        <label v-if="checkRentalForm" id="add-rental-disable"
          >Add rental object</label
        >
      </div>
    </div>
    <AddRentalObjectConfirmation @close="pushUrl" />
  </div>
</template>

<script>
import AddHouseAmenities from '../components/AddHouseAmenities.vue'
import AddRentalObjectForm from '../components/AddRentalObjectForm.vue'
import Calendar from '../components/Calendar.vue'
import AddImageForm from '../components/AddImageForm.vue'
import AddRentalObjectConfirmation from '../components/AddRentalObjectConfirmation.vue'
import SideBar from '../components/Sidebar.vue'

export default {
  components: {
    AddHouseAmenities,
    AddRentalObjectForm,
    Calendar,
    AddImageForm,
    AddRentalObjectConfirmation,
    SideBar,
  },

  data() {
    return {
      rentalAmenities: '',
      rentalForm: '',
      fromDate: '',
      toDate: '',
      user: null,
      formData: '',
      clearList: {},
      rentalObjects: '',
      validateList: '',
    }
  },

  methods: {
    pushUrl() {
      this.$store.commit('removeUploadedImages')
      this.$store.commit('setRentalObject', null)
     
      this.$router.push('/my-page/my-houses')
    },

    LoadFormData(formData) {
      this.formData = formData
    },

    amenitiesList(list) {
      this.rentalAmenities = list
    },

    houseForm(form) {
      this.rentalForm = form
    },

    inAndOutDate(from, to) {
      this.fromDate = from
      this.toDate = to
    },

    async combineFormAndList() {
      this.rentalObjects = this.rentalForm
      this.user = this.$store.state.user

      let completeAmanities = { amenities: this.rentalAmenities }
      let availableTo = { availableTo: this.toDate }
      let availableFrom = { availableFrom: this.fromDate }
      let userId = { userId: this.user.id }

      this.rentalObjects = Object.assign(
        {},
        this.rentalObjects,
        completeAmanities,
        availableTo,
        availableFrom,
        userId
      )
      let rentalId = await this.$store.dispatch(
        'postRentalObject',
        this.rentalObjects
      )
      this.$store.commit('setRentalObject', this.rentalObjects)
      let object = {
        formData: this.formData,
        rentalId: rentalId,
      }
      this.$store.dispatch('uploadFiles', object)
      this.$store.commit('setIsConfirmation', true)
    },
  },

  computed: {
    checkRentalForm() {
      if (
        this.rentalForm == '' ||
        this.amenitiesList == undefined ||
        this.fromDate == '' ||
        this.toDate == '' ||
        this.formData == ''
      ) {
        return true
      }
      for (let value of Object.values(this.rentalForm)) {
        if (value == '') {
          return true
        }
      }
      return false
    },
  },
}
</script>

<style scoped>
.border-radius{
  border-radius: 5px;
}

.height{
  height: 100%;
}
.header {
  text-align: center;
}

.add-images {
  grid-area: rhTop;
  
}

.shell {
  max-width: 65rem;
  margin: auto;
  padding: 1px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  background-color: rgba(205, 205, 205, 0.9);
  height: 100%;
}

.sidebar {
  max-width: 65rem;
  padding: 1px;
}

.row1 {
  grid-area: top;
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: 'lhTop rhTop';
  justify-self: center;
  grid-gap: 15px;
  margin: 15px;
  min-height: 315px;
}

.row2 {
  grid-area: mid;
  display: flex;
}

.row3 {
  grid-area: bottom;
  margin: 0 15px 35px 15px;
  display: flex;
  justify-content: center;
}

.objectform {
  display: flex;
  flex-direction: column;
  justify-content: center;
  grid-area: lhTop;
  background-color: rgb(245, 245, 245);
  border: 1px solid gray;
}

.add-images {
  grid-area: rhTop;
  background-color: rgb(245, 245, 245);
  border: 1px solid gray;
}

.calendar {
  scale: 100%;
  align-self: center;
  margin-left: -1px;
  margin-top: 8px;
}

.amenties {
  grid-area: bottom;
  width: 100%;
}

h3 {
  display: flex;
  justify-content: flex-start;
  margin: 15px;
}

label {
  width: 150px;
  cursor: pointer;
  background: rgb(201, 232, 201);
  margin: 0 auto;
  border-radius: 5px;
  border: 1px solid black;
  padding: 0.3rem 0.7rem;
  cursor: pointer;
  text-align: center;
}

label:hover {
  background: #c4eafd;
  cursor: pointer;
}

h1 {
  margin: 15px;
}

#add-rental-disable {
  opacity: 0.3;
}
.chosen-date-box{
  border: 1px solid grey;
}

@media only screen and (max-width: 575px) {
.rental-info{
  padding: 0;
}
  .row1{
    grid:none;
    margin: 15px;
    
  }
  .addhouse {
    display: flex;
    flex-wrap: wrap;
    margin-right: 0;
    justify-content: center;
  }
  .objectform {
    width: 100%;
    justify-items: center;
    
  }
  .row1 {
    grid-area: top;
    display: grid;
    grid-template-rows: auto auto;
    grid-template-areas:
      'lhTop'
      'rhTop';
  }
  .add-images {
    justify-self: left;
  }
}
</style>
