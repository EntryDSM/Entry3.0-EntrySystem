<template>
  <ul class="social-option">
    <li class="social-option__item">
    </li>
    <li class="social-option__item social-option__item--focused">
    </li>
    <li class="social-option__item social-option__item--hover">
    </li>
  </ul>
</template>

<script>
export default {
  name: 'social-option',
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.social-option {
  width: 250px;
  height: 279px;
  background-color: #ffffff;
  border: solid 1px #7b9fa2;
  @include e('item') {
    width: 250px;
    height: 40px;
    box-sizing: border-box;
    border: {
      bottom: solid 1px #9bb6b9;
    }
    @include m('hover') {
      background-color: #f7fbfc;
    }
  }
}
</style>
