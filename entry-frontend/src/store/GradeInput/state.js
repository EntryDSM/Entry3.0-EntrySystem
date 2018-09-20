export const GradeInput = {
  /* 검정고시 관련 */
  gedScore: 0,

  /* 졸업 예정, 졸업자 관련 */

  // 봉사 및 출석
  volunteerNAttendance: {
    volunteer: 0,
    absence: 0,
    earlyLeave: 0,
    lateness: 0,
    missingClass: 0,
  },

  // 국어
  koreanScores: [
    { score: '', decided: false, passed: false },
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
    { score: '', decided: false, passed: false },
  ],

  // 역사
  historyScores: [
    { score: '', decided: false, passed: false },
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
    { score: '', decided: false, passed: false },
  ],

  // 과학
  scienceScores: [
    { score: '', decided: false, passed: false },
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
    { score: '', decided: false, passed: false },
  ],

  // 영어
  englishScores: [
    { score: '', decided: false, passed: false },
    { score: '', decided: false, passed: false },
    { score: '', decided: false, passed: false },
    { score: '', decided: false, passed: false },
    { score: '', decided: false, passed: false },
    { score: '', decided: false, passed: false },
  ],
};

export default GradeInput;
