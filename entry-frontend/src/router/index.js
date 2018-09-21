import Vue from 'vue';
import Router from 'vue-router';
import InfoBrochure from '../components/Info/InfoBrochure';
import InfoSummary from '../components/Info/InfoSummary';
import MainPage from '../components/MainPage/MainPage';
import IntroduceNPlan from '../components/IntroNPlan/IntroduceNPlan';
import Classification from '../components/Classification/Classification';
import NormalGradeInputScheduled from '../components/GradeInput/NormalGradeInputScheduled';
import NormalGradeInputGraduated from '../components/GradeInput/NormalGradeInputGraduated';
import GedGradeInput from '../components/GradeInput/GedGradeInput';
import PersonalInformation from '../components/PersonalInformation/PersonalInformation';
import Authorization from './../components/Authorization/Authorization';
import Preview from './../components/Preview/Preview';

Vue.use(Router);

export default new Router({
  scrollBehavior(to, from, savedPosition) {
    return savedPosition || { x: 0, y: 0 };
  },
  routes: [{
    path: '/',
    name: 'main-page',
    component: MainPage,
  }, {
    path: '/auth',
    name: 'authorization',
    component: Authorization,
  }, {
    path: '/info-brochure',
    name: 'info-brochure',
    component: InfoBrochure,
  }, {
    path: '/info-summary',
    name: 'info-summary',
    component: InfoSummary,
  }, {
    path: '/classify',
    name: 'classification',
    component: Classification,
  }, {
    path: '/personal',
    name: 'personal-information',
    component: PersonalInformation,
  }, {
    path: '/grade-scheduled',
    name: 'normal-grade-input-scheduled',
    component: NormalGradeInputScheduled,
  }, {
    path: '/grade-graduated',
    name: 'normal-grade-input-graduated',
    component: NormalGradeInputGraduated,
  }, {
    path: '/grade-ged',
    name: 'ged-grade-input',
    component: GedGradeInput,
  }, {
    path: '/intro',
    name: 'introduce',
    component: IntroduceNPlan,
  }, {
    path: '/preview',
    name: 'preview',
    component: Preview,
  }],
});
