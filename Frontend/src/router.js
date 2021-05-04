import { createRouter, createWebHistory } from 'vue-router'

// import views

import Home from './views/Home.vue'
import Detail from './views/HousingDetail.vue'
import Overview from './views/Overview.vue'
import AddRentalObjectForm from './components/addRentalObjectForm.vue'
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
      path: '/add-housing',
      component: AddRentalObjectForm,
    },
    {
      path: '/overview',
      component: Overview,
    },
    {
      path: '/test-page',
      component: TestPage,
    },
  ],
})
