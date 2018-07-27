<template>
  <transition name="open-schedule" @after-enter="isAppear = true">
    <div class="schedule">
      <transition name="appear-content">
        <div class="schedule__content" v-if="isAppear">
          <p class="schedule__content__text">
            지금은 <span class="text-deco--1">원서작성</span> 기간입니다.
          </p>
          <p class="schedule__content__text">
            오늘은 <span class="text-deco--2">18년 {{ thisMonth }}월 {{ today }}일</span>이며
            마감일까지 <span class="text-deco--2">{{ restOfDay }}일 {{ restOfMinute }}분</span> 남았습니다.
          </p>
          <process-bar/>
          <p class="schedule__content__text">
            {{ startDateText }} ~ {{ endDateText }}
          </p>
          <a href="" class="schedule__content__link">
            원서작성 하러가기
          </a>
        </div>
      </transition>
    </div>
  </transition>
</template>

<script>
import ProcessBar from './ProcessBar';

export default {
  name: 'schedule',
  components: {
    ProcessBar,
  },
  data() {
    return {
      isAppear: false, // to animate
      thisMonth: '01',
      today: '01',
      restOfDay: '01',
      restOfMinute: '01',
      startDateText: '2018. 10. 23 (월) 09:00',
      endDateText: '2018. 10. 26 (목) 17:00',
    };
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.schedule {
  height: 580px;
  width: 100%;
  background-color: #fff;
  border: {
    top: solid 6px #6ab7b7;
  }
  @include e('content') {
    margin: {
      top: 90px;
    }
    text-align: center;
    @include e('text') {
      font-size: 22px;
      line-height: 2.05;
      letter-spacing: 0.6px;
      text-align: center;
      color: #000;
      font-weight: bold;
    }
    @include e('link') {
      height: 50px;
      display: inline-block;
      width: 300px;
      border-radius: 30px;
      background-image: linear-gradient(101deg, #82cdca, #5db3b6);
      box-shadow: 1px 25px 20px -15px #9ff0eb;
      font-size: 22px;
      color: #fff;
      border: none;
      cursor: pointer;
      line-height: 50px;
      text-decoration: none;
      margin: {
        top: 40px;
      }
    }
  }
}

.text-deco {
  @include m('1') {
    font-size: 30px;
    line-height: 1.5;
    color: #005c4f;
  }
  @include m('2') {
    font-size: 24px;
    line-height: 1.88;
    color: #41beb8;
  }
}

// animation

.open-schedule {
  &-enter-active {
    transition: height .5s ease-in-out;
  }

  &-enter {
    height: 0;
  }

  &-enter-to {
    height: 580px;
  }
}

.appear {
  &-content-enter {
    opacity: 0;
  }

  &-content-enter-to {
    opacity: 1;
  }

  &-content-enter-active {
    transition: opacity .5s;
  }
}
</style>
