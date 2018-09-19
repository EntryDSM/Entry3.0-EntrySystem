<template>
  <div class="login">
      <div class="login__title">
        <img
        class="login__title__entrylogo"
        src="./../../assets/entry_logo.png"
        alt="EntryDSM 로고"
        v-if="logoAnimation">
        <img
        class="login__title__entrylogo logo-error"
        src="./../../assets/entry_logo.png"
        alt="EntryDSM 로고"
        v-else>
        <span class="error-msg" v-if="(idwrong && !pwwrong)">이메일을 다시 확인해주세요</span>
        <span class="error-msg" v-if="(!idwrong && pwwrong)">비밀번호를 다시 확인해주세요</span>
        <span class="error-msg" v-if="(idwrong && pwwrong)">이메일과 비밀번호를 다시 확인해주세요</span>
      </div>
      <div class="login__inputs">
        <input type="text" class="modal--input input-shake"
        v-if="idwrong" v-model="id" placeholder="아이디"/>
        <input type="text" class="modal--input" v-else v-model="id" placeholder="아이디"/>
        <input type="password" class="modal--input input-shake"
        v-if="pwwrong" v-model="pw" placeholder="비밀번호"/>
        <input type="password" class="modal--input" v-else v-model="pw" placeholder="비밀번호"/>
        <div class="modal--btn" v-on:click="login">
          로그인
        </div>
      </div>
      <div class="login__links">
        <span class="login__links__link" @click="closeModal">아직 원서작성을 시작하지 않으셨나요?</span>
        <span class="login__links__link" @click="changeIndex">비밀번호 재설정</span>
      </div>
  </div>
</template>

<script>
export default {
  data: () => ({
    id: '',
    pw: '',
    idwrong: false,
    pwwrong: false,
  }),
  methods: {
    login() {
      const id = this.id;
      const pw = this.pw;
      if (id === '') {
        this.idwrong = true;
        this.pwwrong = false;
        setTimeout(() => {
          this.idwrong = false;
        }, 5000);
      } else if (pw === '') {
        this.pwwrong = true;
        this.idwrong = false;
        setTimeout(() => {
          this.pwwrong = false;
        }, 5000);
      } else {
        this.$axios.post('/login', { id, pw }).then(({ data }) => {
          if (data.type) {
            this.$cookies.set('JWT', data.token, '4d');
            this.$store.commit('changeIndex', {
              index: 0,
            });
          } else {
            this.pw = '';
            this.pwwrong = true;
            this.idwrong = false;
            setTimeout(() => {
              this.pwwrong = false;
            }, 5000);
          }
        });
      }
    },
    changeIndex() {
      this.$store.commit('changeIndex', {
        index: 2,
      });
    },
    closeModal() {
      this.$store.commit('changeIndex', {
        index: 0,
      });
      this.$router.push({ path: '/auth' });
    },
  },
  computed: {
    logoAnimation() {
      if (this.idwrong || this.pwwrong) {
        return false;
      }
      return true;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
.login{
  width: 250px;
  height: 284px;
  @include e(title){
    position: relative;
    width: 100%;
    display: flex;
    height: 64px;
    justify-content: center;
    align-items: center;
    font-size: 14px;
    color: #000;
    @include e(entrylogo){
      height: 64px;
    }
  }
  @include e(inputs){
    margin: 12px 0 22px 0;
  }
  @include e(links){
    text-align: center;
    & a{
      text-decoration: none;
      &:visited{
        color: #5a8f97;
      }
    }
    @include e(link){
      display: block;
      font-size: 12px;
      margin-bottom: 10px;
      cursor: pointer;
    }
  }
}
.logo-error{
  position: relative;
  animation: errorlogo 4s normal;
}
@keyframes errorlogo {
  0% {
    display: none;
    opacity: 0;
    top: 30px;
  }
  75%{
    display: none;
    opacity: 0;
    top: 30px;
  }
  100%{
    display: block;
    opacity: 1;
    top: 0px;
  }
}
</style>
