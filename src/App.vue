<template>
  <div class="app">
    <router-view />
    <selectbox
      :options="[
        { text: '2018', value: 2018, },
        { text: '2017', value: 2017, },
        { text: '2016', value: 2016, },
        { text: '2015', value: 2015, },
        { text: '2014', value: 2014, },
        { text: '2013', value: 2013, },
        { text: '2012', value: 2012, },
        { text: '2011', value: 2011, },
      ]"
      v-model="someValue"
    />
    {{ someValue }}
  </div>
</template>

<script>
import selectbox from '@/components/Selectbox';

export default {
  name: 'app',
  data() {
    return {
      someValue: 0,
    };
  },
  components: {
    selectbox,
  },
};
</script>

<style lang="scss">
@import './style/input.scss';
// css initialize
html, body {
  width: 100%;
  height: 100%;
}

input[type=password] {
  font-family: sans-serif;
}

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
  margin: 0;
  padding: 0;
  border: 0;
  vertical-align: baseline;
  font-family: 'nanumsquare', sans-serif;
}

article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
  display: block;
}

body {
  line-height: 1;
}

ol, ul {
  list-style: none;
}

blockquote, q {
  quotes: none;
}

blockquote:before, blockquote:after,
q:before, q:after {
  content: '';
  content: none;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}


</style>
