<template>
  
</template>

<script>
export default {
async post(store, routeString, object) { 
let res = await fetch('/rest/' + routeString, { 
method: 'POST', body: JSON.stringify(object), 
}) 
let objectFromServer = await res.json() 
console.log('post, objectFromServer:', objectFromServer) 
if (route == "users") { 
store.commit('addUser', objectFromServer) 
} 
else if (routeString == "booking-receipts"){ 
store.commit('addReceipt', objectFromServer) 
} 
else if (routeString == "rental-objects") { 
store.commit('addRentalObject', objectFromServer) 
} 
},

}
</script>

<style>

</style>