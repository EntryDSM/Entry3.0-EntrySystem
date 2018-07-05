<template>
  <div class="login">
      <div class="login__title">
        <img
        class="login__title__entrylogo"
        src="./../../assets/entry_logo.png"
        alt="EntryDSM 로고">
      </div>
      <div class="login__inputs">
        <input type="text" class="modal--input" v-model="id" placeholder="아이디"/>
        <input type="password" class="modal--input" v-model="pw" placeholder="비밀번호"/>
        <div class="modal--btn" v-on:click="login">
          로그인
        </div>
      </div>
      <div class="login__links">
        <router-link to="auth">
          <span class="login__links__link">아직 원서작성을 시작하지 않으셨나요?</span>
        </router-link>
        <span class="login__links__link">비밀번호 재설정</span>
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
      } else {
        this.$axios.post('/login', { id, pw }).then(({ data }) => {
          if (data.type) {
            this.$cookies.set('JWT', data.token, '4d');
            this.$parent.$emit('CloseModal');
          } else {
            this.pw = '';
            this.pwwrong = true;
          }
        });
      }
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
    width: 100%;
    display: flex;
    justify-content: center;
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
</style>
