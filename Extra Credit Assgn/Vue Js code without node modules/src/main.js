import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'
import HomePage from './components/HomePage.vue'
import CreateSurvey from './components/CreateSurvey.vue'
import ReadSurvey from './components/ReadSurvey.vue'
import UpdateSurvey from './components/UpdateSurvey.vue'
import DeleteSurvey from './components/DeleteSurvey.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: HomePage },
        { path: '/create', component: CreateSurvey },
        { path: '/read', component: ReadSurvey },
        { path: '/update', component: UpdateSurvey },
        { path: '/delete', component: DeleteSurvey }
    ]
})

const app = createApp(App)
app.use(router)
app.mount('#app')