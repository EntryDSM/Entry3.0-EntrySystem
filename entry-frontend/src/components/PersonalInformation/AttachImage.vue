<template>
  <div class="attach-image">
    <label class="attach-image__label">
    </label>
  </div>
</template>

<script>
export default {
  name: 'attach-image',
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.attach-image {
  width: 315px;
  height: 375px;
  background-color: #fff;
  box-sizing: border-box;
  border: {
    left: 1px solid #eff3f4;
    bottom: 1px solid #eff3f4;
  }
  padding: {
    left: 17px;
    right: 5px;
    top: 20px;
    bottom: 15px;
  }
  @include e('label') {
    width: 100%;
    height: 100%;
    display: block;
    box-sizing: border-box;
    background-color: #f7fbfc;
    border: solid 0.5px #8aaaad;
  }
}

</style>
