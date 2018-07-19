<template>
  <div class="PwReset">
    <div class="PwReset__title modal-title">
      비밀번호 재설정
    </div>
    <span class="PwReset__text --title">메일함에 전송된 인증번호를 입력해주세요</span>
    <input type="text" class="modal--input PwReset__input"
    v-if="notInput" v-model="certify" placeholder="••••••" maxlength="6"/>
    <input type="text" class="modal--input PwReset__input input-shake"
    v-else v-model="certify" placeholder="••••••" maxlength="6"/>
    <div class="PwReset__btns">
      <div class="modal--btn PwReset__btns__btn" v-on:click="reset">
        다시 입력
      </div>
      <div class="modal--btn PwReset__btns__btn" v-on:click="Resend">
        재전송
      </div>
      <div class="modal--btn PwReset__btns__btn --last" v-on:click="Verify">
        확인
      </div>
    </div>
    <span class="PwReset__text --hint">이메일이 오지 않습니다</span>
    <div class="PwReset__text --hint__hover">
      <div class="PwReset__text --hint__hover__bubble">
        {{email}}
        <div class="PwReset__text --hint__hover__bubble__text">
          위의 메일 주소가 맞는지 다시 한 번 확인하시고,<br/>
          스팸 메일함도 확인해주세요.
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: () => ({
    certify: '',
    notInput: false,
  }),
  props: ['email'],
  methods: {
    Verify() {
      const certify = this.certify;
      if (certify === '') {
        this.notInput = true;
        setTimeout(() => {
          this.notInput = false;
        }, 1500);
      } else {
        this.$store.commit('changeIndex', {
          index: 4,
        });
        // axios 부분
        /*
          this.$axios.post('/Certify', { certify }).then(({ data }) => {
            if (data.type) {
            } else {
              this.notInput = true;
              setTimeout(() => {
                this.notInput = false;
              }, 2000);
            }
          });
        */
      }
    },
    reset() {
      this.certify = '';
    },
    Resend() {
    // axios 부분
    /*
      this.$axios.post('/Resend', { certify }).then(({ data }) => {
          if (data.type) {
          } else {
            this.notInput = true;
          setTimeout(() => {
            this.notInput = false;
          }, 2000);
        }
      });
    */
      console.log('재전송');
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../../style/setting';

.PwReset{
  @include e('text'){
    display: block;
    margin: 34px 0 14px 0;
    font-size: 12px;
    text-align: center;
    &.--title{
      color: #000;
    }
    &.--hint{
      margin-top: 16px;
      color: #5a8f97;
      cursor: pointer;
      @m
    }
  }
  @include e('input'){
    width: 250px;
    padding: 13px 0 13px 0;
    text-align: center;
    margin-bottom: 10px;
    letter-spacing: 10px;
  }
  @include e('btns'){
    @include e('btn'){
      display: inline-block;
      width: 77px;
      margin-right: 6px;
      &.--last{
        margin-right: 0;
      }
    }
  }
}

@keyframes openmsg {
  0%{
    top: 40px;
    opacity: 0;
  }
  90%{
    top: -5px;
    opacity: 1;
  }
  100%{
    top: 0;
  }
}
</style>
