<template>
<div>
  
  <div v-for="image in imageList" >
<img :src="image" alt="">

  </div>
  
</div>
</template>

<script>
export default {
async created(){
  await this.$store.dispatch('getFileUrl', 'P-V-jmKvrHnun7n87ATjs')
  this.imageList = await this.$store.state.imageList

  console.log('file listr i testpage', this.imageList)
},
data(){
  return{
    imageList: [],
  }
}
}
</script>

<style>

</style>