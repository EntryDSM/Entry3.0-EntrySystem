<template>
  <div class="classification form">
    <navigation />
    <headline :title="title" :subText="subText" />
    <div class="form__cover">

      <!-- form -->
      <div class="form__cover__form">
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            검정고시 지원여부
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="checkbox" class="input-checkbox" id="isGED" v-model="isGED">
            <label class="input-checkbox-label" for="isGED"></label>
            <span class="form__cover__form__colums__input-content__sign">
              * 검정고시를 통하여 지원하실 경우 체크해주세요
            </span>
          </div>
        </div>

        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            전형 선택
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="radio"
              class="input-radio"
              id="general"
              value="general"
              @click="isOpen = false"
              v-model="entranceModel">
            <label class="input-radio-label" for="general">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="general">
              일반전형
            </label>

            <input type="radio"
              class="input-radio"
              id="meister"
              value="meister"
              @click="isOpen = false"
              v-model="entranceModel">
            <label class="input-radio-label" for="meister">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="meister">
              마이스터 인재전형
            </label>

            <input type="radio"
              class="input-radio"
              id="social"
              value="social"
              v-model="entranceModel"
              @click="isOpen = true">
            <label class="input-radio-label" for="social">
              <span class="input-radio-span"></span>
            </label>
            <social-option
              :options="[
                {text:'기초생활수급권자', value:'기초생활수급권자'},
                {text:'한부모가족 보호대상자', value:'한부모가족 보호대상자'},
                {text:'차상위 계층', value:'차상위 계층'},
                {text:'차차상위 계층', value:'차차상위 계층'},
                {text:'북한이탈주민', value:'북한이탈주민'},
                {text:'다문화 가정', value:'다문화 가정'},
                {text:'그 외 대상자', value:'그 외 대상자'},
              ]"
              v-model="socialOption"
              v-show="isOpen"
              @close="isOpen = false"/>
            <label class="form__cover__form__colums__input-content__label"
              for="social">
              사회통합전형
              <span v-show="socialOption">/ {{ socialOption }}
                <span class="point-color">▾</span>
              </span>
            </label>
          </div>
        </div>

        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            지역 선택
          </div>
          <div class="form__cover__form__colums__input-content">
            <selectbox class="selectbox"
              v-model="region"
              :options="[
                {text: '전국', value:'전국'},
                {text: '대전', value:'대전'}
              ]"/>
          </div>
        </div>

        <div v-show="!isGED">
          <div class="form__cover__form__colums">
            <div class="form__cover__form__colums__name">
              졸업 구분
            </div>
            <div class="form__cover__form__colums__input-content">
              <input type="radio"
                class="input-radio"
                id="notGraduated"
                :value="false"
                v-model="isGraduated">
              <label class="input-radio-label" for="notGraduated">
                <span class="input-radio-span"></span>
              </label>
              <label class="form__cover__form__colums__input-content__label"
                for="notGraduated">
                졸업 예정자
              </label>

              <input type="radio"
                class="input-radio"
                id="graduated"
                :value="true"
                v-model="isGraduated">
              <label class="input-radio-label" for="graduated">
                <span class="input-radio-span"></span>
              </label>
              <label class="form__cover__form__colums__input-content__label"
                for="graduated">
                졸업자
              </label>
            </div>
          </div>

          <div class="form__cover__form__colums">
            <div class="form__cover__form__colums__name">
              졸업 연도
            </div>
            <div class="form__cover__form__colums__input-content">
              <selectbox class="selectbox"
                v-model="graduationYear"
                :isEnabled="isGraduated"
                :options="[
                  {text: '2017', value:'2017'},
                  {text: '2016', value:'2016'},
                  {text: '2015', value:'2015'},
                  {text: '2014', value:'2014'},
                  {text: '2013', value:'2013'},
                  {text: '2012', value:'2012'},
                  {text: '2011', value:'2011'},
                  {text: '2010', value:'2010'},
                ]"/>
                년
            </div>
          </div>
        </div>

        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            특기사항
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="radio"
              class="input-radio"
              id="honor"
              value="honor"
              v-model="specialPoints">
            <label class="input-radio-label" for="honor">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="honor">
              국가 유공자
            </label>

            <input type="radio"
              class="input-radio"
              id="exception"
              value="exception"
              v-model="specialPoints">
            <label class="input-radio-label" for="exception">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="exception">
              특례 입학 대상자
            </label>
            <span class="form__cover__form__colums__input-content__sign">
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
import Selectbox from '../common/Selectbox';
import SocialOption from './SocialOption';

export default {
  name: 'classification',
  components: {
    Navigation,
    Headline,
    PrevNextBtn,
    EntryFooter,
    Selectbox,
    SocialOption,
  },
  data() {
    return {
      title: '전형 구분 선택',
      subText: '2019 입학원서 작성',
      isGED: false,
      entranceModel: '',
      socialOption: '',
      region: '',
      isGraduated: false,
      graduationYear: 0,
      specialPoints: [],
      isOpen: false,
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
.point-color {
  color: #799da1;
}

.selectbox {
  width: 150px;
}
</style>
