<template>
  <div class=form>
    <div class="delete-button" v-show="folderSize > 0">
      <label @click="deleteImages">Delete images</label>
    </div>
    
    <div v-show="folderSize < 6">
      <div class="upload-button">
      <label for="file-input" id="upload-button">Browse files</label>
      <input @change="addPictures" id="file-input" type="file" name="files" multiple>
      
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
  .rendered-images{
    display: flex;
    flex-wrap: wrap;
    margin-top: 15px;
    align-items: flex-start;
  }
  
img{
width: 190px;
max-height: 115px;
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
  padding: 8px;
  font-weight: 700;
  font-size: 15px;
  border-radius: 10px;
  font-size: 90%;
  background: #6497b1;
  color: black;
}
 
label:hover{
  background: #c4eafd;
  cursor: pointer;
}

.text-gray-900{
  font-size: 97%;
}
</style>