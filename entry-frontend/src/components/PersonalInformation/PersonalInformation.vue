<template>
  <div class="personal-information form">
    <navigation />
    <headline :title="title" :subText="subText" />
    <div class="form__cover">

      <!-- form -->
      <div class="form__cover__form">
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            이름
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-name"
              :value="name"
              @input="name = $event.target.value">
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            성별
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="radio"
              class="input-radio"
              id="female"
              value="female"
              @click="isOpen = false"
              v-model="sex">
            <label class="input-radio-label" for="female">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="female">
              여자
            </label>

            <input type="radio"
              class="input-radio"
              id="male"
              value="male"
              @click="isOpen = false"
              v-model="sex">
            <label class="input-radio-label" for="male">
              <span class="input-radio-span"></span>
            </label>
            <label class="form__cover__form__colums__input-content__label"
              for="male">
              남자
            </label>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            생년월일
          </div>
          <div class="form__cover__form__colums__input-content">
            <selectbox class="selectbox-year"
              v-model="year"
              :options="yearOptions"/>
            <label class="title--input">
              년
            </label>
            <selectbox class="selectbox-month"
              v-model="month"
              :options="monthOptions"/>
            <label class="title--input">
              월
            </label>
            <selectbox class="selectbox-day"
              v-model="day"
              :options="dayOptions"/>
            <label class="title--input">
              일
            </label>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            학번
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-school-grade"
              value="3"
              disabled>
            <label class="title--input">
              학년
            </label>
            <input type="text"
              class="input-text input-text-school-class"
              v-model="schoolClass"
              @keydown="onlyNumber">
            <label class="title--input">
              반
            </label>
            <input type="text"
              class="input-text input-text-school-number"
              v-model="schoolnumber"
              @keydown="onlyNumber">
            <label class="title--input">
              번
            </label>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            중학교명
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-school-name"
              :value="schoolName"
              @input="schoolName = $event.target.value">
            <button class="button button-search">검색</button>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            보호자명
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-guardian-name"
              :value="guardianName"
              @input="guardianName = $event.target.value">
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            학교 연락처
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-school-contact"
              v-model="schoolContact"
              @keydown="onlyNumber">
            <span class="form__cover__form__colums__input-content__sign">
              * ‘-’ 문자를 제외한 숫자만 입력해주세요.
            </span>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            보호자 연락처
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-guardian-contact"
              v-model="guardianContact"
              @keydown="onlyNumber">
            <span class="form__cover__form__colums__input-content__sign">
              * ‘-’ 문자를 제외한 숫자만 입력해주세요.
            </span>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            본인 연락처
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-contact"
              v-model="contact"
              @keydown="onlyNumber">
            <span class="form__cover__form__colums__input-content__sign">
              * ‘-’ 문자를 제외한 숫자만 입력해주세요.
            </span>
          </div>
        </div>
        <div class="form__cover__form__colums">
          <div class="form__cover__form__colums__name">
            주소
          </div>
          <div class="form__cover__form__colums__input-content">
            <input type="text"
              class="input-text input-text-zip"
              placeholder="우편번호"
              :value="zip"
              @input="zip = $event.target.value">
            <input type="text"
              class="input-text input-text-address"
              placeholder="기본주소"
              :value="address"
              @input="address = $event.target.value">
            <button class="button button-search-address">주소 검색</button>
            <br>
            <input type="text"
              class="input-text input-text-detailed-address"
              placeholder="상세주소"
              :value="detailedAddress"
              @input="detailedAddress = $event.target.value">
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
  name: 'personalInformation',
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
      yearOptions: [],
      monthOptions: [],
      name: null,
      sex: null,
      year: null,
      month: null,
      day: null,
      schoolClass: null,
      schoolnumber: null,
      schoolName: null,
      guardianName: null,
      schoolContact: null,
      guardianContact: null,
      contact: null,
      zip: null,
      address: null,
      detailedAddress: null,
    };
  },
  computed: {
    dayOptions() {
      let count;
      const year = this.year;
      // 윤년
      const isLeapYear = (year % 4 === 0 && year % 100 !== 0) || year % 400 === 0;

      switch (this.month) {
        case 2: count = isLeapYear ? 29 : 28; break;
        case 4:
        case 6:
        case 9:
        case 11: count = 30; break;
        default: count = 31; break;
      }

      const dayArray = [];
      for (let i = 1; i <= count; i += 1) {
        const pad = i >= 10 ? '' : '0';
        const day = pad + i;

        dayArray[i - 1] = {
          text: day,
          value: i,
        };
      }
      return dayArray;
    },
  },
  created() {
    // year options
    const lastYear = 2005;
    const count = 20;
    const yearArray = [];
    for (let i = 0; i < count; i += 1) {
      const year = lastYear - i;
      yearArray[i] = {
        text: `${year}`,
        value: year,
      };
    }
    this.yearOptions = yearArray;

    // month options
    const monthArray = [];
    for (let i = 1; i <= 12; i += 1) {
      const pad = i >= 10 ? '' : '0';
      monthArray[i - 1] = {
        text: pad + i,
        value: i,
      };
    }
    this.monthOptions = monthArray;
  },
  methods: {
    onlyNumber(e) {
      const keyCode = e.keyCode;
      // 숫자와 기능키, DELETE키 허용
      if ((keyCode > 31 && (keyCode < 48 || keyCode > 57)) &&
        keyCode !== 46 &&
        keyCode !== 37 &&
        keyCode !== 39) {
        e.preventDefault();
      }
    },
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

.button {
  height: 40px;
  border-radius: 5px;
  background-color: #f7fbfc;
  border: solid 1px #5f8a90;
  font-size: 18px;
  color: #296169;
  margin-left: 15px;
  &-search {
    width: 75px;
  }
  &-search-address {
    width: 125px;
  }
}

.input-text {
  &-name, &-guardian-name, &-zip {
    width: 150px;
  }
  &-school-name, &-school-contact, &-guardian-contact, &-contact {
    width: 250px;
  }
  &-address {
    width: 275px;
    margin: {
      left: 15px;
    }
  }
  &-detailed-address {
    width: 580px;
    margin-top: 20px;
  }
  &-school {
    &-grade, &-class, &-number {
      width: 50px;
      text-align: center;
      padding: 0;
    }
  }
}

.title {
  @include m('input') {
    font-size: 18px;
    width: fit-content;
    margin: {
      left: 10px;
      right: 35px;
    }
  }
}

.selectbox {
  &-year {
    width: 125px;
  }
  &-month, &-day {
    width: 75px;
  }
}
</style>
