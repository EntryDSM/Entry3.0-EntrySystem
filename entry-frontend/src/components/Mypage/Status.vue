<template>
  <div class="status" @click="moveRoute">
    <div class="status__color-block" :style="styleObject"></div>
    <div class="status__name">
      {{ name }}
    </div>
    <div class="status__state">
      {{ state }}
    </div>
  </div>
</template>

<script>
export default {
  name: status,
  props: {
    name: String,
    color: String,
    isValid: Boolean,
    route: String,
  },
  methods: {
    moveRoute() {
      this.$router.push(this.route);
    },
  },
  computed: {
    state() {
      return this.isValid ? '작성완료' : '작성 미완료';
    },
    styleObject() {
      return { backgroundColor: this.isValid ? this.color : '#fff' };
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.status {
  width: 155px;
  @include e('color-block') {
    transform: rotate(45deg);
    border: solid 1px #96b2b5;
    width: 155px;
    height: 155px;
    margin: 0 auto;
    cursor: pointer;
  }
  @include e('name') {
    width: 125px;
    margin: 70px auto 0;
    color: #356a71;
    font-size: 24px;
    height: 50px;
    line-height: 50px;
    border-bottom: solid 1px #c3d4d7;
    text-align: center;
    cursor: pointer;
  }
  @include e('state') {
    color: #356a71;
    font-size: 18px;
    text-align: center;
    line-height: 40px;
    width: 100%;
    cursor: pointer;
  }
}
</style>
