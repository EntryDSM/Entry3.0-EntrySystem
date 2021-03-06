<template>
  <div class="modal">
    <div class="modal__background" @click="closeModal"></div>
    <div class="school-modal">
      <selectbox
        class="school-modal__select-office"
        v-model="office"
        :options="offices"></selectbox>
      <input
        type="text"
        class="input-text school-modal__input"
        placeholder="중학교 명"
        v-focus
        @input="keyword = $event.target.value"
        :value="keyword"
        @keyup="search"
      >
      <ul class="school-modal__list">
        <li
          class="school-modal__school"
          v-for="school in schools"
          :key="school.code"
          @click="selectSchool(school)">
          <div class="cover">
            {{ school.name }} ({{ school.government }})
          </div>
          <div class="select">선택</div>
        </li>
        <li class="school-modal__none" v-show="isEmpty">
          더 이상 검색 결과가 없습니다.
        </li>
      </ul>
      <div class="school-modal__close" @click="closeModal"></div>
    </div>
  </div>
</template>

<script>
import _ from 'lodash';
import contact from '../../api/contact';
import Selectbox from '../common/Selectbox';

const focus = {
  inserted(el) {
    el.focus();
  },
};

const offices = [
  { text: '전체', value: '' },
  { text: '서울특별시교육청', value: '서울특별시교육청' },
  { text: '부산광역시교육청', value: '부산광역시교육청' },
  { text: '대구광역시교육청', value: '대구광역시교육청' },
  { text: '인천광역시교육청', value: '인천광역시교육청' },
  { text: '광주광역시교육청', value: '광주광역시교육청' },
  { text: '대전광역시교육청', value: '대전광역시교육청' },
  { text: '울산광역시교육청', value: '울산광역시교육청' },
  { text: '경기도교육청', value: '경기도교육청' },
  { text: '강원도교육청', value: '강원도교육청' },
  { text: '충청북도교육청', value: '충청북도교육청' },
  { text: '충청남도교육청', value: '충청남도교육청' },
  { text: '전라북도교육청', value: '전라북도교육청' },
  { text: '전라남도교육청', value: '전라남도교육청' },
  { text: '경상북도교육청', value: '경상북도교육청' },
  { text: '경상남도교육청', value: '경상남도교육청' },
  { text: '세종특별자치시교육청', value: '세종특별자치시교육청' },
  { text: '제주특별자치도교육청', value: '제주특별자치도교육청' },
];

export default {
  directives: { focus },
  name: 'search-school-modal',
  components: {
    Selectbox,
  },
  data() {
    return {
      offices,
      office: offices[0].value,
      keyword: '',
      schools: [],
    };
  },
  computed: {
    isEmpty() {
      return !this.schools.length && this.keyword;
    },
  },
  methods: {
    search() {
      const { keyword, office } = this;
      const token = this.$cookies.get('accessToken');

      this.searchSchool(this, token, keyword, office);
    },
    searchSchool: _.debounce((self, token, keyword, office) => {
      const s = self;
      contact.getSchool({
        token,
        keyword,
        office,
      })
      .then(({ data }) => {
        const schoolData = data.data;
        s.schools = schoolData;
      })
      .catch(err => Promise.reject(err.response));
    }, 500),
    selectSchool(school) {
      const { e } = this.$toastr;
      if (school.government === '대전광역시교육청') {
        if (this.$store.state.classify.region) {
          this.$emit('selectSchool', school);
          this.$emit('close');
          return;
        }
        e('전국지역 학생이 대전광역시 소속 학교를 선택할 수 없습니다.');
      } else {
        if (!this.$store.state.classify.region) {
          this.$emit('selectSchool', school);
          this.$emit('close');
          return;
        }
        e('대전지역이 대전이외 소속 학교를 선택할 수 없습니다.');
      }
    },
    closeModal() {
      this.$emit('close');
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
@import '../../style/input';
$color-main1: #769b9f;
$color-main2: #e0eef1;
$color-main3: #5f8a90;
$color-main4: #f7fbfc;
$modal-z-index: 5;

.modal{
  width: 100vw;
  height: 100vh;
  display: flex;
  position: fixed;
  justify-content: center;
  align-items: center;
  @include e('background'){
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background-color: rgba($color: #8C8C8C, $alpha: 0.3);
  }
}
.school-modal {
  position: relative;
  $modal-width: 920px;
  $modal-height: 410px;
  width: $modal-width;
  height: $modal-height;
  border: 1px solid $color-main1;
  z-index: $modal-z-index;
  background-color: #fff;
  padding: 40px 45px;
  display: flex;
  flex-wrap: wrap;
  @include e('close'){
    position: absolute;
    top: 18px;
    right: 16px;
    width: 12px;
    height: 12px;
    &::before, &::after{
      position: relative;
      content: "";
      display: block;
      z-index: 8;
      width: 18px;
      height: 2px;
      border-radius: 10px;
      background-color: #dee8e9;
    }
    &::before{
      transform: rotate(-45deg);
      top: 2px;
    }
    &::after{
      transform: rotate(45deg);
    }
  }
  @include e('select-office') {
    width: 200px;
  }
  @include e('input') {
    width: 710px;
    margin-left: 10px;
  }
  @include e('list') {
    width: 100%;
    height: 360px;
    overflow-y: scroll;
    margin-top: 20px;
  }
  .select {
    display: none;
  }
  .cover {
    height: 60px;
    line-height: 60px;
    font-size: 18px;
    cursor: pointer;
  }
  @include e('school') {
    border-bottom: 1px solid #f1f5f5;
    height: 60px;
    padding-left: 25px;
    position: relative;
    overflow-x: hidden;
    &:hover {
      background-color: #f4f9fa;
      .select {
        width: 95px;
        height: 60px;
        position: absolute;
        top: 0;
        right: 0;
        color: #bbd2d6;
        font-size: 18px;
        line-height: 60px;
        background-color: #f4f9fa;
        display: block;
        text-align: center;
        cursor: pointer;
      }
    }
  }
  @include e('none') {
    height: 60px;
    padding-left: 25px;
    position: relative;
    line-height: 60px;
  }
}

</style>
