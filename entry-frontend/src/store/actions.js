export const actions = {
  // modal 관련 이벤트
  changeIndex: context => context.commit('changeIndex'),
  // auth 관련 action
  updateAccept: context => context.commit('updateAccept'),
  updateEmail: context => context.commit('updateEmail'),
  updatePw: context => context.commit('updateEmail'),
  updatePwCheck: context => context.commit('updateEmail'),
  updateverify: context => context.commit('updateverify'),
  // classify 관련 action
  updateisGED: context => context.commit('updateisGED'),
  updateEntranceModel: context => context.commit('updateEntranceModel'),
  updateSocialOption: context => context.commit('updateSocialOption'),
  updateRegion: context => context.commit('updateRegion'),
  updateIsGraduated: context => context.commit('updateIsGraduated'),
  updateGraduationYear: context => context.commit('updateGraduationYear'),
  updateAdditionalType: context => context.commit('updateAdditionalType'),
  updateGraduateType: context => context.commit('updateGraduateType'),
  // PersonInfo 관련 action
  updatePersonName: context => context.commit('updatePersonName'),
  updateSex: context => context.commit('updateSex'),
  updateYear: context => context.commit('updateYear'),
  updateMonth: context => context.commit('updateMonth'),
  updateDay: context => context.commit('updateDay'),
  updateSchoolClass: context => context.commit('updateSchoolClass'),
  updateSchoolnumber: context => context.commit('updateSchoolnumber'),
  updateSchoolName: context => context.commit('updateSchoolName'),
  updateParentName: context => context.commit('updateParentName'),
  updateSchoolContact: context => context.commit('updateSchoolContact'),
  updateParentContact: context => context.commit('updateParentContact'),
  updateContact: context => context.commit('updateContact'),
  updateZip: context => context.commit('updateZip'),
  updateAddress: context => context.commit('updateAddress'),
  updateDetailedAddress: context => context.commit('updateDetailedAddress'),
  updateImgPath: context => context.commit('updateImgPath'),
};

export default actions;
