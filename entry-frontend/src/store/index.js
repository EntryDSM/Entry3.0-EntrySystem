import vue from 'vue';
import vuex from 'vuex';
import { state } from './state';
import { actions } from './actions';
import { mutations } from './mutations';
import { getters } from './getters';
// import _ from 'lodash';

vue.use(vuex);

const store = () => new vuex.Store({
  state,
  actions,
  mutations,
  getters,
});

export default store;
