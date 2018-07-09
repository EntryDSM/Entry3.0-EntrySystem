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
                   v-model.number="volunteerNAttendance.volunteer"
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
                       v-model.number="volunteerNAttendance.absence"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
              <td class="table-data-text__row__data">전체 무단 조퇴 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model.number="volunteerNAttendance.earlyLeave"
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
                       v-model.number="volunteerNAttendance.lateness"
                       min="0"
                       class="input-text table-data-text__input"
                >
                <span class="table-data-text__time">일</span>
              </td>
              <td class="table-data-text__row__data">전체 무단 결과 일수</td>
              <td class="table-data-text__row__data">
                <input type="number"
                       v-model.number="volunteerNAttendance.missingClass"
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
        <tr class="table-row">
          <td class="table-row__first-grade">1학년</td>
          <td class="table-row__second-grade">2학년</td>
          <td class="table-row__third-grade">3학년</td>
        </tr>
        <tr class="table-row">
          <td class="table-row__first-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-first-first"
                   v-model="semesters.firstFirstSemester"
            />
            <label class="input-checkbox-label" for="input-first-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
          <td class="table-row__first-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-first-second"
                   v-model="semesters.firstSecondSemester"
            />
            <label class="input-checkbox-label" for="input-first-second"></label>
            <span class="table-row__semester-text">2학기</span>
          </td>
          <td class="table-row__second-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-second-first"
                   v-model="semesters.secondFirstSemester"
            />
            <label class="input-checkbox-label" for="input-second-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
          <td class="table-row__second-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-second-second"
                   v-model="semesters.secondSecondSemester"
            />
            <label class="input-checkbox-label" for="input-second-second"></label>
            <span class="table-row__semester-text">2학기</span>
          </td>
          <td class="table-row__third-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-third-first"
                   v-model="semesters.thirdFirstSemester"
            />
            <label class="input-checkbox-label" for="input-third-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
        </tr>
      </table>

      <h3>성적입력</h3>
      <table class="grade-input-table">
        <div class="all-grade-reset-cover">
          <div class="all-grade-reset-cover__box">
            <span class="all-grade-reset-cover__box__text">
              전체 성적이 {{ resetAllGrade }} 로 초기화 됩니다.
            </span>
          </div>
          <div class="all-grade-reset-cover__reset">
            <span class="all-grade-reset-cover__reset__text">전체 성적 초기화: </span>
            <button type="button" @click="resetGrade">A</button>
            <button type="button" @click="resetGrade">B</button>
            <button type="button" @click="resetGrade">C</button>
            <button type="button" @click="resetGrade">D</button>
            <button type="button" @click="resetGrade">E</button>
          </div>
        </div>
        <tr class="grade-input-table__row">
          <td class="empty-space"></td>
          <td class="first-grade row-grades" colspan="2">1학년</td>
          <td class="second-grade row-grades" colspan="2">2학년</td>
          <td class="third-grade row-grades">3학년</td>
        </tr>
        <tr class="grade-input-table__row">
          <td class="empty-space"></td>
          <td>1학기</td>
          <td>2학기</td>
          <td>1학기</td>
          <td>2학기</td>
          <td>1학기</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>국어</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>사회</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>역사</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>수학</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>과학</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>기술・가정</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
        <tr class="grade-input-table__row">
          <td>영어</td>
          <td>A</td>
          <td>B</td>
          <td>C</td>
          <td>D</td>
          <td>E</td>
        </tr>
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
      // 봉사 및 출석
      volunteerNAttendance: {
        volunteer: 0,
        absence: 0,
        earlyLeave: 0,
        lateness: 0,
        missingClass: 0,
      },
      // 미이수 학기 선택
      semesters: {
        firstFirstSemester: false,
        firstSecondSemester: false,
        secondFirstSemester: false,
        secondSecondSemester: false,
        thirdFirstSemester: false,
      },
      // 모든 학기 초기화
      resetAllGrade: '',
    };
  },
  methods: {
    movePrev() {
      this.$router.push('/');
    },
    moveNext() {
      this.$router.push('/');
    },
    resetGrade({ target }) {
      this.resetAllGrade = target.textContent;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

$table-border: #769b9f;
$table-inner: #f2f2f2;
$input-color: #5f8a90;
$table-background: #f7fbfc;
$button-color: #edf5f6;

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
    width: 100%;
    height: 150px;

    .table-row {
      height: calc(100% / 2);

      &:first-of-type {
        background: linear-gradient(left, transparent 0%,
        $table-background 10%, $table-background 90%, transparent 100%);
      }

      & > td {
        display: inline-flex;
        justify-content: center;
        align-items: center;
        height: 100%;
        font-size: 20px;
        box-sizing: border-box;
      }

      @include e('first-grade') {
        width: 455.6px;
        border-right: 1px solid $table-inner;
      }

      @include e('second-grade') {
        width: 453.6px;
        border-right: 1px solid $table-inner;
      }

      @include e('third-grade') {
        width: calc(100% - 909.2px);
      }

      @include e('first-semester') {
        width: 227.8px;
        height: 100%;
        border-right: 1px solid $table-inner;
      }

      @include e('second-semester') {
        width: 226.8px;
        height: 100%;
        border-right: 1px solid $table-inner;
      }

      @include e('third-semester') {
        width: calc(100% - 909.2px);
        height: 100%;
      }

      @include e('semester-text') {
        font-size: 18px;
        padding-left: 7px;
      }

      .input-checkbox-label {
        margin-top: -7px;
      }
    }
  }

  .grade-input-table {
    height: 675px;

    .all-grade-reset-cover {
      width: 200px;
      height: 60px;
      box-sizing: border-box;
      position: absolute;
      right: 0;
      margin-top: -64px;

      @include e('box') {
        width: 175px;
        height: 24px;
        border: 1px solid $input-color;
        border-radius: 5px;
        display: flex;
        align-items: center;
        justify-content: center;
        box-sizing: border-box;
        float: right;

        @include e('text') {
          font-size: 10px;
          color: #26484c;
        }
      }

      @include e('reset') {
        margin-top: 13px;
        display: flex;
        align-items: center;
        justify-content: flex-end;
        float: right;

        @include e('text') {
          font-size: 10px;
        }

        button {
          width: 20px;
          height: 20px;
          border-radius: 50%;
          background-color: transparent;
          font-size: 14px;
          border: 0;
          margin-left: 1px;
          cursor: pointer;
          outline: none;
          transition: background-color 0.3s;

          &:hover {
            background-color: $button-color;
          }

          &:last-of-type {
            margin-right: -5px;
          }
        }
      }
    }

    @include e('row') {
      width: 100%;
      height: 75px;

      &:first-of-type {
        height: 75px;
        font-size: 20px;
        background-color: $table-background;
      }

      &:nth-of-type(2) {
        height: 73px;
        background-color: $table-background;
        border-bottom: 1px solid $table-inner;

        td {
          border-right: 1px solid $table-inner;
          &:last-of-type { border-right: 0; }
          font-size: 20px;
        }
      }

      td {
        vertical-align: middle;
        text-align: center;
        font-size: 18px;
        border: {
          right: 1px solid $table-inner;
          bottom: 1px solid $table-inner;
        }

        &:nth-of-type(1) {
          width: 163px;
          background-color: $table-background;
          border: {
            top: 1px solid $table-inner;
            right: 1px solid $table-inner;
          }
        }

        &:last-of-type { border-right: 0; }

        &.empty-space {
          border: {
            top: 0;
            bottom: 0;
          }
        }
        &.first-grade,
        &.second-grade { border-right: 1px solid $table-inner; }
        &.third-grade { border-right: 0; }
        &.row-grades {
          border-bottom: 1px solid $table-inner;
          font-size: 20px;
        }
      }
    }
  }
}
</style>
