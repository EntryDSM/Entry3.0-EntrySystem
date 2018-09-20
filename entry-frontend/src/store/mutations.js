import axios from 'axios';

export const mutations = {
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
  updateClassify: (state, payload) => {
    axios.get('로컬호스트/api/me/classification',
      { headers: { Authorization: `JWT ${payload.token}` } },
    ).then((res) => {
      if (res.status === 200) {
        const {
          data,
        } = res;
        const {
          graduateType,
          admission,
          admissionDetail,
          region,
          graduateYear,
          additionalType,
        } = data;
        if (graduateType === 'GED') {
          state.classify.isGED = true;
        }
        state.classify.graduateType = graduateType;
        state.classify.entranceModel = admission;
        switch (admissionDetail) {
          case 'BENEFICIARY' :
            state.classify.socialOption = { text: '기초생활수급권자', value: admissionDetail };
            break;
          case 'ONE_PARENT' :
            state.classify.socialOption = { text: '한부모가족 보호대상자', value: admissionDetail };
            break;
          case 'CHA_UPPER':
            state.classify.socialOption = { text: '차상위 계층', value: admissionDetail };
            break;
          case 'CHACHA_UPPER' :
            state.classify.socialOption = { text: '차차상위 계층', value: admissionDetail };
            break;
          case 'FROM_NORTH' :
            state.classify.socialOption = { text: '북한이탈주민', value: admissionDetail };
            break;
          case 'MULTI_CULTURE' :
            state.classify.socialOption = { text: '다문화 가정', value: admissionDetail };
            break;
          case 'ETC' :
            state.classify.socialOption = { text: '그 외 대상자', value: admissionDetail };
            break;
          case 'NONE':
            state.classify.socialOption = { text: '', value: 'NONE' };
            break;
          default:
            state.classify.socialOption = { text: '서버에서 오류가 났습니다.', value: 'ERROR' };
        }
        state.classify.socialOption.value = admissionDetail;
        state.classify.region = region;
        state.classify.graduateYear = graduateYear;
        state.classify.AdditionalType = additionalType;
      }
    });
  },
};

export default mutations;
