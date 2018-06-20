<template>
  <div class="classification">
    <navigation />
    <headline :title="title" :subText="subText" />
    <div class="classification__cover">
      <div class="classification__cover__form">
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            검정고시 지원여부
          </div>
          <div class="classification__cover__form__colums">
            <input type="checkbox" class="input-checkbox">
            <span class="classification__cover__form__colums__sign">
              * 검정고시를 통하여 지원하실 경우 체크해주세요
            </span>
          </div>
        </div>
      </div>
      <prev-next-btn
        :prevShow="0"
        :nextShow="1"
        @toNextPage="moveNext"
      />
    </div>
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import PrevNextBtn from '../common/PrevNextBtn';
import EntryFooter from '../common/EntryFooter';

export default {
  name: 'classification',
  components: {
    Navigation,
    Headline,
    PrevNextBtn,
    EntryFooter,
  },
  data() {
    return {
      title: '전형 구분 선택',
      subText: '2019 입학원서 작성',
    };
  },
  methods: {
    moveNext() {
      this.$router.push('/');
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.classification {
  @include e('cover') {
    width: 1140px;
    margin: 0 auto;
  }
}
</style>
