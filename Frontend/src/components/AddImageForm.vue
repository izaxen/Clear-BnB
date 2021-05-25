<template>
  <div class=form>
    <h3>Add pictures</h3>
    <div class="btns">
      <div class="delete-button" v-show="folderSize > 0">
      <label @click="deleteImages" class="img-btn">Delete images</label>
    </div>
    
    <div v-show="folderSize < 6">
      <div class="upload-button">
      <label for="file-input" id="upload-button" class="img-btn">Browse files</label>
      <input @change="addPictures" id="file-input" type="file" name="files" multiple>
      
    </div>
    </div>
    </div>
    
    <div class="rendered-images" v-if="folderSize > 0">
      <div v-for="(file, i) of imageFolder" :key="file.name" class="image">
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
  computed:{
    folderSize: function(){
      return this.$store.state.uploadedImages.length
    },
    imageFolder: function(){
      return this.$store.state.uploadedImages
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
h3{
  margin-bottom: 10px;
  margin-top: 0;
}
.btns {
  display: flex;
  flex-direction: row;
  align-items: center;
}
.rendered-images{
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  grid-gap: 5px;
  margin-top: 15px;
  align-items: flex-start;
  justify-items: center;
  max-height: 335px;
  overflow: hidden scroll;
}
  
img{
  width: 100%;
  height: 100%;
  object-fit: contain;
  justify-self: center;
}

.upload-button{
  margin-left: 10px;
}

.upload-button>input{
  display: none;
}

#file-input{
  float: left;
}

 label{
  width: 150px;
  cursor: pointer;
  background: rgb(201, 232, 201);
  border-radius: 5px;
  border: 1px solid black;
  padding: 5px;
  text-align: center;
  font-weight: 700;
}
 
label:hover{
  background: #c4eafd;
  cursor: pointer;
}

.text-gray-900{
  font-size: 97%;
}

@media screen and (max-width: 860px){
  .rendered-images {
    height: fit-content;
    max-height: 355px;
    grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  }
}
@media screen and (max-width: 525px){
  .rendered-images {
    height: fit-content;
    max-height: 435px;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  }
}
@media screen and (max-width: 385px){
.rendered-images {
    height: fit-content;
    max-height: 435px;
    grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  }
}
</style>