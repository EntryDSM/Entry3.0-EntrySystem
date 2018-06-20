<template>
  <div class="classification">
    <navigation />
    <headline :title="title" :subText="subText" />
    <div class="classification__cover">

      <!-- form -->
      <div class="classification__cover__form">
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            검정고시 지원여부
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="isGED" v-model="isGED">
            <label class="input-checkbox" for="isGED"></label>
            <span class="classification__cover__form__colums__input-content__sign">
              * 검정고시를 통하여 지원하실 경우 체크해주세요
            </span>
          </div>
        </div>
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            전형 선택
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="radio"
              class="input-radio"
              id="general"
              value="general"
              v-model="entranceModel">
            <label class="input-radio-label" for="general">
              <span class="input-radio-span"></span>
            </label>
            <label class="classification__cover__form__colums__input-content__label"
            for="general">일반전형</label>

            <input type="radio"
              class="input-radio"
              id="meister"
              value="meister"
              v-model="entranceModel">
            <label class="input-radio-label" for="meister">
              <span class="input-radio-span"></span>
            </label>
            <label class="classification__cover__form__colums__input-content__label"
            for="meister">마이스터 인재전형</label>

            <input type="radio"
              class="input-radio"
              id="social"
              value="social"
              v-model="entranceModel">
            <label class="input-radio-label" for="social">
              <span class="input-radio-span"></span>
            </label>
            <label class="classification__cover__form__colums__input-content__label"
            for="social">사회통합전형 / 기초생활수급권자</label>
          </div>
        </div>

        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            지역 선택
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="input-checkbox">
            <label class="input-checkbox" for="input-checkbox"></label>
          </div>
        </div>
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            졸업 선택
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="input-checkbox">
            <label class="input-checkbox" for="input-checkbox"></label>
          </div>
        </div>
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            졸업 연도
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="input-checkbox">
            <label class="input-checkbox" for="input-checkbox"></label>
          </div>
        </div>
        <div class="classification__cover__form__colums">
          <div class="classification__cover__form__colums__name">
            특기사항
          </div>
          <div class="classification__cover__form__colums__input-content">
            <input type="checkbox" id="input-checkbox">
            <label class="input-checkbox" for="input-checkbox"></label>
            <span class="classification__cover__form__colums__input-content__sign">
              * 졸업자의 경우 졸업연도를 선택해주세요
            </span>
          </div>
        </div>
      </div>
      <!-- form end -->

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
      isGED: false,
      entranceModel: '',
      region: '',
      isGraduated: false,
      graduationYear: 0,
      specialPoints: [],
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
          @include e('label') {
            padding: {
              left: 10px;
              right: 80px;
            }
          }
        }
      }
    }
  }
}
</style>
