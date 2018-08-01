<template>
  <div class="process-bar">
    <div class="process-bar__moment-cover">
      <div class="process-bar__moment-cover__moment"
        v-for="(caption, index) in captions"
        :key="`m${index}`"
        @click="changeCurrent(index * 2)"
        :class="{'current': current == index * 2}">
        <div class="process-bar__moment-cover__moment__caption">
          {{ caption }}
        </div>
      </div>
    </div>
    <div class="process-bar__gap-cover">
      <div class="process-bar__gap-cover__gap"
        v-for="index in (captions.length - 1)"
        :key="`g${index}`"
        @click="changeCurrent((index * 2) - 1)"
        :class="{'current': current == (index * 2) - 1}">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'process-bar',
  props: {
    captions: {
      type: Array,
      required: true,
    },
    ahead: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      current: 0,
    };
  },
  methods: {
    changeCurrent(clickIndex) {
      this.current = clickIndex;
      this.$emit('change', this.current);
    },
  },
  created() {
    this.current = this.ahead;
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.process-bar {
  width: 900px;
  height: 20px;
  object-fit: contain;
  border-radius: 45px;
  background-color: #4b8d8a;
  box-shadow: 0 0 27.5px -10px #4ddcec;
  position: relative;
  z-index: 0;
  @include e('moment-cover') {
    display: flex;
    justify-content: space-between;
    position: absolute;
    top: 100%;
    left: 0;
    width: 100%;
    z-index: 1;
    @include e('moment') {
      width: 50px;
      height: 50px;
      object-fit: contain;
      background-color: #65bbb7;
      box-shadow: 0 0 25px -10px #4ddcec;
      border-radius: 25px;
      position: relative;
      z-index: 2;
      top: -10px;
      transform: translateY(-50%);
      cursor: pointer;
      @include e('caption') {
        height: 20px;
        font-size: 18px;
        line-height: 20px;
        letter-spacing: 0.5px;
        text-align: center;
        color: #005c4f;
        width: 100px;
        position: absolute;
        z-index: 3;
        top: -38px;
        left: 50%;
        transform: translateX(-50%);
      }
    }
  }
  @include e('gap-cover') {
    display: flex;
    justify-content: space-evenly;
    height: 100%;
    @include e('gap') {
      margin-left: 50px;
      flex: 1;
      cursor: pointer;
      &:last-child {
        margin-right: 50px;
      }
    }
  }
}

.current {
  font-size: 20px !important;
  font-weight: bolder !important;
  background-image: url('../../assets/MainPage/process_moment_current.png');
  background-position: center center;
  background-size: 40px 40px;
  background-repeat: no-repeat;
}
</style>
