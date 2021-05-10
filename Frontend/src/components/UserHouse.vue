<template>
<div class="view">
  <div class="receipt-card">
    <div class="header">
      <div class="left-header"><h1></h1></div>
      <div class="right-header">
        <p>Date: 2022-01-01</p>
        <p>People: 4</p>
        <p>Price: 2400$</p>
        </div>
    </div>
    <div class="col-1">
      <div class="img">
        <img src="https://thumbs.dreamstime.com/b/nice-brick-house-red-door-11568682.jpg" alt="">
      </div>
    </div>
    <div class="col-2">
      <h2>Hela Lägenheten</h2>
      <p>lorem lorem lorem lorem lorem</p>

      <h4>Booking id: {{house.id}}</h4>
    </div>
    <div class="col-3">
      <button class="btn-link" @click="goToHouse">Go to house</button>
      <button class="btn-remove">Remove</button>
    </div>
    
  </div>
</div>
  
</template>

<script>
export default {
  props:["house"],

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.receipt.id)
    }
  }

}
</script>

<style scoped>
  .view {
    width: 100%;
  }

  button{
    position: absolute;
    justify-self: center;
    height: 40px;
    width: 200px;
    border: none;
    border-radius: 10px;
    background: rgba(0, 0, 0, 0.287);
    font-weight: 700;
    font-size: 20px;
  }

  .btn-remove {
    bottom: 5px;
  }

  .btn-link {
    bottom: 55px;

  }

  button:hover {
    background: rgba(124, 124, 124, 0.287);
    cursor: pointer;
  }

  .right-header{
    align-self: center;
    font-size: 20px;
    font-weight: 700;
    grid-area: head2;
  
  }

  .right-header p {
    margin: 0;
  }

  .left-header{
   grid-area: head1;
  }
  .view {
    display: grid;
    width: 100%;
  }

  .receipt-card {
    display: grid;
    grid-template-columns: 25% 55% 20%;
    grid-template-rows: 20% 80%;
    grid-template-areas:
    "header header header"
    "box1 box2 box3";
    border: 2px solid black;
    border-radius: 10px;
    height: 400px;
    width: 80%;
    justify-self: center;
    margin: 30px 0;
    color: black;
  }

  .header {
    display: grid;
    grid-template-columns: 25% 55% 20%;
    grid-template-areas:
    "head1 null head2";
    grid-area: header;
    padding-left: 20px;
  }

  .col-1 {
    display: grid;
    align-content: center;
    justify-items: center;
    grid-area: box1;
    width: 100%;
  }

  .col-2 {
    grid-area: box2;
    padding: 30px;
  }

  .col-3 {
    position: relative;
    display: grid;
    justify-items: center;
    grid-template-columns: 1fr;
    grid-area: box3;
  }

  img {
    width: 80%;
    min-height: 200px;
    margin-left: 25px;
  }
</style>