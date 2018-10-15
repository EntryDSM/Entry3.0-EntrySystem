<template>
  <div class="branchModal">
    <div class="branchModal__btn" @click="gotoLogin">
      <div class="branchModal__btn__title branchModal__btn__title--left">
      원서 수정하기
      </div>
      <div class="branchModal__btn__contents branchModal__btn__contents--right">
        작성중인 원서가<br/>
        있으신가요?
      </div>
    </div>
      <div class="branchModal__btn" @click="gotoAuth">
        <div class="branchModal__btn__contents branchModal__btn__contents--left">
          아직<br/>
          원서작성을<br/>
          시작하지 않으셨나요?<br/>
        </div>
        <div class="branchModal__btn__title branchModal__btn__title--right">
          원서 작성하기
        </div>
      </div>
  </div>
</template>

<script>
export default {
  methods: {
    gotoLogin() {
      this.$store.commit('changeIndex', {
        index: 1,
      });
    },
    gotoAuth() {
      this.$store.commit('changeIndex', {
        index: 0,
      });
      this.$router.push('/auth');
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
.branchModal{
  width: calc(100% - 50px);
  height: calc(100% - 50px);
  padding: 25px;
  font-family: 'NanumSquareR';
  @include e('btn') {
    position: relative;
    cursor: pointer;
    width: 410px;
    height: 75px;
    border-radius: 6px;
    border: solid 1px #dfecee;
    background-color: #f9fdfd;
    padding: 20px;
    transition: 0.5s;
    margin-bottom: 20px;
    &:hover{
      background-color: #ecf7f7;
    }
    @include e('title') {
      position: absolute;
      font-size: 24px;
      color: #3e6d73;
      @include m('left') {
        left: 20px;
        bottom: 20px;
      }
      @include m('right') {
        top: 20px;
        right: 20px;
      }
    }
    @include e('contents') {
      font-family: NanumSquareR;
      font-size: 20px;
      line-height: 1.25;
      color: #a9c9cd;
      @include m('right') {
        right: 20px;
        bottom: 20px;
        text-align: right;
      }
      @include m('left') {
        bottom: 20px;
        left: 20px;
      }
    }
  }
}
a:link{
  color: #000;
  text-decoration: none;
}
a:visited{
  color: #000;
  text-decoration: none;
}
a:hover{
  color: #000;
  text-decoration: none;
}
a:active{
  color: #000;
  text-decoration: none;
}
</style>
