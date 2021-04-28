<template>
  <nav>
    <router-link to ="/">Home</router-link>
    |
    <router-link to="/my-page">My Page</router-link>
   
  </nav>
</template>

<script>
export default {

}
</script>

<style scoped>
nav {

  padding: 10px;
  background-image: linear-gradient(
    rgb(208, 255, 164),
    rgba(77, 224, 9, 0.787)
  );

box-shadow: 0 0 5px 5px;
}
a{
  text-decoration: none;
  color: rgb(0, 0, 0);
  
}

a:hover{
  text-decoration: underline;
}


</style>