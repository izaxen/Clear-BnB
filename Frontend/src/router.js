import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Detail from './views/HousingDetail.vue'
import AddHouse from './views/AddHouse.vue'
import TestPage from './views/TestPage.vue'
import Overview from './views/Overview.vue'

// create routes with views
export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/details/:id',
      component: Detail,
    },
    {
      path: '/my-page/add-house',
      component: AddHouse,
    },
    {
      path: '/test-page',
      component: TestPage,
    },
    {
      path: '/overview',
      component: Overview,
    }
  ],
})
