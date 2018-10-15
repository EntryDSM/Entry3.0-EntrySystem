<template>
  <div></div>
</template>

<script>
/* eslint-disable */
import contact from './../../api/contact';

const emailReg = /^([0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*)(@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3})$/;
export default {
  props: [
    'code',
  ],
  created() {
    const { s, e } = this.$toastr;
    const isChrome = !!window.chrome && !!window.chrome.webstore;
    contact.confirmSignup(this.code).then((res) => {
        const { token, email } = res.data.data.accessToken;
        if (!isChrome) {
          alert('인증이 완료되었습니다. 크롬환경에서 다시 접속해주세요 :)');
          window.location.href = 'https://www.google.com/intl/ko_ALL/chrome/';
          return;
        }
        alert('인증이 완료되었습니다. 입력하신 정보로 로그인 해주세요.');
        this.$router.push('/');
    }).catch((error) => {
      e(error.response.data.errors[0].message);
      this.$router.push('/');
    });
  },
};
</script>
