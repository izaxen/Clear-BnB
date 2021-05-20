<template>
<div class="modal"  v-show="$store.state.isConfirmation">
  <div class="modal-backdrop">
  <div class="modal-frame" v-if="$store.state.user && $store.state.rentalObject" >
  
  <div class="modal-header">
    <slot name="header">
      <p>Oops, something went wrong!</p>
    </slot>
  </div>
<div class="mid-modal">
  <div class="image">
    <img src="../assets/clearbnb-grey-house.png" alt="">
  </div>
  <div class="column-holder">

  <div class="left-column">
    <h4 v-if="startDateString" class="border-bottom"><slot name = "start-date-text"></slot></h4>
    <h4 v-if="endDateString" class="border-bottom"><slot name = "end-date-text"></slot></h4>
    <h4 v-if="$store.state.rentalObject && $store.state.rentalObject.address" class="border-bottom"><slot name= "address" >Adress:</slot></h4>
    <h4 v-if="$store.state.rentalObject.city && $store.state.rentalObject" class="border-bottom"><slot name="city">City:</slot></h4>
    <h4 class="border-bottom"><slot name="beds-text"></slot></h4>
    <h4 class="border-bottom"><slot name="beds-text-two"></slot></h4>
  </div>

  <div class="right-column">
    <p v-if="startDateString" class="border-bottom">{{startDateString}}</p>
    <p v-if="endDateString" class="border-bottom">{{endDateString}}</p>
    <p v-if="$store.state.rentalObject.address" class="border-bottom">{{$store.state.rentalObject.address}}</p>
    <p class="border-bottom">{{$store.state.rentalObject.city}}</p>
    <p class="border-bottom"><slot name="beds-count"></slot></p>
    <p class="border-bottom"><slot name="beds-count-two"></slot></p>
  </div></div>

  </div>
    <div class= bot-modal>

      <div class="total">
      <h5><slot name="price-text">Total price:</slot></h5> 
     <p><slot name = "price"></slot> :-</p>
    </div>

     <div class="button-holder">
    <button @click="closeModal">OK</button>
  </div>

  
  </div>
  </div>
</div></div>
  
</template>

<script>
export default {
  props:["startDate", "endDate"],
  emits: ['close'],

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
      this.$emit('close')
    },
    setRentalObject(){
      this.rentalObject = this.$store.state.rentalObject     
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
  margin: 8px;
  
}
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.45);
  display: grid;
  justify-content: center;
  align-items: center;
  z-index: 10;
}

img{
  margin: 10px;
  width: 70px;
  
 }
.image{
  display: flex;
  justify-content: flex-end;
  align-items: flex-start;
  

}

.modal-frame{
  display: grid;
  grid-template-rows: 10% 70% 20%;
  grid-template-areas: 
  "top"
  "mid"
  "bot";
  overflow-x: auto;
  color: black;
  border: 1px solid #011f4b;
  box-shadow: rgb(49, 48, 48) 0px 3px 3px;
  width:450px;
  background-color: rgb(205,205,205);
  border-radius: 5px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  }

.modal-header{
  display: flex;
  grid-area: top;
  justify-content: center;
  margin: 15px;
}

.mid-modal{
  grid-area: mid;
  display: grid;
  grid-template-columns:70% 30%; 
  grid-template-areas: "lh rh";
  background-color: rgb(245,245,245);
  margin: 0 15px;
  border-radius: 5px;
}
.column-holder{
  grid-area: lh;
  display: flex;
}
.left-column, .right-column{
  display: flex;
  flex-direction: column;
  width: 50%;
  text-align: start;
}

.bot-modal{
  grid-area: bot;
  display: flex;
  justify-content: space-between;
  align-content: center;
  margin: 15px;
}
.total{
  display: flex;
  align-content: center;
  font-size: 17px;
  background-color: rgb(245,245,245);
  border-radius: 5px;
}

.button-holder{
  align-self: center;  
}

button{
  width: 60px;
  cursor: pointer;
  background: rgb(201, 232, 201);
  border: none;
  margin: 0 auto;
  border-radius: 5px;
  border: 1px solid black;
  padding: 0.3rem 0.7rem;
  cursor: pointer;
}

button:hover{
  background-color: rgb(182, 235, 182);
}
h5{
  margin: 0 10px;
  align-self: center;
}

@media only screen and (max-width: 468px){
  .modal-frame{
    width: 350px;
  }

  h1, h2, h3, h4, h5, p{
  display: inline;
  margin: 10px;
}

.image{
  display: none;
}

.mid-modal{
  grid:none;
  display: flex;
  justify-content: center;
      
}
.column-holder{
  display: flex;
  width: 100%;
  }

}

</style>