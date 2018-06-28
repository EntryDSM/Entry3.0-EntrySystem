<template>
  <div>
    <navigation />
    <headline :subText="'2019 입학원서 작성'" title="성적 입력" />
    <div class="grade-input-cover">
      <h3>봉사 & 출석</h3>
      <table class="volunteer-attendance-table">
        <tr class="table-row">
          <td class="table-data-text">봉사시간</td>
          <td class="table-data-text">
            <input type="number"
                   v-model="volunteer"
                   min="0"
                   class="input-text table-data-text__input"
            >
            <span class="table-data-text__time">시간</span>
          </td>
        </tr>
        <tr class="table-row">
          <td class="table-data-text">출석정보</td>
          <td class="table-data-text table-data-text--attendance-info">
            <tr class="table-data-text__row">
              <td class="table-data-text__row__data">전체 무단 결석 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model="absence"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
              <td class="table-data-text__row__data">전체 무단 조퇴 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model="earlyLeave"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
            </tr>
            <tr class="table-data-text__row">
              <td class="table-data-text__row__data">전체 무단 지각 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model="lateness"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
              <td class="table-data-text__row__data">전체 무단 결과 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model="missingClass"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
            </tr>
          </td>
        </tr>
      </table>

      <h3>미이수 학기 선택</h3>
      <table class="discomplete-table">
      </table>

      <h3>성적입력</h3>
      <table class="grade-input-table">
      </table>
    </div>
    <prev-next-btn :prevShow="1"
                   :nextShow="1"
                   @toPrevPage="movePrev"
                   @toNextPage="moveNext"
    />
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import PrevNextBtn from '../common/PrevNextBtn';
import EntryFooter from '../common/EntryFooter';

export default {
  name: 'name-grade-input',
  components: {
    Navigation,
    Headline,
    PrevNextBtn,
    EntryFooter,
  },
  data() {
    return {
      volunteer: 0,
      absence: 0,
      earlyLeave: 0,
      lateness: 0,
      missingClass: 0,
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

$table-border: #769b9f;
$table-inner: #f3f3f3;
$input-color: #5f8a90;

.grade-input-cover {
  width: 1140px;
  margin: 0 auto;
  position: relative;

  h3 {
    font-size: 22px;
    font-weight: 400;
    margin-top: 55px;

    &:first-of-type {
      margin-top: 0;
    }
  }

  table {
    width: 100%;
    position: relative;
    margin-top: 20px;

    &::before, &::after {
      content: '';
      display: block;
      width: 112%;
      height: 1px;
      position: absolute;
      left: 50%;
      transform: translateX(-50%);
      background: linear-gradient(left, transparent 0%,
      $table-border 15%, $table-border 85%, transparent 100%);
    }

    &::before { top: 0; }
    &::after { bottom: 0; }
  }

  .volunteer-attendance-table {
    height: 225px;

    .table-row {
      display: flex;
      align-items: center;
      font-size: 20px;

      &:first-of-type {
        height: 74px;
        border-bottom: 1px solid $table-inner;
      }
      &:nth-of-type(2) {
        height: 149px;
      }

      .table-data-text {
        width: calc(100% - 148px);
        height: 100%;
        display: flex;
        align-items: center;

        &:nth-of-type(2n-1) {
          width: 148px;
          justify-content: center;
          border-right: 1px solid $table-inner;
        }

        @include e('input') {
          width: 75px;
          margin-left: 28px;
        }

        @include e('time') {
          font-size: 18px;
          padding-left: 11px;
        }

        @include e('row') {
          display: block;
          width: 100%;
          height: 50%;
          border-bottom: 1px solid $table-inner;

          @include e('data') {
            display: inline-flex;
            width: 25%;
            height: 100%;
            align-items: center;
            justify-content: center;
            float: left;
            font-size: 20px;
            box-sizing: border-box;
            border-right: 1px solid $table-inner;

            &:nth-of-type(2n) {
              justify-content: flex-start;
            }

            &:nth-of-type(4n) {
              border-right: 0;
            }
          }
        }

        @include m('attendance-info') {
          display: block;
        }
      }
    }
  }

  .discomplete-table {
    height: 150px;
  }

  .grade-input-table {
    height: 675px;
  }
}
</style>
