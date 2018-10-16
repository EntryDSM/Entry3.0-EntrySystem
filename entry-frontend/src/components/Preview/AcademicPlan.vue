<template>
  <div id="preview-container">
    <div class="watermark" v-if="!finalSubmit">EntryDSM 3.0 미리보기</div>
    <div id="introduction-header">
      학업계획서
    </div>
    <pre id="introduction-title"> 【 지원자 기재사항 】</pre>
    <span id="introduction-info-tables">
      <table>
        <tbody>
          <tr>
            <td><pre style="font-size:12px;">성       명</pre></td>
            <td style="font-size:12px;">{{personName}}</td>
          </tr>
          <tr>
            <td>출신중학교</td>
            <td style="font-size:12px;">{{school.name}}</td>
          </tr>
        </tbody>
      </table>
      <table>
        <tbody>
          <tr>
            <td>
              <div id="tag-icon">◎</div>
              <span id="introduction-info-main-text">
                학업계획서
              </span>
              는 자신이 본교를 선택하게 된 구체적인 사유(지원 동기)와 고등학생이 된 후
              이루고자 하는 목표를 달성하기 위해 생각하는 학업계획을 상세하게 기술하십시오.</td>
          </tr>
          <tr>
            <td><pre id="preview-text">{{studyPlan}}</pre></td>
          </tr>
        </tbody>
      </table>
    </span>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'academic-plan',
  props: ['finalSubmit'],
  computed: {
    personName() { return this.$store.state.PersonInfo.personName; },
    school() { return this.$store.state.PersonInfo.school; },
    ...mapState({
      introduce: state => state.introNPlan.introduce,
      studyPlan: state => state.introNPlan.studyPlan,
    }),
  },
};
</script>

<style scoped>
div {
  box-sizing: border-box;
}

table {
  width: 100%;
  border-spacing: 0;
  border-collapse: collapse;
  table-layout: fixed;
  margin-bottom:20px;
}

p, pre {
  margin: 0;
  padding: 0;
  font-family: inherit;
  font-size: 10px;
}

td {
  height: 20px;
  padding: 0;
  border: 1px solid #000;
  text-align: center;
}

/* All preview document(pdf) use this container. */
#preview-container {
  position: relative;
  width: 595px;
  height: 842px;
  padding: 30px;
  border: 1px solid #000;
}

/* preview -> introduction(자기소개서) */
#introduction-header {
  font-size: 21px;
  font-weight: bold;
  text-align: center;
}

#introduction-title {
  font-size: 12px;
  font-weight: bold;
  margin-bottom: 5px;
}

#introduction-info-tables {
  margin-top: 10px;
  border-bottom: 1px solid #000;
  font-size: 10px;
}

#introduction-info-main-text {
  font-size: 14px;
  font-weight: bold;
}

#tag-icon {
  font-size: 12px;
  height: 100%;
  float: left;
  margin-right: 6px;
}

#preview-text {
  width: 100%;
  height: 550px;
  white-space: pre-line;
  line-height: 1.4;
}

/* row_1, 성명~ */
#introduction-info-tables table:nth-child(1) td:nth-child(1) {
  width: 21%; height: 30px; font-size: 12px;
}
#introduction-info-tables table:nth-child(1) td:nth-child(2) {
  width: 78%;
}

/* row_2, 자기소개서 */
#introduction-info-tables table:nth-child(2) tr:nth-child(1) td:nth-child(1) {
  text-align: left; padding: 8px;
}
#introduction-info-tables table:nth-child(2) tr:nth-child(2) td:nth-child(1) {
  text-align: left; padding: 8px; height: 570px; border-top: 0; width: 100%;
}

.watermark {
  position: absolute;
  top: 400px;
  left: 60px;
  opacity: 0.2;
  font-family: sans-serif;
  font-size: 50px;
  color: #000;
  transform: rotate(-30deg);
}
</style>
