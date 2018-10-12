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
        this.$cookies.set('accessToken', token, '4d');
        this.$store.dispatch('getClassify', { token });
        this.$store.dispatch('getInfo', { token });
        this.$store.dispatch('getGrades', { token });
        this.$store.dispatch('getIntro', { token });
        this.$store.commit('updateaccessToken', {
          accessToken: token,
          email: email.replace(emailReg, '$1'),
        });
        localStorage.setItem('name', email.replace(emailReg, '$1'));
        this.$store.dispatch('getMypage', {
          token,
        });
        this.$store.commit('changeIndex', {
          index: 0,
        });
        s('인증이 완료되었습니다.');
        s('로그인 성공.');
        this.$router.push('/classify');
    }).catch((error) => {
      e(error.response.data.errors[0].message);
      this.$router.push('/');
    });
  },
};
</script>
