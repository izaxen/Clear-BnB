import { createApp } from 'vue'
import App from './App.vue'
import store from './store.js'
import router from './router.js'
import './style.css'

// const app = createApp(App)
// app.use(store)
// app.mount('#app')

// with method chaining
createApp(App) // == app
  .use(store)
  .use(router)
  .mount('#app')
