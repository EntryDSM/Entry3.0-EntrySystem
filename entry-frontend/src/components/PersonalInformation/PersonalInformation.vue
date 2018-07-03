<template>
  <div class="personal-information form">
    <navigation />
    <headline :title="title" :subText="subText" />
    <div class="form__cover">

      <!-- form -->
      <div class="form__cover__form">
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
          </div>
          <div class="form__cover__form__colums__input-content">
          </div>
        </div>
      </div>
      <!-- form end -->

      <prev-next-btn
      :prevShow="1"
      :nextShow="1"
      @toPrevPage="movePrev"
      @toNextPage="moveNext"/>
    </div>
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import PrevNextBtn from '../common/PrevNextBtn';
import EntryFooter from '../common/EntryFooter';
import Selectbox from '../common/Selectbox';

export default {
  name: 'classification',
  components: {
    Navigation,
    Headline,
    PrevNextBtn,
    EntryFooter,
    Selectbox,
  },
  data() {
    return {
      title: '인적 사항',
      subText: '2019 입학원서 작성',
    };
  },
  methods: {
    movePrev() {
      this.$router.push('/');
    },
    moveNext() {
      this.$router.push('/');
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
$color-main1: #769b9f;
$color-main2: #eff3f4;
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
        border: {
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
          font-size: 0px;
          padding-left: 30px;
          box-sizing: border-box;
          width: 85%;
          height: 100%;
          display: inline-block;
          position: relative;
          user-select: none;
          @include e('sign') {
            position: absolute;
            right: 0;
            top: 0;
            font-size: 14px;
            color: $color-main3;
          }
          @include e('label') {
            font-size: 18px;
            display: inline-block;
            min-width: 100px;
            padding: {
              left: 10px;
              right: 50px;
            }
          }
        }
      }
    }
  }
}

.selectbox {
  width: 150px;
}
</style>
