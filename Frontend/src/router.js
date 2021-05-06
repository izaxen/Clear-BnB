import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Detail from './views/HousingDetail.vue'
import Overview from './views/Overview.vue'
import AddHouse from './views/AddHouse.vue'
import TestPage from './views/TestPage.vue'
import MyPage from './views/MyPage.vue'

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
      path: '/my-page/add-house',
      component: AddHouse,
    },
    {
      path: '/overview',
      component: Overview,
    },
    {
      path: '/test-page',
      component: TestPage,
    },
    {
      path: '/my-page',
      component: MyPage,
    },
  ],
})
