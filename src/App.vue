<template>
  <div class="app">
    <input type="text" class="text-input app__text-input" placeholder="hello">
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style lang="scss">
// css initialize
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
font-size: 100%;
font: inherit;
vertical-align: baseline;
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

// BEM mixin
@mixin e($element) {
  &__#{$element} {
    @content;
  }
}
@mixin m($modifier) {
  &--#{$modifier} {
    @content;
  }
}

// text-input 전역 스타일
.text-input {
  height: 40px;
  border-radius: 5px;
  background-color: #ffffff;
  border: solid 0.5px #5f8a90;
  padding: 11px 16px 10px;
  width: 400px;
  font-size: 18px;
  box-sizing: border-box;
  outline: none;
  &::placeholder {
    color: #acbec1;
  }
}

// 사용
.app {
  @include e('text-input') {
    width: 400px;
  }
}
</style>
