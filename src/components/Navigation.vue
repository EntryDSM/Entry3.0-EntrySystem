<template>
  <nav class="nav">
    <div class="nav__contants">
      <div class="nav__contants__logo">
      <router-link to="/">
        <img
          class="nav__contants__logo--img"
          src="./../assets/Entry__logo--img.png"
          alt="EntryDSM 이미지 로고입니다."/>
        <img
          class="nav__contants__logo--text"
          src="./../assets/Entry__logo--text.png"
          alt="EntryDSM 텍스트 로고입니다."/>
      </router-link>
    </div>
    <ul class="nav__contants__list">
      <li class="nav__contants__list__link">
        <router-link to="/explain">시스템 소개</router-link>
      </li>
      <li class="nav__contants__list__link">
        <router-link to="/write">원서작성</router-link>
      </li>
      <li class="nav__contants__list__link">
        <router-link to="/summary">전형요강</router-link>
      </li>
      <li class="nav__contants__list__link">
        <router-link to="/schedule">모집일정</router-link>
      </li>
      <li class="nav__contants__list__link nav__contants__list__link--login">
        로그인
      </li>
    </ul>
    </div>
  </nav>
</template>

<style lang="scss" scoped>
@import '../style/setting.scss';
.nav {
  height: 60px;
  padding: 0 auto;
  box-shadow: 0 2px 10px 0 rgba(99, 141, 147, 0.05);
  @include e(contants){
    position: relative;
    width: 1140px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    @include e(logo){
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
      @include m(img) {
        height: 30px;
      }
      @include m(text){
        position: relative;
        left: 11px;
        width: 69px;
      }
    }
    @include e(list) {
      position: absolute;
      display: flex;
      align-items: center;
      height: 100%;
      right: 0;
      @include e(link){
        line-height: 60px;
        height: 100%;
        padding: 0 15px;
        margin-left: 15px;
        cursor: pointer;
        display: inline-block;
        &:hover{
          background-color: #f6f7f9;
        }
        @include m(login){
          margin-left: 103px;
        }
      }
    }
  }
}
a {
  &:link{
    color: #000;
    text-decoration: none;
  }
  &:visited{
    color: #000;
    text-decoration: none;
  }
}
@media all and (max-width: 1140px) {
  .nav__contants__list__link:not(.nav__contants__list__link--login){
    display: none;
  }
  .nav__contants{
    width: 100%;
  }
}
</style>
