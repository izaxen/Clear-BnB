<template>
<div class="view">
  <div class="receipt-card">
    <div class="col-1">
      <div class="img">
        <img src="https://thumbs.dreamstime.com/b/nice-brick-house-red-door-11568682.jpg" alt="">
      </div>
    </div>
    <div class="col-2">
      <h2>{{house.city}}</h2>
      <p>{{house.description}}</p>
      <p>Beds: {{house.availableBeds}}</p>
      <p>Price/night: {{house.price}}$</p>

      <h4>House id: {{house.id}}</h4>
    </div>
    <div class="col-3">
      <div class="text">
      </div>
      <button class="btn-link" @click="goToHouse">Go to house</button>
      <button class="btn-remove">Edit</button>
    </div>
    
  </div>
</div>
  
</template>

<script>
export default {
  props:["house"],

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.house.id)
    }
  }

}
</script>

<style scoped>
  .view {
    width: 100%;
  }

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

  .receipt-card {
    display: grid;
    grid-template-columns: 25% 55% 20%;
    grid-template-areas:
    "box1 box2 box3";
    border: 2px solid black;
    border-radius: 10px;
    height: 240px;
    width: 80%;
    justify-self: center;
    margin: 30px 0;
    color: black;
    box-shadow: 10px 10px 15px 10px rgb(75, 75, 75);
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
    justify-items: center;
    grid-area: box1;
    width: 100%;
  }

  .col-2 {
    grid-area: box2;
    padding: 5px;
  }

  .col-3 {
    position: relative;
    display: flex;
    flex-direction: column;
    grid-area: box3;
  }

  .col-3 p {
    margin: 5px;
  }

  img {
    width: 80%;
    min-height: 200px;
    margin-left: 15px;
    margin-top: 15px;
  }
</style>