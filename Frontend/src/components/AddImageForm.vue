<template>
  <div class=form>
    <div v-show="$store.state.uploadedImages.length>0">
      <button @click="deleteImages">Delete images</button>
    </div>
    
    <div v-show="$store.state.uploadedImages.length < 4">
      <input @change="addPictures" type="file" name="files" multiple>
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
}
}
}
</script>

<style scoped>

  .rendered-images{
    display: flex;
    flex-wrap: wrap;
    
  }
  .image{
    align-items: flex-start;
  }

img{
width: 150px;
max-height: 150px;
margin-bottom: 15px;
margin-right: 15px;
}
</style>