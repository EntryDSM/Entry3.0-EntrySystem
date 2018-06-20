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
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="input-checkbox">
            <label class="input-checkbox" for="input-checkbox"></label>
            <span class="classification__cover__form__colums__input-content__sign">
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
$color-main1: #769b9f;
$color-main2: #5f8a90;
$color-main3: #608a8e;

.classification {
  @include e('cover') {
    width: 1140px;
    margin: 0 auto;
    @include e('form') {
      border: {
        top: solid 1px $color-main1;
        bottom: solid 1px $color-main1;
      }
      @include e('colums') {
        height: 75px;
        line-height: 75px;
        font-size: 0;
        border {
          bottom: solid 1px $color-main2;
        }
        @include e('name') {
          font-size: 20px;
          height: 100%;
          width: 15%;
          text-align: center;
          display: inline-block;
        }
        @include e('input-content') {
          font-size: 18px;
          padding-left: 30px;
          box-sizing: border-box;
          width: 85%;
          height: 100%;
          display: inline-block;
          position: relative;
          @include e('sign') {
            position: absolute;
            right: 0;
            top: 0;
            font-size: 14px;
            color: $color-main3;
          }
        }
      }
    }
  }
}
</style>
