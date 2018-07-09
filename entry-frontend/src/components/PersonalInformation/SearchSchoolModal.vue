<template>
  <div class="search-school-modal">
    <input type="text" class="search-school-modal__input">
    <ul class="search-school-modal__list">
      <li class="search-school-modal__list__item">
      </li>
    </ul>
    <div class="search-school-modal__pagination">
      <div class="search-school-modal__pagination__prev">이전</div>
      <div class="search-school-modal__pagination__prev">{{ current }}</div>
      <div class="search-school-modal__pagination__next">다음</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'search-school-modal',
};
</script>

<style lang="scss" scoped>
@import '../../style/setting';
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
  border: 1px solid black;
  z-index: $modal-z-index;
}

</style>
