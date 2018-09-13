import Vue from 'vue';
import Router from 'vue-router';
import MainPage from '../components/MainPage/MainPage';
import IntroduceNPlan from '../components/IntroNPlan/IntroduceNPlan';
import Classification from '../components/Classification/Classification';
import NormalGradeInputScheduled from '../components/GradeInput/NormalGradeInputScheduled';
import NormalGradeInputGraduated from '../components/GradeInput/NormalGradeInputGraduated';
import GedGradeInput from '../components/GradeInput/GedGradeInput';
import PersonalInformation from '../components/PersonalInformation/PersonalInformation';
import Authorization from './../components/Authorization/Authorization';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main-page',
      component: MainPage,
    },
    {
      path: '/auth',
      name: 'authorization',
      component: Authorization,
    },
    {
      path: '/classify',
      name: 'classification',
      component: Classification,
    },
    {
      path: '/personal',
      name: 'personal-information',
      component: PersonalInformation,
    },
    {
      path: '/normal-grade-scheduled',
      name: 'normal-grade-input-scheduled',
      component: NormalGradeInputScheduled,
    },
    {
      path: '/normal-grade-graduated',
      name: 'normal-grade-input-graduated',
      component: NormalGradeInputGraduated,
    },
    {
      path: '/ged-grade-input',
      name: 'ged-grade-input',
      component: GedGradeInput,
    },
    {
      path: '/intro',
      name: 'introduce',
      component: IntroduceNPlan,
    },
  ],
});
