<template>
  <div class="info-summary">
    <navigation />
    <headline :title="title" :subText="subText" />
    <embed class="info-summary__pdf"
      type='application/pdf'
      :src="`${summaryInfoSrc}#page=${pageNumber}&zoom=${zoom}`"
      :height="height">
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import EntryFooter from '../common/EntryFooter';
import pdf from '../../assets/pdf/summary.pdf';

export default {
  name: 'info-summary',
  components: {
    Navigation,
    Headline,
    EntryFooter,
  },
  data() {
    return {
      title: '2019 신입생 전형요강',
      subText: '대덕소프트웨어마이스터고등학교',
      pdfId: 'pdf-target',
      summaryInfoSrc: pdf,
      pageNumber: 1,
      zoom: 80,
      height: 1055,
    };
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.info-summary {
  @include e('pdf') {
    width: 1140px;
    margin: {
      left: auto;
      right: auto;
      bottom: 125px;
    };
    display: block;
  }
}
</style>
