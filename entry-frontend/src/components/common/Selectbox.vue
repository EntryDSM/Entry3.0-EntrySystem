<template>
  <div class="selectbox" :class="{'selectbox--focused': isFocused}">
    <div class="selectbox__current-value" @click="toggleOption">
      {{ value || disabledText }}
    </div>
    <div class="selectbox__wrapper">
      <ul class="selectbox__wrapper__option">
        <li class="selectbox__wrapper__option__line"></li>
        <li class="selectbox__wrapper__option__value"
          v-for="(option, index) in options" :key="option.value"
          :class="{'selectbox__wrapper__option__value--selected': selected === index}"
          @click="changeValue(option.value, index)">
          {{ option.text }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'selectbox',
  props: {
    disabledText: {
      type: String,
      default: '선택',
    },
    options: {
      type: Array,
      required: true,
    },
    value: {
      type: Number,
      required: true,
    },
  },
  data() {
    return {
      isFocused: false,
      selected: 0,
    };
  },
  methods: {
    toggleOption() {
      this.isFocused = !this.isFocused;
    },
    changeValue(value, index) {
      this.selected = index;
      this.value = value;
      this.$emit('input', this.value);
      this.isFocused = false;
    },
  },
  created() {
    for (let i = 0; i < this.options.length; i += 1) {
      this.selected = this.options[i].value === this.value ? i : -1;
    }
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting.scss';
$border-color: #8aaaad;

// 셀렉트 박스 공통 스타일
.selectbox {
  user-select:none;
  display: inline-block;
  box-sizing: border-box;
  font-size: 18px;
  line-height: 19px;
  height: 40px;
  background-color: #fff;
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
    border: solid 1px $border-color;
    box-sizing: border-box;
    height: 100%;
    width: 100%;
    border-radius: 5px;
    position: relative;
    z-index: 1;
    padding: {
      left: 16px;
      top: 11px;
      bottom: 10px;
    }
  }
  @include e('wrapper') {
    background-color: #fff;
    display: none;
    width: 100%;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    box-sizing: border-box;
    position: absolute;
    z-index: 1;
    top: 100%;
    left: 0;
    padding: {
      bottom: 12px;
    }
    border: {
      left: solid 1px $border-color;
      right: solid 1px $border-color;
      bottom: solid 1px $border-color;
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
      max-height: 148px;
      @include e('line') {
        margin-left: 13px;
        width: calc(100% - 26px);
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
          top: 4px;
          bottom: 4px;
        }
        box-sizing: border-box;
        &:hover {
          color: #2a4649;
          background-color: #e4ebeb;
        }
        @include m('selected') {
          color: #2a4649;
          background-color: #e4ebeb;
        }
      }
    }
  }
}
</style>
