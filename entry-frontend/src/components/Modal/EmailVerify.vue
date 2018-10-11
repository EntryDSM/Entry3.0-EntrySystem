<template>
  <div class="ChangeSuccess">
    <lottie :options="defaultOptions" :height="200" :width="200" v-on:animCreated="handleAnimation"/>
    <div class="ChangeSuccess__email">[ {{email}} ]</div>
    <div class="ChangeSuccess__division"></div>
    <div class="ChangeSuccess__contents">
      비밀번호 재설정이 완료되었습니다
    </div>
    <div class="modal--btn" @click="goLogin">
      로그인
    </div>
  </div>
</template>

<script>
import Lottie from 'vue-lottie';
import * as animationData from './../../../assets/checkAnimation.json';

export default {
  props: ['email'],
  components: {
    Lottie,
  },
  methods: {
    goLogin() {
      this.$store.commit('changeIndex', {
        index: 1,
      });
    },
    handleAnimation(anim) {
      this.anim = anim;
    },
  },
  data() {
    return {
      defaultOptions: {
        animationData,
        loop: false,
      },
      animationSpeed: 1,
    };
  },
};
</script>

<style lang="scss" scoped>
@import '../../../style/setting';
.ChangeSuccess{
  @include e('email'){
    font-size: 18px;
    color: #000000;
    font-weight: 400;
    width: 100%;
    text-align: center;
  }
  @include e('division'){
    margin: 15px auto;
    width: 100px;
    height: 1px;
    background-color: #70b1ba;
  }
  @include e('contents'){
    font-size: 12px;
    line-height: 1.25;
    color: #000000;
    text-align: center;
    font-weight: 300;
  }
}
.modal--btn{
  margin-top: 15px;
}
</style>

