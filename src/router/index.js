import Vue from 'vue';
import Router from 'vue-router';
import IntroduceNPlan from '../components/GradeInput/IntroduceNPlan';

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
  ],
});
