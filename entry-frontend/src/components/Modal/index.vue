<template>
  <div class="modal" v-if="index !== 0">
    <div class="modal__background" @click="closeModal"></div>
    <div class="modal__contants">
      <login v-if="index === 1"/>
    </div>
  </div>
</template>

<script>
import Login from './Login';

export default {
  name: 'Modal',
  components: {
    Login,
  },
  props: ['index'],
  methods: {
    closeModal() {
      this.$parent.$emit('CloseModal');
    },
  },
};
</script>

<style lang="scss">
@import '../../style/setting';
$M-input-background: #f9fbfc;
$M-input-placeholder: #acc6c9;
$M-input-color: #26484c;
$M-btn-background: #eff7f8;
$M-btn-color: #296169;
$M-modal-color: #5a8f97;
$M-error-color: #000;
$M-close-color: #dee8e9;

.modal{
  position: fixed;
  z-index: 9;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  @include e('background'){
    position: fixed;
    z-index: 10;
    width: 100%;
    height: 100%;
    background-color: rgba($color: #8C8C8C, $alpha: 0.3);
  }
  @include e('contants'){
    position: fixed;
    z-index: 11;
    width: 400px;
    height: 450px;
    background-color: #FFF;
    display: flex;
    justify-content: center;
    align-items: center;
    color: $M-modal-color;
  }
}

.modal--input{
    width: 231px;
    height: 14px;
    border-radius: 5px;
    background-color: $M-input-background;
    padding: 12px 0px 14px 19px;
    font-size: 14px;
    color: $M-input-color;
    border: 0;
    margin-top: 10px;
    &::placeholder{
      color: $M-input-placeholder;
      font-family: 'NanumSquareRound';
  }
}

.modal--btn{
  width: 250px;
  height: 40px;
  border-radius: 5px;
  background-color: $M-btn-background;
  color: $M-btn-color;
  text-align: center;
  line-height: 40px;
  margin-top: 10px;
  cursor: pointer;
  font-size: 14px;
}
.error-msg{
  animation: errormsg 4s normal;
  display: none;
}

.input-shake{
  animation: shake 0.82s cubic-bezier(.36,.07,.19,.97) both;
  transform: translate3d(0, 0, 0);
  backface-visibility: hidden;
  perspective: 1000px;
}
@keyframes shake {
  10%, 90% {
    transform: translate3d(-1px, 0, 0);
  }
  20%, 80% {
    transform: translate3d(2px, 0, 0);
  }
  30%, 50%, 70% {
    transform: translate3d(-4px, 0, 0);
  }
  40%, 60% {
    transform: translate3d(4px, 0, 0);
  }
}
@keyframes errormsg {
  0% {
    display: block;
    opacity: 0;
    position: relative;
    top: 30px;
  }
  10%{
    display: block;
    opacity: 1;
    position: relative;
    top: 0px;
  }
  75%{
    display: block;
    opacity: 1;
    position: relative;
    top: 0px;
  }
  99%{
    opacity: 0;
    position: relative;
    top: -30px;
  }
  100%{
    display: none;
  }
}
</style>
