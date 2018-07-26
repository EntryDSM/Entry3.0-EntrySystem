<template>
  <div class="schedule">
    <p class="schedule__text">
      지금은<span class="text-deco--1">원서작성</span>기간입니다.
    </p>
    <p class="schedule__text">
      오늘은 <span class="text-deco--2">18년 {{ thisMonth }}월 {{ today }}일</span>이며
      마감일까지 <span class="text-deco--2">{{ restOfDay }}일 {{ restOfMinute }}분</span> 남았습니다.
    </p>
  </div>
</template>

<script>
export default {
  name: 'schedule',
  data() {
    return {
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

</style>
