<template>
  <div class="headline">
    <h4 class="headline__school-information">{{ schoolName }}</h4>
    <h1 class="headline__title">
      {{ title }}
    </h1>
  </div>
</template>

<script>
export default {
  name: 'Headline',
  props: {
    title: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      schoolName: '대덕소프트웨어마이스터고등학교',
    };
  },
};
</script>

<style scoped lang="scss">
@import '../style/setting';

.headline {
  padding-top: 125px;
  width: 1140px;
  margin: 0 auto;
  text-align: left;
  height: 260px;
  @include e('school-information') {
    font-weight: 500;
    font-size: 20px;
    height: 21px;
    line-height: 21px;
    color: #000000;
    letter-spacing: 0.5px;
  }
  @include e('title') {
    font-weight: 500;
    font-size: 36px;
    height: 64.5px;
    line-height: 37px;
    color: #000000;
    padding: 10px 0 15px;
    border-bottom: 2.5px solid #70b1ba;
    box-sizing: border-box;
    width: 350px;
  }
}
</style>
