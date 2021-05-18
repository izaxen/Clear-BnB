<template>
<div class="view">
  <div class="receipt-card">
    <div class="col-1">
      <div class="img" v-if="getImg">
        <img :src="imageList[0]" alt="">
      </div>
    </div>
    <div class="col-2">
      <h2>{{house.city}}</h2>
      <p>Beds: {{house.availableBeds}}</p>
      <p>Price/night: {{house.price}}$</p>
      <p>From: {{new Date(house.availableFrom).toLocaleDateString("se-SE").split("/").toString()}}</p>
      <p>To: {{new Date(house.availableTo).toLocaleDateString("se-SE").split("/").toString()}}</p>
    </div>
    <div class="col-3">
      <div class="btns">
        <button class="btn-link" @click="goToHouse">Details</button>
        <button class="btn-remove">Edit</button>
      </div>
    </div>
    
  </div>
</div>
  
</template>

<script>
export default {
  props:["house"],
  data(){
    return {
      imageList: []
    }
  },

  methods: {
    goToHouse(){
      this.$router.push('/details/' + this.house.id)
    }
  },

  computed: {
    async getImg(){
      await this.$store.dispatch('getFileUrl', this.house.id)
      this.imageList = this.$store.state.imageList
    }
  },

}
</script>

<style scoped>

  button{
    height: 40px;
    width: 100px;
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
    width: 80%;
    justify-self: center;
    align-self: center;
    margin: 30px 0;
    color: black;
    box-shadow: 10px 10px 15px 5px rgb(75, 75, 75);
    padding: 5px;
    transition: 0.4s;
  }

  .col-1 {
    display: grid;
    justify-items: center;
    grid-area: box1;
    width: 100%;
  }

  .col-2 {
    grid-area: box2;
    max-height: 300px;
    overflow: hidden;
    overflow: scroll;
    overflow: auto;
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

  .img {
    width: 100%;
    display: grid;
  }
  .btns {
      display: grid;
      position: absolute;
      right: 0;
      bottom: 0;
  }

  img {
    width: 80%;
    min-height: 200px;
    justify-self: center;
  }
  @media screen and (min-width: 750px) {
    .receipt-card {
      max-width: 40rem;
      font-size: 15px;
      height: fit-content;
      padding: 5px;
    }
}

  @media screen and (max-width: 750px) {
    .receipt-card {
      display: grid;
      grid-template-columns: 1fr 0.6fr;
      grid-template-rows: 1fr 0.2fr;
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
      position: relative;
    }
}

  @media screen and (max-width: 550px) {
    .receipt-card {
      display: grid;
      grid-template-columns: 1fr;
      grid-template-rows: 0.7fr 0.3fr 0.2fr;
      grid-template-areas:
      "box1"
      "box2"
      "box3";
      max-width: 40rem;
      min-width: 23rem;
      font-size: 15px;
      height: fit-content;
      padding: 5px;
    }

    .col-2{
      font-size: 15px;
    }

    .col-2 p {
      margin: 4px;
    }

    .btns {
      display: flex;
    }

    .text {
      margin-bottom: 5px;
    }
}
</style>