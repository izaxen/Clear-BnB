import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Detail from './views/HousingDetail.vue'
import Overview from './views/Overview.vue'
import AddRentalObject from './components/AddRentalObject/AddRentalObject.vue'
import MyPage from './views/MyPage.vue'
import MyBookings from './components/User/MyBookings.vue'
import MyObjects from './components/User/MyObjects.vue'
import EditUser from './components/user/EditUser.vue'

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
      path: '/accommodations',
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
    },
    {
      path: '/my-page/edit-user',
      component: EditUser,
    }
  ],
})
