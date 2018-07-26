<template>
  <div class="main-page">
    <navigation />
    <div class="main-page__hider">
      <transition name="page-move">
        <div class="main-page__hider__cover" v-show="!activeSchedulePage">
          <div class="main-page__hider__cover__content">
            <h4 class="main-page__hider__cover__content__sub-text">
              대덕소프트웨어마이스터고등학교
            </h4>
            <h1 class="main-page__hider__cover__content__title">
              2019 신입생 모집
            </h1>
            <a class="main-page__hider__cover__content__link">
              원서작성
            </a>
            <a class="main-page__hider__cover__content__link" @click="activeSchedulePage = true">
              모집일정
            </a>
          </div>
        </div>
      </transition>
      <transition name="page-move">
        <div class="main-page__hider__cover" v-show="activeSchedulePage">
          <div class="main-page__hider__cover__content">
            <h4 class="main-page__hider__cover__content__sub-text">
              대덕소프트웨어마이스터고등학교
            </h4>
            <h1 class="main-page__hider__cover__content__title">
              2019 신입생 모집일정
            </h1>
            <a class="main-page__hider__cover__content__link">
              원서작성
            </a>
            <a class="main-page__hider__cover__content__link">
              전형요강
            </a>
          </div>
        </div>
      </transition>
    </div>
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import EntryFooter from '../common/EntryFooter';

export default {
  name: 'main-page',
  components: {
    Navigation,
    EntryFooter,
  },
  data() {
    return {
      activeSchedulePage: false,
    };
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.main-page {
  background-image: url('../../assets/MainPage/main_background.svg');
  background-size: cover;
  background-position: center center;
  @include e('hider') {
    overflow-x: hidden;
    width: 100%;
    height: 1020px;
    position: relative;
    @include e('cover') {
      width: 100%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      position: absolute;
      top: 0;
      left: 0;
      @include e('content') {
        width: 1140px;
        height: 150px;
        font-size: 0;
        display: flex;
        flex-wrap: wrap;
        align-content: flex-start;
        border: {
          bottom: solid 6px #6ab7b7;
        }
        @include e('sub-text') {
          height: 50px;
          width: 100%;
          font-size: 28px;
          font-weight: normal;
        }
        @include e('title') {
          height: 50px;
          line-height: 50px;
          font-size: 54px;
          font-weight: normal;
          flex: 1;
        }
        @include e('link') {
          height: 50px;
          width: 175px;
          border-radius: 30px;
          background-image: linear-gradient(101deg, #82cdca, #5db3b6);
          box-shadow: 1px 25px 20px -15px #9ff0eb;
          font-size: 22px;
          color: #fff;
          border: none;
          cursor: pointer;
          line-height: 50px;
          text-align: center;
          &:last-child {
            margin-left: 25px;
          }
        }
      }
    }
  }
}

.page-move-enter {
  left: 100%;
}

.page-move-enter-to, .page-move-leave {
  left: 0;
}

.page-move-leave-to {
  left: -100%;
}

.page-move-enter-active, .page-move-leave-active {
  transition: left 1s ease-in-out;
}
</style>
