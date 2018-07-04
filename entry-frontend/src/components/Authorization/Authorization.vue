<template>
  <div class="Authorization">
    <navigation />
    <div class="Authorization__wrapper">
      <headline title="2019 지원자 본인인증"/>
      <accept-terms />
      <info-input/>
    </div>
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import EntryFooter from '../common/EntryFooter';
import Headline from '../common/Headline';
import AcceptTerms from './AcceptTerms';
import InfoInput from './InfoInput';

export default {
  name: 'Authorization',
  components: {
    Navigation,
    EntryFooter,
    Headline,
    AcceptTerms,
    InfoInput,
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting.scss';

.Authorization{
  @include e(wrapper){
    width: 1140px;
    height: 1065px;
    margin: 0 auto;
  }
}
</style>
