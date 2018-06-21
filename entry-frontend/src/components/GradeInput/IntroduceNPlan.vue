<template>
  <div>
    <navigation />
    <headline :subText="'2019 입학원서 작성'" title="성적 입력" />
    <div class="intro-plan-cover">
      <h3>자기소개서</h3>
      <div class="underline"></div>
      <p class="intro-plan-explain">
        자기소개서 내용은 특별한 형식이 없습니다. 개인의 특성 및 성장 과정,
        취미/특기와 학교생활, 가족 안에서의 역할, 남들보다 뛰어나다고 생각하는
        자신의 장점(특성 혹은 능력)과 보완/발전시켜야 할 단점에 대하여 기술하십시오.
      </p>
      <textarea class="intro-plan-write"
                :value="introduce"
                @input="introduce = $event.target.value"
                maxlength="1600"
                ref="introWrite"
      ></textarea>

      <h3>학업계획서</h3>
      <div class="underline"></div>
      <p class="intro-plan-explain">
        학업 계획서는 자신이 본교를 선택하게 된 구체적인 사유 (지원 동기)와
        고등학생이 된 후 이루고자 하는 목표를 달성하기 위해 생각하는 학업계획을
        상세하게 기술하십시오.
      </p>
      <textarea class="intro-plan-write"
                :value="plan"
                @input="plan = $event.target.value"
                maxlength="1600"
                ref="planWrite"
      ></textarea>
    </div>
    <prev-next-btn :prevShow="1"
                   :nextShow="1"
                   @toPrevPage="movePrev"
                   @toNextPage="moveNext"
    />
    <entry-footer />
  </div>
</template>

<script>
import Navigation from '../common/Navigation';
import Headline from '../common/Headline';
import PrevNextBtn from '../common/PrevNextBtn';
import EntryFooter from '../common/EntryFooter';

export default {
  name: 'introduce-n-plan',
  components: {
    Navigation,
    Headline,
    PrevNextBtn,
    EntryFooter,
  },
  data() {
    return {
      introduce: '',
      introLength: 0,
      plan: '',
      planLength: 0,
    };
  },
  methods: {
    resize(t) {
      const target = t;
      target.style.height = '1px';
      target.style.height = `${10 + target.scrollHeight}px`;
    },
    movePrev() {
      this.$router.push('/');
    },
    moveNext() {
      this.$router.push('/');
    },
  },
  watch: {
    introduce(val) {
      const intro = this.$refs.introWrite;
      this.resize(intro);
      this.introLength = val.length;
    },
    plan(val) {
      const plan = this.$refs.planWrite;
      this.resize(plan);
      this.planLength = val.length;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';

.intro-plan-cover {
  width: 1140px;
  margin: 0 auto;

  h3 {
    font-size: 24px;
    font-weight: 400;
    margin-top: 5px;

    &:last-of-type {
      margin-top: 50px;
    }
  }

  .underline {
    width: 125px;
    height: 2px;
    background-color: #abc9cd;
    margin-top: 10px;
  }

  .intro-plan-explain {
    font-size: 20px;
    line-height: 1.25;
    letter-spacing: 0.3px;
    text-indent: 11px;
    margin-top: 10px;
  }

  .intro-plan-write {
    width: 100%;
    min-height: 390px;
    resize: vertical;
    border-radius: 10px;
    border: 1px solid #5f8a90;
    margin-top: 10px;
    font-size: 18px;
    padding: 7.5px;
    box-sizing: border-box;
    outline: none;
  }
}
</style>
