import Vue from 'vue';
import Router from 'vue-router';
import IntroduceNPlan from '../components/IntroNPlan/IntroduceNPlan';
import Classification from '../components/Classification/Classification';
import Authorization from '../components/Authorization/Authorization';
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
      path: '/personal',
      name: 'personal-information',
      component: PersonalInformation,
    },
  ],
});
