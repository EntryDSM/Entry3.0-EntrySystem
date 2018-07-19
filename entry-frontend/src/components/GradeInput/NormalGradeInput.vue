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
                   :value="`${semesters.firstFirstSemester}`"
                   v-model="semesters.firstFirstSemester"
                   @change="discompleteSemester"
            >
            <label class="input-checkbox-label" for="input-first-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
          <td class="table-row__first-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-first-second"
                   :value="`${semesters.firstSecondSemester}`"
                   v-model="semesters.firstSecondSemester"
                   @change="discompleteSemester"
            >
            <label class="input-checkbox-label" for="input-first-second"></label>
            <span class="table-row__semester-text">2학기</span>
          </td>
          <td class="table-row__second-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-second-first"
                   :value="`${semesters.secondFirstSemester}`"
                   v-model="semesters.secondFirstSemester"
                   @change="discompleteSemester"
            >
            <label class="input-checkbox-label" for="input-second-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
          <td class="table-row__second-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-second-second"
                   :value="`${semesters.secondSecondSemester}`"
                   v-model="semesters.secondSecondSemester"
                   @change="discompleteSemester"
            >
            <label class="input-checkbox-label" for="input-second-second"></label>
            <span class="table-row__semester-text">2학기</span>
          </td>
          <td class="table-row__third-semester">
            <input type="checkbox"
                   class="input-checkbox"
                   id="input-third-first"
                   :value="`${semesters.thirdFirstSemester}`"
                   v-model="semesters.thirdFirstSemester"
                   @change="discompleteSemester"
            >
            <label class="input-checkbox-label" for="input-third-first"></label>
            <span class="table-row__semester-text">1학기</span>
          </td>
        </tr>
      </table>

      <h3>성적입력</h3>
      <table class="grade-input-table" ref="grade-table">
        <div class="all-grade-reset-cover">
          <div class="all-grade-reset-cover__box">
            <span class="all-grade-reset-cover__box__text">
              전체 성적이 {{ resetAllGrade }} 로 초기화 됩니다.
            </span>
          </div>
          <div class="all-grade-reset-cover__reset">
            <span class="all-grade-reset-cover__reset__text">전체 성적 초기화: </span>
            <button type="button"
                    v-for="reset in scores"
                    :key="reset"
                    @click="resetGrade"
            >
              {{ reset.toUpperCase() }}
            </button>
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
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`korean-first-first-${k}`"
                   v-model="koreanScores[0].score"
                   :checked="koreanScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`korean-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="korean-first-first-null"
                   v-model="koreanScores[0].score"
                   :checked="koreanScores[0].decided"
            >
            <label for="korean-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`korean-first-second-${k}`"
                   v-model="koreanScores[1].score"
                   :checked="koreanScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`korean-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="korean-first-second-null"
                   v-model="koreanScores[1].score"
                   :checked="koreanScores[1].decided"
            >
            <label for="korean-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`korean-second-first-${k}`"
                   v-model="koreanScores[2].score"
                   :checked="koreanScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`korean-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="korean-second-first-null"
                   v-model="koreanScores[2].score"
                   :checked="koreanScores[2].decided"
            >
            <label for="korean-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`korean-second-second-${k}`"
                   v-model="koreanScores[3].score"
                   :checked="koreanScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`korean-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="korean-second-second-null"
                   v-model="koreanScores[3].score"
                   :checked="koreanScores[3].decided"
            >
            <label for="korean-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`korean-third-first-${k}`"
                   v-model="koreanScores[4].score"
                   :checked="koreanScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`korean-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="korean-third-first-null"
                   v-model="koreanScores[4].score"
                   :checked="koreanScores[4].decided"
            >
            <label for="korean-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, koreanScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>사회</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`society-first-first-${k}`"
                   v-model="societyScores[0].score"
                   :checked="societyScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`society-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="society-first-first-null"
                   v-model="societyScores[0].score"
                   :checked="societyScores[0].decided"
            >
            <label for="society-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`society-first-second-${k}`"
                   v-model="societyScores[1].score"
                   :checked="societyScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`society-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="society-first-second-null"
                   v-model="societyScores[1].score"
                   :checked="societyScores[1].decided"
            >
            <label for="society-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`society-second-first-${k}`"
                   v-model="societyScores[2].score"
                   :checked="societyScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`society-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="society-second-first-null"
                   v-model="societyScores[2].score"
                   :checked="societyScores[2].decided"
            >
            <label for="society-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`society-second-second-${k}`"
                   v-model="societyScores[3].score"
                   :checked="societyScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`society-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="society-second-second-null"
                   v-model="societyScores[3].score"
                   :checked="societyScores[3].decided"
            >
            <label for="society-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`society-third-first-${k}`"
                   v-model="societyScores[4].score"
                   :checked="societyScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`society-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="society-third-first-null"
                   v-model="societyScores[4].score"
                   :checked="societyScores[4].decided"
            >
            <label for="society-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, societyScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>역사</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`history-first-first-${k}`"
                   v-model="historyScores[0].score"
                   :checked="historyScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`history-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="history-first-first-null"
                   v-model="historyScores[0].score"
                   :checked="historyScores[0].decided"
            >
            <label for="history-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`history-first-second-${k}`"
                   v-model="historyScores[1].score"
                   :checked="historyScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`history-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="history-first-second-null"
                   v-model="historyScores[1].score"
                   :checked="historyScores[1].decided"
            >
            <label for="history-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`history-second-first-${k}`"
                   v-model="historyScores[2].score"
                   :checked="historyScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`history-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="history-second-first-null"
                   v-model="historyScores[2].score"
                   :checked="historyScores[2].decided"
            >
            <label for="history-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`history-second-second-${k}`"
                   v-model="historyScores[3].score"
                   :checked="historyScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`history-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="history-second-second-null"
                   v-model="historyScores[3].score"
                   :checked="historyScores[3].decided"
            >
            <label for="history-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`history-third-first-${k}`"
                   v-model="historyScores[4].score"
                   :checked="historyScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`history-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="history-third-first-null"
                   v-model="historyScores[4].score"
                   :checked="historyScores[4].decided"
            >
            <label for="history-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, historyScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>수학</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`math-first-first-${k}`"
                   v-model="mathScores[0].score"
                   :checked="mathScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`math-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="math-first-first-null"
                   v-model="mathScores[0].score"
                   :checked="mathScores[0].decided"
            >
            <label for="math-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`math-first-second-${k}`"
                   v-model="mathScores[1].score"
                   :checked="mathScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`math-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="math-first-second-null"
                   v-model="mathScores[1].score"
                   :checked="mathScores[1].decided"
            >
            <label for="math-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`math-second-first-${k}`"
                   v-model="mathScores[2].score"
                   :checked="mathScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`math-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="math-second-first-null"
                   v-model="mathScores[2].score"
                   :checked="mathScores[2].decided"
            >
            <label for="math-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`math-second-second-${k}`"
                   v-model="mathScores[3].score"
                   :checked="mathScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`math-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="math-second-second-null"
                   v-model="mathScores[3].score"
                   :checked="mathScores[3].decided"
            >
            <label for="math-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`math-third-first-${k}`"
                   v-model="mathScores[4].score"
                   :checked="mathScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`math-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="math-third-first-null"
                   v-model="mathScores[4].score"
                   :checked="mathScores[4].decided"
            >
            <label for="math-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, mathScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>과학</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`science-first-first-${k}`"
                   v-model="scienceScores[0].score"
                   :checked="scienceScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`science-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="science-first-first-null"
                   v-model="scienceScores[0].score"
                   :checked="scienceScores[0].decided"
            >
            <label for="science-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`science-first-second-${k}`"
                   v-model="scienceScores[1].score"
                   :checked="scienceScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`science-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="science-first-second-null"
                   v-model="scienceScores[1].score"
                   :checked="scienceScores[1].decided"
            >
            <label for="science-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`science-second-first-${k}`"
                   v-model="scienceScores[2].score"
                   :checked="scienceScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`science-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="science-second-first-null"
                   v-model="scienceScores[2].score"
                   :checked="scienceScores[2].decided"
            >
            <label for="science-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`science-second-second-${k}`"
                   v-model="scienceScores[3].score"
                   :checked="scienceScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`science-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="science-second-second-null"
                   v-model="scienceScores[3].score"
                   :checked="scienceScores[3].decided"
            >
            <label for="science-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`science-third-first-${k}`"
                   v-model="scienceScores[4].score"
                   :checked="scienceScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`science-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="science-third-first-null"
                   v-model="scienceScores[4].score"
                   :checked="scienceScores[4].decided"
            >
            <label for="science-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, scienceScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>기술・가정</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`tech-home-first-first-${k}`"
                   v-model="techAndHomeScores[0].score"
                   :checked="techAndHomeScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`tech-home-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="tech-home-first-first-null"
                   v-model="techAndHomeScores[0].score"
                   :checked="techAndHomeScores[0].decided"
            >
            <label for="tech-home-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`tech-home-first-second-${k}`"
                   v-model="techAndHomeScores[1].score"
                   :checked="techAndHomeScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`tech-home-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="tech-home-first-second-null"
                   v-model="techAndHomeScores[1].score"
                   :checked="techAndHomeScores[1].decided"
            >
            <label for="tech-home-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`tech-home-second-first-${k}`"
                   v-model="techAndHomeScores[2].score"
                   :checked="techAndHomeScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`tech-home-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="tech-home-second-first-null"
                   v-model="techAndHomeScores[2].score"
                   :checked="techAndHomeScores[2].decided"
            >
            <label for="tech-home-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`tech-home-second-second-${k}`"
                   v-model="techAndHomeScores[3].score"
                   :checked="techAndHomeScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`tech-home-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="tech-home-second-second-null"
                   v-model="techAndHomeScores[3].score"
                   :checked="techAndHomeScores[3].decided"
            >
            <label for="tech-home-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`tech-home-third-first-${k}`"
                   v-model="techAndHomeScores[4].score"
                   :checked="techAndHomeScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`tech-home-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="tech-home-third-first-null"
                   v-model="techAndHomeScores[4].score"
                   :checked="techAndHomeScores[4].decided"
            >
            <label for="tech-home-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, techAndHomeScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
        </tr>
        <tr class="grade-input-table__row">
          <td>영어</td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`english-first-first-${k}`"
                   v-model="englishScores[0].score"
                   :checked="englishScores[0].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`english-first-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[0])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="english-first-first-null"
                   v-model="englishScores[0].score"
                   :checked="englishScores[0].decided"
            >
            <label for="english-first-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[0])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`english-first-second-${k}`"
                   v-model="englishScores[1].score"
                   :checked="englishScores[1].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`english-first-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[1])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="english-first-second-null"
                   v-model="englishScores[1].score"
                   :checked="englishScores[1].decided"
            >
            <label for="english-first-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[1])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`english-second-first-${k}`"
                   v-model="englishScores[2].score"
                   :checked="englishScores[2].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`english-second-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[2])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="english-second-first-null"
                   v-model="englishScores[2].score"
                   :checked="englishScores[2].decided"
            >
            <label for="english-second-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[2])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`english-second-second-${k}`"
                   v-model="englishScores[3].score"
                   :checked="englishScores[3].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`english-second-second-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[3])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="english-second-second-null"
                   v-model="englishScores[3].score"
                   :checked="englishScores[3].decided"
            >
            <label for="english-second-second-null"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[3])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
          <td>
            <input type="radio"
                   v-for="k in scores"
                   :key="k"
                   :value="k.toUpperCase()"
                   :id="`english-third-first-${k}`"
                   v-model="englishScores[4].score"
                   :checked="englishScores[4].decided"
            >
            <label v-for="(k, index) in scores"
                   :key="index"
                   :for="`english-third-first-${k}`"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[4])"
            >
              {{ k.toUpperCase() }}
            </label>
            <div class="button-side-line"></div>
            <input type="radio"
                   value="X"
                   id="english-third-first-null"
                   v-model="englishScores[4].score"
                   :checked="englishScores[4].decided"
            >
            <label for="english-third-first-null"
                   class="input-grade-label"
                   @click="changeDecided($event, englishScores[4])"
            >X</label>
            <img src="../../assets/GradeInput/no-score.png"
                 alt="성적없음"
                 class="no-score-img"
            >
          </td>
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

      // 초기화 점수
      scores: ['a', 'b', 'c', 'd', 'e'],

      /* 점수 실제 설정 */
      // 국어
      koreanScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 사회
      societyScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 역사
      historyScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 수학
      mathScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 과학
      scienceScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 기술 - 가정
      techAndHomeScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],

      // 영어
      englishScores: [
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
        { score: '', decided: false, passed: false },
      ],
    };
  },
  computed: {
    grades() {
      const allGrades = [
        this.koreanScores,
        this.societyScores,
        this.historyScores,
        this.mathScores,
        this.scienceScores,
        this.techAndHomeScores,
        this.englishScores,
      ];

      return allGrades;
    },
  },
  methods: {
    movePrev() {
      this.$router.push('/');
    },

    moveNext() {
      this.$router.push('/');
    },

    // 초기화 버튼 설정
    setButton(t) {
      this.resetAllGrade = t.textContent.trim();
    },

    // 실제 점수 초기화
    setGrades() {
      const allGrades = this.grades;

      for (let i = 0; i < allGrades.length; i += 1) {
        for (let j = 0; j < allGrades[i].length; j += 1) {
          const resetAll = allGrades[i][j];
          // 초기화 - 점수 및 클릭 여부
          resetAll.score = this.resetAllGrade;
          resetAll.decided = true;
          resetAll.passed = true;
        }
      }
    },

    // 미이수 체크 해제
    resetDiscomplete() {
      const s = this.semesters;
      s.firstFirstSemester = false;
      s.firstSecondSemester = false;
      s.secondFirstSemester = false;
      s.secondSecondSemester = false;
      s.thirdFirstSemester = false;
    },

    resetGrade({ target }) {
      this.resetDiscomplete();
      this.setButton(target);
      this.setGrades();
    },

    // 미이수 설정
    discompleteSemester({ target }) {
      // 학기별 null로 초기화
      function reset(all, index) {
        for (let i = 0; i < all.length; i += 1) {
          const allScores = all[i];

          if (target.value === 'true') {
            allScores[index].score = '';
            allScores[index].passed = false;
            allScores[index].decided = false;
          } else {
            allScores[index].score = 'X';
            allScores[index].passed = false;
            allScores[index].decided = true;
          }
        }
      }
      // 학급 불러오기
      const allGrades = this.grades;

      switch (target.id) {
        case 'input-first-first':
          reset(allGrades, 0);
          break;
        case 'input-first-second':
          reset(allGrades, 1);
          break;
        case 'input-second-first':
          reset(allGrades, 2);
          break;
        case 'input-second-second':
          reset(allGrades, 3);
          break;
        case 'input-third-first':
          reset(allGrades, 4);
          break;
        default: break;
      }
    },

    // 점수를 눌렀을 시의 이벤트
    changeDecided({ target }, val) {
      const v = val;
      v.decided = !v.decided;
      v.passed = target.value === 'X' ? false : !v.passed;
      v.score = v.decided ? v.score : '';
    },
  },
  watch: {
    grades: {
      handler(val) {
        const gradeTable = this.$refs['grade-table'];
        const [,,, ...gradePart] = gradeTable.children;
        const compareArr = [];
        let pushTdArr = [];

        // computed의 grades와 1:1로 대응하기 위해 설정
        for (let i = 0; i < gradePart.length; i += 1) {
          const grade = gradePart[i];
          for (let j = 1; j < grade.children.length; j += 1) {
            pushTdArr.push(grade.children[j]);
          }

          compareArr.push(pushTdArr);
          pushTdArr = [];
        }

        console.log(compareArr);
      },
      deep: true,
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

  input[type=radio] {
    display: none;
  }

  button, .input-grade-label {
    border-radius: 50%;
    background-color: transparent;
    border: 0;
    cursor: pointer;
    outline: none;
    transition: background-color 0.3s;

    &:hover {
      background-color: $button-color;
    }
  }

  button {
    width: 20px;
    height: 20px;
    font-size: 14px;
  }

  .input-grade-label {
    width: 21px;
    height: 21px;
    font-size: 18px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    margin-right: 2px;
    transition: 0.5s;
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
          margin-left: 1px;

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
          font-size: 20px;
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

      // 버튼 스타일
      input[value="X"] + label{
        margin-left: 2px;

        &:hover + .no-score-img {
          opacity: 1;
        }
      }

      .no-score-img {
        width: 125px;
        height: 30px;
        object-fit: cover;
        position: absolute;
        opacity: 0;
        transition: opacity 0.3s;
        margin: {
          left: -76px;
          top: -34px;
        }
      }

      .button-side-line {
        width: 2px;
        height: 18px;
        background-color: #cfdee0;
        display: inline-flex;
        vertical-align: middle;
        position: relative;
        top: -1px;
      }
    }
  }
}
</style>
