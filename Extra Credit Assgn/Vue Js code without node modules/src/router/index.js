import HomePage from '../components/HomePage.vue';
import CreateSurvey from '../components/CreateSurvey.vue';
import ReadSurvey from '../components/ReadSurvey.vue';
import UpdateSurvey from '../components/UpdateSurvey.vue';
import DeleteSurvey from '../components/DeleteSurvey.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/create', component: CreateSurvey },
  { path: '/read', component: ReadSurvey },
  { path: '/update', component: UpdateSurvey },
  { path: '/delete', component: DeleteSurvey },
];


const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
