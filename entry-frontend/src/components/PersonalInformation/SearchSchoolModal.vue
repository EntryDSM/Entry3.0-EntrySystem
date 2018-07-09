<template>
  <div class="search-school-modal">
    <button class="search-school-modal__close-btn">&times;</button>
    <input type="text"
      class="search-school-modal__input"
      :placeholder="placeholder">
    <ul class="search-school-modal__list">
      <li class="
        search-school-modal__list__item
        search-school-modal__list__item--head">
        <span class="search-school-modal__list__item__name">
          학교 이름
        </span>
        <span class="search-school-modal__list__item__address">
          지역
        </span>
      </li>
      <li class="
        search-school-modal__list__item
        search-school-modal__list__item--instance">
        <span class="
          search-school-modal__list__item__name
          search-school-modal__list__item--instance__name">
          대전중학교
        </span>
        <span class="search-school-modal__list__item__address">
          대전광역시
        </span>
      </li>
    </ul>
    <div class="search-school-modal__pagination">
      <div class="search-school-modal__pagination__number">이전</div>
      <div class="search-school-modal__pagination__number">1</div>
      <div class="search-school-modal__pagination__number">다음</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'search-school-modal',
  data() {
    return {
      placeholder: '검색어 입력',
    };
  },
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
$color-main1: #769b9f;
$color-main2: #e0eef1;
$color-main3: #5f8a90;
$color-main4: #f7fbfc;
$modal-z-index: 5;

.search-school-modal {
  $modal-width: 400px;
  $modal-height: 500px;
  position: fixed;
  top: 50%;
  left: 50%;
  width: $modal-width;
  height: $modal-height;
  transform: translate(-$modal-width / 2, -$modal-height / 2);
  border: 1px solid $color-main1;
  z-index: $modal-z-index;
  background-color: #fff;
  position: fixed;
  box-sizing: border-box;
  padding: {
    top: 40px;
    left: 10px;
    right: 10px;
  }
  @include e('close-btn') {
    box-sizing: border-box;
    $btn-size: 25px;
    font-size: $btn-size;
    line-height: $btn-size;
    width: $btn-size;
    height: $btn-size;
    border: none;
    background-color: #fff;
    position: absolute;
    top: 5px;
    right: 5px;
    color: $color-main3;
  }
  @include e('input') {
    display: block;
    width: 100%;
    box-sizing: border-box;
    border: 1px solid $color-main1;
    background-color: $color-main4;
    padding: 10px;
    font-size: 18px;
    line-height: 18px;
    outline: none;
  }
  @include e('list') {
    border: 1px solid $color-main2;
    height: $modal-height - 150px;
    margin-top: 10px;
    overflow-y: scroll;
    @include e('item') {
      box-sizing: border-box;
      padding-left: 10px;
      border-bottom: 1px solid $color-main2;
      position: relative;
      @include m('head') {
        background-color: $color-main4;
        color: $color-main3;
        height: 30px;
        line-height: 30px;
      }
      @include m('instance') {
        height: 50px;
        line-height: 50px;
        @include e('name') {
          cursor: pointer;
          &:hover {
            color: $color-main3;
            border-bottom: 1px solid $color-main3;
          }
        }
      }
      @include e('name') {
        font-size: 18px;
      }
      @include e('address') {
        font-size: 15px;
        position: absolute;
        right: 0;
        padding-right: 10px
      }
    }
  }
  @include e('pagination') {
    width: 100%;
    display: flex;
    justify-content: center;
    margin-top: 20px;
    @include e('number') {
      height: 20px;
      font-size: 18px;
      line-height: 20px;
      width: 40px;
      cursor: pointer;
      text-align: center;
    }
  }
}

</style>
