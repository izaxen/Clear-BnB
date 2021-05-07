<template>
<form @change="onFileChange" enctype="multipart/form-data">
    <input type="file" accept="image/x-png,image/jpeg,image/jpg" name="files">
    <button @click="uploadFiles">Submit</button>
    <div v-if="url.length > 0">
    <div v-for="(img, i) in files" :key="img.id" class="image">
  <img :src="url[i]" alt="">
    </div>
    </div>

</form>
</template>



<script>


export default {
  components:{
  
  },
  data(){
    return{
      url: [],
      files: [],
      formData: new FormData()
    }
  },
    //display file before upload
  methods:{
    onFileChange(e) {
      let file = e.target.files[0];
      let fileUtanArr = e.target.files
      this.url.push(URL.createObjectURL(file))

      console.log('Bild/fil' ,fileUtanArr)
      console.log('file inne i changen', file)
    
      this.files.push(file)
      this.formData.append('files',file,file.name)
      console.log('Formdata', this.formData.getAll('files'))


    },
    
    async uploadFiles() {
       this.$store.dispatch('uploadFiles', this.formData)
       }
  }
}
  


</script>

<style scoped>
.image{
  height: 200px;
  width:200px
}

</style>