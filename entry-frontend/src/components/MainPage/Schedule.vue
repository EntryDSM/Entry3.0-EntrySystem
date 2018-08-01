<template>
  <transition name="open-schedule" @after-enter="isAppear = true">
    <div class="schedule">
      <transition name="appear-content">
        <div class="schedule__content" v-if="isAppear">
          <p class="schedule__content__text">
            지금은 <span class="text-deco--1">{{ scheduleName }}</span> 기간입니다.
          </p>
          <p class="schedule__content__text">
            오늘은 <span class="text-deco--2">{{ thisYear }}년 {{ thisMonth }}월 {{ thisDate }}일</span>이며
            {{ word }}까지 <span class="text-deco--2">{{ restOfDateText }}</span> 남았습니다.
          </p>
          <process-bar class="schedule__content__process-bar"
            :captions="captions"
            :ahead="todayIndex"
            @change="changeCurrent"/>
          <p class="schedule__content__text">
            {{ scheduleDateText }}
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

const week = ['일', '월', '화', '수', '목', '금', '토'];

export default {
  name: 'schedule',
  components: {
    ProcessBar,
  },
  data() {
    return {
      isAppear: false, // to animate
      date: null, // Date Object
      captions: [
        '원서작성',
        '1차 발표',
        '면접',
        '2차 발표',
        '합격자 등록',
      ],
      startDate: [],
      endDate: [],
      todayIndex: 0,
      scheduleName: '',
      word: '',
      scheduleDateText: '',
    };
  },
  created() {
    this.date = new Date();
    this.changeCurrent(0);
  },
  computed: {
    thisYear() { return this.date.getFullYear().toString().slice(-2); },
    thisMonth() { return this.pad(this.date.getMonth() + 1, 2); },
    thisDate() { return this.pad(this.date.getDate(), 2); },
    restOfDateText() {
      const endDate = new Date(...this.endDate);

      // date constant
      const HOUR = 1000 * 60 * 60;
      const DAY = HOUR * 24;

      // calculate diffrance
      const diff = endDate - this.date;
      let dateDiff = parseInt(diff / DAY, 10);
      let hourDiff = parseInt((diff / HOUR) % 24, 10);

      // pad
      dateDiff = this.pad(dateDiff, 2);
      hourDiff = this.pad(hourDiff, 2);
      return `${dateDiff}일 ${hourDiff}시간`;
    },
  },
  methods: {
    pad(text, n) {
      return '0'.repeat(n - 1).concat(text).slice(-n);
    },
    formatDateText(array) {
      const date = new Date(...array);
      return `${date.getFullYear()}. ${date.getMonth() + 1}. ${date.getDate()}
        (${week[date.getDay()]}) ${this.pad(date.getHours(), 2)}:${this.pad(date.getMinutes(), 2)}`;
    },
    changeCurrent(current) {
      let contents;
      switch (current) {
        case 0: contents = ['원서작성', '마감일', [2018, 9, 26, 17, 0], [2018, 9, 23, 9, 0]]; break;
        case 1:
        case 2: contents = ['1차 발표', '발표일', [2018, 9, 31, 10, 0]]; break;
        case 3:
        case 4: contents = ['면접', '면접일', [2018, 10, 3, 8, 30]]; break;
        case 5:
        case 6: contents = ['2차 발표', '발표일', [2018, 10, 9, 10, 0]]; break;
        case 7:
        case 8: contents = ['합격자 등록', '마감일', [2018, 10, 14, 17, 0], [2018, 10, 9, 10, 0]]; break;
        default: break;
      }
      this.setContent(...contents);
    },
    setContent(scheduleName, word, endDate, startDate) {
      this.scheduleName = scheduleName;
      this.word = word;
      this.endDate = endDate;
      this.startDate = startDate;
      if (startDate) this.scheduleDateText = `${this.formatDateText(startDate)} ~ ${this.formatDateText(endDate)}`;
      else this.scheduleDateText = this.formatDateText(endDate);
    },
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
    @include e('process-bar') {
      margin: {
        top: 100px;
        bottom: 60px;
        left: auto;
        right: auto;
      }
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
