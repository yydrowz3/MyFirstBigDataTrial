import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'babel-polyfill'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import  useview from './util/view'
import http from 'axios'


const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(ElementPlus).use(router).mount('#app')

