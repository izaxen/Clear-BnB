import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Detail from './views/RentalObjectDetails.vue'
import Overview from './views/Overview.vue'
import AddRentalObject from './views/AddRentalObject.vue'
import MyPage from './views/MyPage.vue'
import MyBookings from './views/MyBookings.vue'
import MyObjects from './views/MyObjects.vue'


// create routes with views
export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home,
      name: Home,
    },
    {
      path: '/details/:id',
      component: Detail,
    },
        
    {
      path: '/my-page/add-object',
      component: AddRentalObject,
    },
    {
      path: '/overview',
      component: Overview,
    },
    {
      path: '/my-page',
      component: MyPage,
    },
    {
      path: '/my-page/my-bookings',
      component: MyBookings,
    },
    {
      path: '/my-page/my-objects',
      component: MyObjects,
    }
  ]
})
