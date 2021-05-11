<template>
<div class="view">
  <div class="receipt-card">
    <div class="col-1">
      <div class="img">
        <img src="https://thumbs.dreamstime.com/b/nice-brick-house-red-door-11568682.jpg" alt="">
      </div>
    </div>
    <div class="col-2">
      <h2>{{receipt.city}}</h2>
      <p>{{receipt.description}}</p>

      <h4>Booking id: {{receipt.id}}</h4>
    </div>
    <div class="col-3">
      <div class="text">
        <p>Available from: {{receipt.availableFrom}}</p>
        <p>People: 4</p>
        <p>Price: 2400$</p> 
      </div>
      <div class="btns">
       <button class="btn-link" @click="goToHouse">Details</button>
       <button class="btn-remove" @click="deleteReceipt">Remove</button>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  props:["receipt"],

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.receipt.rentalObjectId)
    },
    deleteReceipt(){
      this.$store.dispatch('deleteReceipt', this.receipt);
      this.$emit('deleteBooking', this.receipt)
    }
  }

}
</script>

<style scoped>

  .text {
    margin-top: 15px;
    margin-bottom: 30px;
  }

  button{
    height: 40px;
    width: 80%;
    border: none;
    border-radius: 10px;
    background: #6497b1;
    font-weight: 700;
    font-size: 15px;
    margin: 5px;
  }

  .btn-remove {
    bottom: 5px;
  }

  .btn-link {
    bottom: 55px;

  }

  button:hover {
    background: #c4eafd;
    cursor: pointer;
  }
  .view {
    display: grid;
    width: 100%;
  }

  .img {
    padding: 5px;
    justify-self: center;
    align-self: center;
  }

  .receipt-card {
    display: grid;
    grid-template-columns: 35% 45% 20%;
    grid-template-areas:
    "box1 box2 box3";
    border-radius: 10px;
    height: fit-content;
    width: 70%;
    justify-self: center;
    align-self: center;
    margin: 30px 0;
    color: black;
    box-shadow: 10px 10px 15px 5px rgb(75, 75, 75);
    padding: 5px;
  }

  .col-1 {
    display: grid;
    justify-items: center;
    grid-area: box1;
    width: 100%;
  }

  .col-2 {
    grid-area: box2;
    padding: 5px;
  }

  .col-3 {
    display: flex;
    flex-direction: column;
    grid-area: box3;
  }

  .col-3 p {
    margin: 5px;
  }

  .img {
    width: 100%;
    display: grid;
  }
  .btns {
      display: grid;
      height: 100%;
  }

  img {
    width: 80%;
    min-height: 200px;
    justify-self: center;
  }

  @media screen and (max-width: 750px) {
    .receipt-card {
      display: grid;
      grid-template-columns: 1fr 0.6fr;
      grid-template-rows: 1fr 0.5fr;
      grid-template-areas:
      "box1 box2"
      "box3 box3";
      max-width: 40rem;
      font-size: 15px;
      height: fit-content;
      padding: 5px;
    }

    .btns {
      display: flex;
    }

    .text {
      margin-bottom: 5px;
    }
}

  @media screen and (max-width: 550px) {
    .receipt-card {
      display: grid;
      grid-template-columns: 1fr;
      grid-template-rows: 1fr 0.5fr 0.5fr;
      grid-template-areas:
      "box1"
      "box2"
      "box3";
      max-width: 40rem;
      min-width: 20rem;
      font-size: 15px;
      height: fit-content;
      padding: 5px;
    }

    .btns {
      display: flex;
    }

    .text {
      margin-bottom: 5px;
    }
}
</style>