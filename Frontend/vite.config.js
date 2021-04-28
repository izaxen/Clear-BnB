import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      // this is required to proxy fetches to backend
      '/rest': 'http://localhost:4000', // same port as backend
    },
  },
})
