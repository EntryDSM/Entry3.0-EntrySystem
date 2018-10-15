<template>
  <footer>
    <div class="footer-cover">
      <img src="../../assets/Footer/footer_logo.png"
           alt="푸터 로고"
           class="footer-cover__logo"
      >

      <span class="footer-cover__copyright">
        ⓒ 2018 Entry
      </span>

      <p class="footer-cover__explain">
        개인정보 처리방침 | 이용약관<br>
        (34111)대전광역시 유성구 가정북로 76(장동 23-9)<br>
        교무실 : 042-866-8822 / Fax : 042-867-9900
        <span class="footer-cover__explain--admin">
          행정실 : 042-866-8885 / Fax : 042-863-4308
        </span><br>
        사업자 등록 번호 314-83-01600
      </p>

      <div class="footer-cover__navigation">
        <div class="footer-cover__icon">
          <a href="https://www.facebook.com/entrydsm" target="_blank">
          <img src="../../assets/Footer/ico_facebook.png"
               alt="페이스북 이동 링크"
               class="link-imgs link-imgs--facebook-link"
          >
        </a>
        <a href="https://github.com/Jaws-bar/Entry3.0-EntrySystem" target="_blank">
          <img src="../../assets/Footer/ico_github.png"
              alt="깃허브 이동 링크"
              class="link-imgs link-imgs--github-link"
          >
        </a>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'entry-footer',
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
$white: #fff;

footer {
  position: relative;
  height: 200px;
  background-color: #78C2CA;

  .footer-cover {
    width: 1140px;
    height: 100%;
    box-sizing: border-box;
    position: relative;
    padding: 20px 0;
    margin: 0 auto;
    position: relative;

    // 로고 부분
    @include e('logo') {
      width: 100px;
      display: block;
      margin-top: 13px;
    }

    // Copyright 부분
    @include e('copyright') {
      font-size: 10px;
      color: $white;
      display: block;
      margin-top: 5px;
    }

    // 설명 부분
    @include e('explain') {
      font-size: 10px;
      line-height: 1.9;
      color: $white;
      margin-top: 18px;

      // 설명 부분 중 행정실
      @include m('admin') {
        padding-left: 16px;
      }
    }
    @include e('icon') {
      position: absolute;
      bottom: 0px;
      right: 0;
    }
    // 푸터 네비게이션
    @include e('navigation') {
      position: absolute;
      width: 330px;
      height: 138px;
      top: 20px;
      right: 0;

      // ul 부분
      .navigation-cover {
        display: inline-block;
        vertical-align: top;
        margin-left: 70px;
        position: absolute;
        right: 100px;
        &:first-of-type {
          margin-left: 0;
        }
        &:last-of-type {
          margin-left: 30px;
        }
        // li 부분
        @include e('lists') {
          list-style: none;
          margin-top: 15px;
          &:first-of-type{
            margin-top: 7px;
            a {
              font-size: 15px;
              opacity: 1;
            }
          }

          // a 부분
          @include e('links') {
            text-decoration: none;
            font-size: 14px;
            color: #fff;
            opacity: 0.6;
            transition: 0.3s;
            &:hover {
              opacity: 1;
            }
          }
        }
      }

      .link-imgs {
        position: absolute;
        width: 30px;
        margin-top: -25px;
        opacity: 0.75;
        transition: 0.5s;
        @include m('facebook-link') {
          right: 45px;
        }
        @include m('github-link') {
          right: 1px;
        }
        &:hover{
          opacity: 1;
        }
      }
    }
  }
}
</style>
