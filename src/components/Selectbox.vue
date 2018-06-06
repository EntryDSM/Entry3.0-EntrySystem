<template>
  <div class="selectbox" :class="{'selectbox--focused': isFocused}">
    <div class="selectbox__current-value" @click="openOption">2018</div>
    <div class="selectbox__wrapper">
      <ul class="selectbox__wrapper__option">
        <li class="selectbox__wrapper__option__line"></li>
        <li class="selectbox__wrapper__option__value"
          v-for="value in 10"
          :key="value"
        >2017</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'selectbox',
  data() {
    return {
      isFocused: true,
    };
  },
  methods: {
    openOption() {
      this.isFocused = !this.isFocused;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../style/setting.scss';

// 셀렉트 박스 공통 스타일
.selectbox {
  box-sizing: border-box;
  font-size: 18px;
  line-height: 19px;
  height: 40px;
  width: 150px;
  color: #000;
  text-align: left;
  position: relative;
  @include m('focused') {
    & .selectbox {
      @include e('current-value') {
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 0;
        border-bottom: none;
      }
      @include e('wrapper') {
        display: block;
      }
    }
  }
  @include e('current-value') {
    border: solid 1px #8aaaad;
    box-sizing: border-box;
    height: 100%;
    width: 100%;
    border-radius: 5px;
    padding: {
      left: 16px;
      top: 11px;
      bottom: 10px;
    }
  }
  @include e('wrapper') {
    display: none;
    width: 100%;
    height: 160px;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    box-sizing: border-box;
    position: absolute;
    top: 100%;
    left: 0;
    padding: {
      bottom: 12px;
    }
    border: {
      left: solid 1px #8aaaad;
      right: solid 1px #8aaaad;
      bottom: solid 1px #8aaaad;
    }
    @include e('option') {
      box-sizing: border-box;
      overflow-x: hidden;
      overflow-y: scroll;
      &::-webkit-scrollbar {
        display: none;
      }
      width: 100%;
      height: 100%;
      @include e('line') {
        margin-left: 13px;
        width: 125px;
        height: 2px;
        background-color: #eff3f4;
        margin-bottom: 3px;
      }
      @include e('value') {
        color: #5b6c6e;
        box-sizing: border-box;
        width: 100%;
        padding: {
          left: 16px;
          top: 3px;
          bottom: 3px;
        }
        margin: {
          top: 2px;
        }
        box-sizing: border-box;
        &:hover {
          color: #2a4649;
          background-color: #e4ebeb;
        }
      }
    }
  }
}
</style>
