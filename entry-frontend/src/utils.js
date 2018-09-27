const utilsOfGrade = {
  // 보낼 성적 값 필터링
  sendGrade: (grade, grades, graduateType, volunteerNAttendance) => {
    const gradeArr = [];
    const typeCount = graduateType === 'DONE' ? 6 : 5;
    const semesters = [
      'korean',
      'social',
      'history',
      'math',
      'science',
      'tech',
      'english',
    ];
    let gradeObj = {};

    for (let type = 0; type < typeCount; type += 1) {
      for (let idx = 0; idx < grades.length; idx += 1) {
        const score = grades[idx][type].score;

        Object.assign(gradeObj, {
          [semesters[idx]]: score === '' ? null : score,
        });
      }

      gradeArr.push(gradeObj);
      gradeObj = {};
    }

    const sendForm = Object.assign(volunteerNAttendance, {
      grades: gradeArr,
      grade,
    });

    return sendForm;
  },

  getGrade: () => 'Hello',
};

export default utilsOfGrade;
