export const getters = {
  selectType(state) {
    const { graduateType } = state.classify;
    const {
      gedScore,
      volunteerNAttendance,
      semesters,
      koreanScores,
      societyScores,
      historyScores,
      mathScores,
      scienceScores,
      techAndHomeScores,
      englishScores,
    } = state.gradeInput;

    // 경우: 검정고시, 졸업, 졸업 예정
    if (graduateType === 'GED') {
      return { gedScore };
    } else if (graduateType === 'DONE') {
      return {
        volunteerNAttendance,
        semesters,
        koreanScores,
        societyScores,
        historyScores,
        mathScores,
        scienceScores,
        techAndHomeScores,
        englishScores,
        grades: [
          koreanScores,
          societyScores,
          historyScores,
          mathScores,
          scienceScores,
          techAndHomeScores,
          englishScores,
        ],
      };
    } else if (graduateType === 'WILL') {
      const prop = 'thirdSecondSemester';
      const filteredSemesters = Object.keys(semesters).reduce((obj, key) => {
        const semesterObj = obj;
        if (key !== prop) {
          semesterObj[key] = semesters[key];
        }

        return obj;
      }, {});

      return {
        volunteerNAttendance,
        semesters: filteredSemesters,
        koreanScores: koreanScores.slice(0, 5),
        societyScores: societyScores.slice(0, 5),
        historyScores: historyScores.slice(0, 5),
        mathScores: mathScores.slice(0, 5),
        scienceScores: scienceScores.slice(0, 5),
        techAndHomeScores: techAndHomeScores.slice(0, 5),
        englishScores: englishScores.slice(0, 5),
        grades: [
          koreanScores.slice(0, 5),
          societyScores.slice(0, 5),
          historyScores.slice(0, 5),
          mathScores.slice(0, 5),
          scienceScores.slice(0, 5),
          techAndHomeScores.slice(0, 5),
          englishScores.slice(0, 5),
        ],
      };
    }

    return 'NONE TYPE';
  },
};

export default getters;
