<template>
  <div class="info-brochure">
    <navigation />
    <headline :title="title" :subText="subText" />
    <application></application>
    <introduction></introduction>
    <academic-plan></academic-plan>
    <recommendation-letter v-if="admission !== 'NORMAL'"></recommendation-letter>
    <quitting-smoking></quitting-smoking>
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import EntryFooter from '../common/EntryFooter';
import AcademicPlan from './AcademicPlan';
import Application from './Application';
import Introduction from './Introduction';
import QuittingSmoking from './QuittingSmoking';
import RecommendationLetter from './RecommendationLetter';

export default {
  name: 'info-brochure',
  components: {
    Navigation,
    Headline,
    EntryFooter,
    AcademicPlan,
    Application,
    Introduction,
    QuittingSmoking,
    RecommendationLetter,
  },
  data() {
    return {
      title: '원서 미리보기',
      subText: '대덕소프트웨어마이스터고등학교',
    };
  },
  computed: {
    admission() {
      return this.$store.state.classify.admission;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
</style>
