<template>
  <div class=form>
    <div class="delete-button" v-show="$store.state.uploadedImages.length>0">
      <label @click="deleteImages">Delete images</label>
    </div>
    
    <div v-show="$store.state.uploadedImages.length < 4">
      <div class="upload-button">
      <label for="file-input" id="upload-button">Browse files</label>
      <input @change="addPictures" id="file-input" type="file" name="files" multiple>
      
    </div>
    </div>
    
    <div class="rendered-images" v-if="$store.state.uploadedImages.length>0">
      <div v-for="(file, i) of $store.state.uploadedImages" :key="file.name" class="image">
      <img :src="url[i]" alt="">
      </div>
    </div>
  </div>
</template>

<script>

export default {

  data(){
    return{
      files: [],
      uploadedImages: this.$store.state.uploadedImages,
      url:[]
    }
  },

methods:{
  addPictures(){
  this.files = document.querySelector('input[type=file]').files;
  let formData = new FormData();

  for(let file of this.files) {
  formData.append('files', file, file.name);
  this.url.push(URL.createObjectURL(file))
  }
this.$emit('formData', formData)
this.$store.commit('addUploadedImages', this.files) 
},
deleteImages(){
  this.$store.commit('removeUploadedImages')
  this.url = []
}
}
}
</script>

<style scoped>



  .rendered-images{
    display: flex;
    flex-wrap: wrap;
    margin-top: 15px;
    align-items: flex-start;
  }
  
img{
width: 150px;
max-height: 120px;
margin: 15px;
}

.upload-button{
  margin: 15px;
}

.upload-button>input{
  display: none;
}

.delete-button{
  margin-left: 15px;
}

#file-input{
  float: left;
}

label{
  padding:3px;
  border:1px solid black;
  border-radius: 10px;
  font-size: 80%;
  background-color: rgb(233, 233, 233);
  
}
</style>