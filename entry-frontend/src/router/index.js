import Vue from 'vue';
import Router from 'vue-router';
import IntroduceNPlan from '../components/IntroNPlan/IntroduceNPlan';
import Classification from '../components/Classification/Classification';
import PersonalInformation from '../components/PersonalInformation/PersonalInformation';
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
      path: '/classify',
      name: 'classification',
      component: Classification,
    },
    {
      path: '/auth',
      name: 'authorization',
      component: Authorization,
    },
    {
      path: '/personal',
      name: 'personal-information',
      component: PersonalInformation,
    },
  ],
});
