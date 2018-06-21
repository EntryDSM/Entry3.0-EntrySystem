<template>
  <ul class="social-option">
    <li class="social-option__item"
      v-for="(option, index) in options"
      :key="index"
      :class="{'social-option__item--focused': selected == option.value}"
      @click="select(option.value)">
      {{ option.text }}
    </li>
  </ul>
</template>

<script>
export default {
  name: 'social-option',
  props: {
    options: {
      type: Array,
    },
  },
  data() {
    return {
      selected: 0,
    };
  },
  methods: {
    select(value) {
      this.selected = value;
      this.$emit('input', value);
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.social-option {
  position: absolute;
  z-index: 2;
  top: 60px;
  left: 0;
  width: 250px;
  background-color: #ffffff;
  border: solid 1px #7b9fa2;
  @include e('item') {
    width: 250px;
    height: 40px;
    box-sizing: border-box;
    font-size: 16px;
    line-height: 40px;
    position: relative;
    border: {
      bottom: solid 1px #9bb6b9;
    }
    padding: {
      left: 20px;
    }
    &::after {
      font-size: 18px;
      position: absolute;
      right: 20px;
      color: #709ea2;
    }
    &:hover {
      background-color: #d0e5ea;
      &::after {
        content: '〉';
      }
    }
    &:last-child {
      border: none;
    }
    @include m('focused') {
      background-color: #f7fbfc;
      &::after {
        content: '✓';
      }
      &:hover {
        background-color: #f7fbfc;
        &::after {
          content: '✓';
        }
      }
    }
  }
}
</style>
