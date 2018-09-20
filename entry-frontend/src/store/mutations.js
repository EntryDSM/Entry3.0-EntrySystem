export const mutations = {
  updateGedScore: (state, payload) => {
    state.gradeInput.gedScore = payload;
  },
  updateVolunteerNAttendance: (state, { field, value }) => {
    state.gradeInput.volunteerNAttendance[field] = parseInt(value, 10);
  },
  updateGrades: (state, { grades, resetAllGrade }) => {
    const allGrades = grades;

    for (let i = 0; i < allGrades.length; i += 1) {
      for (let j = 0; j < allGrades[i].length; j += 1) {
        const resetAll = allGrades[i][j];
        // 초기화 - 점수 및 클릭 여부
        resetAll.score = resetAllGrade;
        resetAll.decided = true;
        resetAll.passed = true;
      }
    }
  },
  updateDiscompleteSemester: (state, { grades, target }) => {
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
    const allGrades = grades;

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
      case 'input-third-second':
        reset(allGrades, 5);
        break;
      default: break;
    }
  },
  updateChangeDecided: (state, { target, val }) => {
    const v = val;

    v.decided = !v.decided;
    v.passed = target.innerText === 'X' ? false : !v.passed;
    v.score = v.decided ? v.score : '';
  },
  updateIntroduce: (state, payload) => {
    state.introNPlan.introduce = payload;
  },
  updatePlan: (state, payload) => {
    state.introNPlan.plan = payload;
  },
  changeIndex: (state, payload) => {
    state.modal.index = payload.index;
  },
  updateAccept: (state, payload) => {
    state.auth.isAccept = payload;
  },
  updateEmail: (state, payload) => {
    state.auth.email = payload;
  },
  updatePw: (state, payload) => {
    state.auth.pw = payload;
  },
  updatePwCheck: (state, payload) => {
    state.auth.pwcheck = payload;
  },
  updateverify: (state, payload) => {
    state.auth.verify[payload.index] = payload.data;
  },
  updateisGED: (state, payload) => {
    state.classify.isGED = payload.data;
  },
  updateEntranceModel: (state, payload) => {
    state.classify.entranceModel = payload.data;
  },
  updateSocialOption: (state, payload) => {
    state.classify.socialOption = payload.data;
  },
  updateRegion: (state, payload) => {
    state.classify.region = payload.data;
  },
  updateIsGraduated: (state, payload) => {
    state.classify.isGraduated = payload.data;
  },
  updateGraduationYear: (state, payload) => {
    state.classify.graduationYear = payload.data;
  },
  updateSpecialPoints: (state, payload) => {
    state.classify.specialPoints = payload.data;
  },
  updateAdditionalType: (state, payload) => {
    state.classify.AdditionalType = payload.data;
  },
  updateGraduateType: (state, payload) => {
    state.classify.graduateType = payload.data;
  },
  // PersonalInformation
  updatePersonName: (state, payload) => {
    state.PersonInfo.PersonName = payload.data;
  },
  updateSex: (state, payload) => {
    state.PersonInfo.sex = payload.data;
  },
  updateYear: (state, payload) => {
    state.PersonInfo.year = payload.data;
  },
  updateMonth: (state, payload) => {
    state.PersonInfo.month = payload.data;
  },
  updateDay: (state, payload) => {
    state.PersonInfo.day = payload.data;
  },
  updateSchoolClass: (state, payload) => {
    state.PersonInfo.schoolClass = payload.data;
  },
  updateSchoolnumber: (state, payload) => {
    state.PersonInfo.schoolnumber = payload.data;
  },
  updateSchoolName: (state, payload) => {
    state.PersonInfo.schoolName = payload.data;
  },
  updateGuardianName: (state, payload) => {
    state.PersonInfo.guardianName = payload.data;
  },
  updateSchoolContact: (state, payload) => {
    state.PersonInfo.schoolContact = payload.data;
  },
  updateGuardianContact: (state, payload) => {
    state.PersonInfo.guardianContact = payload.data;
  },
  updateContact: (state, payload) => {
    state.PersonInfo.contact = payload.data;
  },
  updateZip: (state, payload) => {
    state.PersonInfo.zip = payload.data;
  },
  updateAddress: (state, payload) => {
    state.PersonInfo.address = payload.data;
  },
  updateDetailedAddress: (state, payload) => {
    state.PersonInfo.detailedAddress = payload.data;
  },
};

export default mutations;
