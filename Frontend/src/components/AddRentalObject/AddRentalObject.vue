<template>
    <div class="shell">
      <div class="sidebar"><SideBar /></div>
      <div class="header"><h1>Add rental object</h1></div>
      <div class="addhouse">
        <div class="row1">
          <div class="objectform border-radius">
            <div class="calendar">
              <Calendar :addHouse="true" @dates="inAndOutDate"><template v-slot:start>Available From</template><template v-slot:end>Available To</template> </Calendar>
            </div>
            <AddRentalObjectForm
              @fetchObject="houseForm"
            />
          </div>

          <div class="add-images border-radius">
            <AddImageForm @formData="LoadFormData" />
          </div>
        </div>

        <div class="row2">
          <AddRentalAmenities @amenitieslist="amenitiesList" />
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
      <AddRentalObjectConfirmation @close="pushUrl" />
    </div>
</template>

<script>
import AddRentalAmenities from './AddRentalAmenities.vue'
import AddRentalObjectForm from './AddRentalObjectForm.vue'
import Calendar from '../Utils/Calendar.vue'
import AddImageForm from './AddImageForm.vue'
import AddRentalObjectConfirmation from '../Modals/AddRentalObjectConfirmation.vue'
import SideBar from '../Sidebar/Sidebar.vue'

export default {
  components: {
    AddRentalAmenities,
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
      formData: [],
      clearList: {},
      rentalObjects: '',
      validateList: '',
    }
  },

  methods: {
    pushUrl() {
      this.$store.commit('removeUploadedImages')
      this.$store.commit('setRentalObject', null)
     
      this.$router.push('/my-page/my-objects')
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
      let pictures = this.$store.state.uploadedImages
      if (
        this.rentalForm == '' ||
        this.amenitiesList == undefined ||
        this.fromDate == '' ||
        this.toDate == '' ||
        pictures.length < 3
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
.addhouse {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto auto auto;
  grid-template-areas:
  "row1"
  "row2"
  "row3";
  padding: 10px;
}
h3 {
  font-weight: 700;
  font-size: 25px;
}
.border-radius{
  border-radius: 5px;
}
.header {
  text-align: center;
}

.add-images {
  grid-area: rhTop;
  padding: 10px;
}

.shell {
  max-width: 65rem;
  margin: auto;
  padding: 1px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.3), 0 6px 20px 0 rgba(0, 0, 0, 0.2);
  background-color: rgba(205, 205, 205, 0.6);
  height: 100%;
}

.sidebar {
  max-width: 65rem;
  padding: 1px;
}

.row1 {
  grid-area: top;
  display: grid;
  grid-template-columns: 2fr 1.5fr;
  grid-template-areas: 'lhTop rhTop';
  justify-self: center;
  grid-gap: 20px;
  margin-bottom: 10px;
  min-height: 315px;
  width: 100%;
  grid-area: row1;
}

.row2 {
  margin-top:10px;
  grid-area: mid;
  display: flex;
  grid-area: row2;
  
}

.row3 {
  grid-area: bottom;
  margin: 0 15px 35px 15px;
  display: flex;
  justify-content: center;
  grid-area: row3;
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
  align-self: center;
  font-size: 20px;
  margin-top: 10px;
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
  margin-top: 25px
}

label:hover {
  background: linear-gradient(#007973a6, rgb(219, 240, 219));
  color: white;
  cursor: pointer;
}

h1 {
  margin-top: 10px;
  margin-bottom: 0;
}

#add-rental-disable {
  opacity: 0.5;
}
.chosen-date-box{
  border: 1px solid grey;
}
@media only screen and (max-width: 860px) {
  .row1{
    grid-template-columns: auto;
    grid-template-rows: 1fr auto;
    grid-template-areas: 
    "lhTop" 
    "rhTop";
  }
}
@media only screen and (max-width: 380px) {
  .calendar {
    transform: scale(0.95);
  }
  .add-images {
    height: fit-content;
  }
  .addhouse {
    padding: 5px;
  }
}
</style>
