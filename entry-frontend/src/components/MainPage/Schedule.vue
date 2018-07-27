<template>
  <transition name="open-schedule" @after-enter="isAppear = true">
    <div class="schedule">
      <transition name="appear-content">
        <div class="schedule__content" v-if="isAppear">
          <p class="schedule__content__text">
            지금은<span class="text-deco--1">원서작성</span>기간입니다.
          </p>
          <p class="schedule__content__text">
            오늘은 <span class="text-deco--2">18년 {{ thisMonth }}월 {{ today }}일</span>이며
            마감일까지 <span class="text-deco--2">{{ restOfDay }}일 {{ restOfMinute }}분</span> 남았습니다.
          </p>
          <process-bar/>
          <p class="schedule__content__text"></p>
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
}

// animation

.open-schedule-enter-active {
  transition: height .5s ease-in-out;
}

.open-schedule-enter {
  height: 0;
}

.open-schedule-enter-to {
  height: 580px;
}

.appear-content-enter {
  opacity: 0;
}

.appear-content-enter-to {
  opacity: 1;
}

.appear-content-enter-active {
  transition: opacity .5s;
}
</style>
