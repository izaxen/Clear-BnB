import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Login from './views/Login.vue'

// create routes with views
export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/my-page',
      component: Login,
    }
  ]
})
