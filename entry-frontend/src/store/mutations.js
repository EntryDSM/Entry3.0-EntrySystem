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
  updateadmission: (state, payload) => {
    state.classify.admission = payload.data;
  },
  updateadmissionDetail: (state, payload) => {
    state.classify.admissionDetail = payload.data;
  },
  updateRegion: (state, payload) => {
    state.classify.region = payload.data;
  },
  updateIsGraduated: (state, payload) => {
    state.classify.isGraduated = payload.data;
  },
  updategraduateYear: (state, payload) => {
    state.classify.graduateYear = payload.data;
  },
  updateSpecialPoints: (state, payload) => {
    state.classify.specialPoints = payload.data;
  },
  updateadditionalType: (state, payload) => {
    state.classify.additionalType = payload.data;
  },
  updateGraduateType: (state, payload) => {
    state.classify.graduateType = payload.data;
  },
  // PersonalInformation
  updatePersonName: (state, payload) => {
    state.PersonInfo.personName = payload.data;
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
  updateStudentClass: (state, payload) => {
    state.PersonInfo.studentClass = payload.data;
  },
  updateStudentNumber: (state, payload) => {
    state.PersonInfo.studentNumber = payload.data;
  },
  updateSchoolName: (state, payload) => {
    state.PersonInfo.schoolName = payload.data;
  },
  updateParentName: (state, payload) => {
    state.PersonInfo.parentName = payload.data;
  },
  updateSchoolTel: (state, payload) => {
    state.PersonInfo.schoolTel = payload.data;
  },
  updateParentTel: (state, payload) => {
    state.PersonInfo.parentTel = payload.data;
  },
  updateMyTel: (state, payload) => {
    state.PersonInfo.myTel = payload.data;
  },
  updateZipCode: (state, payload) => {
    state.PersonInfo.zipCode = payload.data;
  },
  updateAddressBase: (state, payload) => {
    state.PersonInfo.addressBase = payload.data;
  },
  updateAddressDetail: (state, payload) => {
    state.PersonInfo.addressDetail = payload.data;
  },
  updateImgPath: (state, payload) => {
    state.PersonInfo.imgPath = payload.data;
  },
  updateClassify: (state, payload) => {
    axios.get('http://10.156.145.173:8080/api/me/classification',
      { headers: { Authorization: `JWT ${payload.token}` } },
    ).then((res) => {
      if (res.status === 200) {
        const {
          graduateType,
          admission,
          admissionDetail,
          region,
          graduateYear,
          additionalType,
        } = res.data.data;
        if (graduateType === 'GED') {
          state.classify.isGED = true;
        }
        state.classify.graduateType = graduateType;
        state.classify.admission = admission;
        switch (admissionDetail) {
          case 'BENEFICIARY' :
            state.classify.admissionDetail = { text: '기초생활수급권자', value: admissionDetail };
            break;
          case 'ONE_PARENT' :
            state.classify.admissionDetail = { text: '한부모가족 보호대상자', value: admissionDetail };
            break;
          case 'CHA_UPPER':
            state.classify.admissionDetail = { text: '차상위 계층', value: admissionDetail };
            break;
          case 'CHACHA_UPPER' :
            state.classify.admissionDetail = { text: '차차상위 계층', value: admissionDetail };
            break;
          case 'FROM_NORTH' :
            state.classify.admissionDetail = { text: '북한이탈주민', value: admissionDetail };
            break;
          case 'MULTI_CULTURE' :
            state.classify.admissionDetail = { text: '다문화 가정', value: admissionDetail };
            break;
          case 'ETC' :
            state.classify.admissionDetail = { text: '그 외 대상자', value: admissionDetail };
            break;
          case 'NONE':
            state.classify.admissionDetail = { text: '', value: 'NONE' };
            break;
          default:
            state.classify.admissionDetail = { text: '서버에서 오류가 났습니다.', value: 'ERROR' };
        }
        state.classify.admissionDetail.value = admissionDetail;
        state.classify.region = region;
        state.classify.graduateYear = graduateYear;
        state.classify.additionalType = additionalType;
      }
    });
  },
  updateaccessToken: (state, payload) => {
    state.accessToken = payload.data;
  },
};

export default mutations;
