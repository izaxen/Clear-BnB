import { createRouter, createWebHistory } from 'vue-router'

// import views
import App from './App.vue'

// create routes with views
export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: App,
    },
  ],
})
