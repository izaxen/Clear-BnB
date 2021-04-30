<template>
  <form @submit.prevent="addRentalObject">
    <div class="rental-info">
    <div class="row">
      <div class="column">
        <p>Available from</p>
        <input v-model="availableFrom" type="date"/>
      </div>
      <div class="column">
        <p>Available to</p>
        <input v-model="availableTo" type="date"/>
        </div>
      </div>
      <div class="input-boxes">
        <textarea class="description" v-model="description" rows="1" cols="17" type="text" placeholder="Description"/>
        <textarea class="freetext" v-model="freeText" rows="10" cols="17" placeholder="Freetext"/>
        <textarea class="city small-box" v-model="city" rows="1" cols="17" placeholder="City"/>
        <input class="num-beds small-box" v-model="availableBeds" type="number" placeholder="Number of beds"/>
        <input class="price small-box" v-model="price" type="number" placeholder="Price per night"/>
      </div>
    <button>Add house</button>
    </div>
    </form>
</template>

<script>
export default {
  data(){
    return{
      availableFrom : "",
      availableTo: "",
      freeText : "",
      description : "",
      city : "",
      availableBeds: "",
      price : "",
    }
  },
  methods: {
    addRentalObject(){
      let rentalObject ={
      availableFrom : this.availableFrom,
      availableTo: this.availableTo,
      freeText : this.freeText,
      description : this.description,
      city : this.city,
      availableBeds: this.availableBeds,
      price : this.price,
      }
      this.$store.dispatch('postRentalObject', rentalObject)
      this.availableFrom = ""
      this.availableTo = ""
      this.freeText = ""
      this.description = ""
      this.city = ""
      this.availableBeds = ""
      this.price = ""
    }
  }

}
</script>

<style scoped>
.rental-info{
  padding: 10px;
  width: 290px;
  border: 1px solid rgb(34, 32, 32);
  font-family: 'Times New Roman', Times, serif;
}
p{
  font-size: 12px;
}
.column{
  width: 50%;
  display: flex;
  flex-direction: column;
  align-content: space-around;
  border: 1px solid rgb(34, 32, 32);
  padding: 3px;
}
.row{
  display: flex;
  flex-direction: row;
  width: 100%;
  margin-bottom: 10px;
}
.row p{
  color: rgb(0, 0, 0);
  margin: 0;
}
input[type=date]{
  font-size: 13px;
}
.input-boxes{
  display: inline-block;
}
input[type=number]{
  margin-top: 10px;
  padding: 0;
}
form button {
  margin-top: 10px;
  width: 70px;
  height: 25px;
  color: rgb(7, 7, 7);
  font-size: 12px;
}
textarea{
  font-size: 13px;
  width: 100%;
  margin-top: 10px;
}
.description{
  min-height: 70px;
}
.freetext{
min-height: 150px;
}
.small-box{
  font-size: 13px;
  min-height: 30px;
  width: 60%;
}
</style>