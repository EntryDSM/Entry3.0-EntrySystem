export const mutations = {
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
