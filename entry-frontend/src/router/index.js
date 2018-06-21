import Vue from 'vue';
import Router from 'vue-router';
import IntroduceNPlan from '../components/GradeInput/IntroduceNPlan';
import Authorization from './../components/Authorization/Authorization';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
    },
    {
      path: '/introduce',
      name: 'introduce',
      component: IntroduceNPlan,
    },
    {
      path: '/auth',
      component: Authorization,
    },
  ],
});
