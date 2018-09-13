export const actions = {
  // modal 관련 이벤트
  changeIndex: context => context.commit('changeIndex'),
  // auth 관련 action
  updateAccept: context => context.commit('updateAccept'),
  updateEmail: context => context.commit('updateEmail'),
  updatePw: context => context.commit('updateEmail'),
  updatePwCheck: context => context.commit('updateEmail'),
  updateverify: context => context.commit('updateverify'),
};

export default actions;
