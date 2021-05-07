<template>
    <div class=form>
    <input @change="addPictures" type="file" name="files" multiple>
    
  <div class="rendered-images" v-if="$store.state.uploadedImages.length>0">
    
  <div v-for="(file, i) of $store.state.uploadedImages" :key="file.name" class="image">
  <div class="images">
  <img :src="url[i]" alt="">
  </div>
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
  console.log('files', this.files)
  let formData = new FormData();

  for(let file of this.files) {
  formData.append('files', file, file.name);
  this.url.push(URL.createObjectURL(file))
  }
console.log('Formdata', formData.getAll('files'))
this.$store.dispatch('uploadFiles', formData)
this.$store.commit('addUploadedImages', this.files) 
}
}
}
</script>

<style scoped>

.images{
  height:200px;
  width: 200px;
}

</style>