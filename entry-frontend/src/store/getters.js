export const getters = {
  selectType(state) {
    const { graduateType } = state.classify;
    const {
      grade,
      volunteerNAttendance,
      korean,
      social,
      history,
      math,
      science,
      tech,
      english,
    } = state.gradeInput;

    // 경우: 검정고시, 졸업, 졸업 예정
    if (graduateType === 'GED') {
      return { grade };
    } else if (graduateType === 'DONE') {
      return {
        volunteerNAttendance,
        korean,
        social,
        history,
        math,
        science,
        tech,
        english,
        grades: [
          korean,
          social,
          history,
          math,
          science,
          tech,
          english,
        ],
      };
    } else if (graduateType === 'WILL') {
      /*
      const prop = 'thirdSecondSemester';
      const filteredSemesters = Object.keys(semesters).reduce((obj, key) => {
        const semesterObj = obj;
        if (key !== prop) {
          semesterObj[key] = semesters[key];
        }

        return obj;
      }, {});
      */

      return {
        volunteerNAttendance,
        korean: korean.slice(0, 5),
        social: social.slice(0, 5),
        history: history.slice(0, 5),
        math: math.slice(0, 5),
        science: science.slice(0, 5),
        tech: tech.slice(0, 5),
        english: english.slice(0, 5),
        grades: [
          korean.slice(0, 5),
          social.slice(0, 5),
          history.slice(0, 5),
          math.slice(0, 5),
          science.slice(0, 5),
          tech.slice(0, 5),
          english.slice(0, 5),
        ],
      };
    }

    return 'NONE TYPE';
  },
};

export default getters;
