<template>
  <div v-if="value">
    <img class="icon" :src="url" />
    <p>Got {{ text }}</p>
  </div>
</template>

<script>
export default {
  props: ['value', 'name'],

  data() {
    let data = {
      url: '',
      text: '',
    }
    data = Object.assign({}, data, this.value)
    data = Object.assign({}, data, this.name)

    return data
  },

  created() {
    if (this.name == 'wifi') {
      this.url =
        'https://ak.picdn.net/shutterstock/videos/1007702740/thumb/1.jpg'
      this.text = 'wifi'
    } else if (this.name == 'smartTv') {
      this.url =
        'https://i.pinimg.com/originals/9e/d8/61/9ed86194c90b60ad5ce0e14fdb1b97d5.png'
      this.text = 'smart tv'
    } else if (this.name == 'partyAllowed') {
      this.url =
        'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Party_icon.svg/909px-Party_icon.svg.png'
      this.text = 'pets Allowed'
    } else if (this.name == 'petsAllowed') {
      this.url = 'https://img.icons8.com/ios/452/pets--v1.png'
      this.text = 'smoking Allowed'
    } else if (this.name == 'smokingAllowed') {
      this.url = 'https://img.icons8.com/ios/452/smoking.png'
      this.text = 'fireplace'
    } else if (this.name == 'fireplace') {
      this.url =
        'https://www.pngfind.com/pngs/m/71-712105_png-file-svg-fireplace-icon-png-transparent-png.png'
      this.text = 'fireplace'
    } else if (this.name == 'parking') {
      this.url =
        'https://www.iconpacks.net/icons/2/free-parking-sign-icon-1641-thumb.png'
      this.text = 'parking'
    } else if (this.name == 'freeParking') {
      this.url = 'https://image.flaticon.com/icons/png/512/2168/2168476.png'
      this.text = 'free parking'
    } else if (this.name == 'selfCheckIn') {
      this.url =
        'https://cdn4.iconfinder.com/data/icons/eldorado-mobile/40/location_current-512.png'
      this.text = 'self check-in'
    } else if (this.name == 'airCondition') {
      this.url = 'https://image.flaticon.com/icons/png/512/114/114735.png'
      this.text = 'aircondition'
    } else if (this.name == 'hairDryer') {
      this.url = 'https://img.icons8.com/ios/452/hair-dryer.png'
      this.text = 'hairdryer'
    } else if (this.name == 'dishwasher') {
      this.url =
        'https://image.shutterstock.com/image-vector/working-dishwasher-icon-outline-vector-260nw-1776039650.jpg'
      this.text = 'dishwasher'
    } else if (this.name == 'pool') {
      this.url =
        'https://cdn1.iconfinder.com/data/icons/real-estate-94/200/810-512.png'
      this.text = 'pool'
    } else if (this.name == 'bathtub') {
      this.url = 'https://image.flaticon.com/icons/png/512/184/184128.png'
      this.text = 'bathtub'
    } else if (this.name == 'iron') {
      this.url = 'https://image.flaticon.com/icons/png/512/16/16573.png'
      this.text = 'iron'
    } else if (this.name == 'elevator') {
      this.url =
        'https://image.shutterstock.com/image-vector/elevator-line-icon-vector-illustration-260nw-1723335778.jpg'
      this.text = 'elevator'
    } else if (this.name == 'kitchen') {
      this.url =
        'https://cdn.iconscout.com/icon/premium/png-256-thumb/kitchen-1447727-1224141.png'
      this.text = 'kitchen'
    } else if (this.name == 'heating') {
      this.url = 'https://image.flaticon.com/icons/png/512/34/34915.png'
      this.text = 'heating'
    } else if (this.name == 'bedroomEssentials') {
      this.url = 'https://static.thenounproject.com/png/1122147-200.png'
      this.text = 'bedroom essentials'
    } else if (this.name == 'coffeeMaker') {
      this.url =
        'https://i.pinimg.com/736x/de/45/01/de4501e1226923bc840823372c9d1e69.jpg'
      this.text = 'coffe maker'
    } else if (this.name == 'bathroomEssentials') {
      this.url =
        'https://cdn.iconscout.com/icon/premium/png-256-thumb/bathroom-1677078-1427673.png'
      this.text = 'bathroom essentials'
    }
  },
}
</script>

<style scooped>
img {
  height: 34px;
  width: 34px;
}
</style>
