import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'

// create routes with views
export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home,
    },
  ]
})
