<template>
<div class="center">
<div class="modal-frame" v-if="$store.state.user" v-show="$store.state.isConfirmation">
  <div class="header">
    <slot name="header">
      <p>Oops, something went wrong!</p>
    </slot>
  </div>

  <div class="column-holder">

  <div class="left-column">
    <h4 v-if="startDateString" class="border-bottom"><slot name = "start-date-text"></slot></h4>
    <h4 v-if="endDateString" class="border-bottom"><slot name = "end-date-text"></slot></h4>
    <h4 v-if="rentalObject.address" class="border-bottom"><slot name= "address" >Adress:</slot></h4>
    <h4 class="border-bottom"><slot v-if="rentalObject.city">City:</slot></h4>
    <h4 class="border-bottom"><slot name="beds-text"></slot></h4>
    <h4 class="border-bottom"><slot name="beds-text-two"></slot></h4>
  </div>

  <div class="right-column">
    <p v-if="startDateString" class="border-bottom">{{startDateString}}</p>
    <p v-if="endDateString" class="border-bottom">{{endDateString}}</p>
    <p v-if="rentalObject.address" class="border-bottom">{{rentalObject.address}}</p>
    <p class="border-bottom">{{rentalObject.city}}</p>
    <p class="border-bottom"><slot name="beds-count"></slot></p>
    <p class="border-bottom"><slot name="beds-count-two"></slot></p>
  </div>

  </div>

  <div class="button-holder">
    <button @click="closeModal">Ok</button>
  </div>

    <div class="total">
    <h5>Total price:</h5> 
    <p><slot name = "price"></slot></p>
  </div>
</div>
</div>
  
</template>

<script>
export default {
  props:["startDate", "endDate"],

  data(){
    return{
      rentalId: null,
      rentalObject: {},
      endDateString: '',
      startDateString: '',
    }
  },

  watch:{
    '$route'(){
      this.$store.state.isConfirmation = false
    },
    '$store.state.rentalObjects'(){
      this.setRentalObject()
    },
    startDate(){
    this.startDateString = this.getDateAsString(this.startDate)
    },
    endDate(){
    this.endDateString = this.getDateAsString(this.endDate)
    },

  },

  methods: {
    closeModal(){
      this.$store.commit('setIsConfirmation', false)
    },
    setRentalObject(id){
      let rentalId
      if(!id){
      rentalId = this.$route.params.id}
      else{
        rentalId = id
      }

      this.rentalObject = this.$store.state.rentalObjects.find((r) => r.id == rentalId)
    },
    getDateAsString(date){
    let year = date.getFullYear();
    let month = date.getMonth() + 1
    let day = date.getDate()
    if(day < 10){
      day = '0' + day
    }
    if(month < 10){
      month = '0' + month 
    }

    return 'yyyy-mm-dd', year + "-" + month + "-" + day
    }
   
  },
  created(){
    this.$store.dispatch('fetchRentalObjects')
  },
}

</script>

<style scoped>
h1, h2, h3, h4, h5, p{
  display: inline;
  margin: 3px;
}

.modal-frame{
  display: grid;
  color: black;
  border: 1px solid #011f4b;
  box-shadow: rgb(49, 48, 48) 0px 3px 3px;
  justify-self: center;
  justify-content: center;
  align-items: center;
  position: absolute;
  max-width:300px;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #b3cde0;
  padding: 10px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
  }

.center{
  display: flex;
  text-align: center;
  width: 100%;
}

.column-holder{
  display: flex;
  justify-content: space-evenly;
}

.left-column, .right-column{
  display: flex;
  flex-direction: column;
  padding: 10px;
  width: 50%;
}

.left-column{
  text-align: start;
  background-color: #eaeff3;
}

.right-column{
  text-align: end;
  background-color: #deebf3;
}

.border-bottom{
  border-bottom: 1px solid #011f4b;
}

.total{
  margin-top: 5px;
  margin-bottom: 5px;
  font-size: 17px;
}

.button-holder{
  display: flex;
  justify-content: center;
  margin-top: 35px;
}

button{
  cursor: pointer;
  background-color: blanchedalmond;
}

button:hover{
  background-color: rgb(223, 189, 139);
}

</style>