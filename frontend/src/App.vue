<script setup>

</script>

<template>
  <div id="app">
    <AddPathSegment @refreshSegments="refreshSegments" />
    <PathSegmentList ref="pathSegmentList" @refreshSegments="refreshSegments"/>
    <UpdatePathSegment ref="updatePathSegment" @refreshSegments="refreshSegments"/>
  </div>
</template>

<script>
import AddPathSegment from "./components/AddPathSegment.vue";
import PathSegmentList from "./components/PathSegmentList.vue";
import UpdatePathSegment from "./components/UpdatePathSegment.vue";

export default {
  components: {
    AddPathSegment,
    PathSegmentList,
    UpdatePathSegment,
  },
  methods: {
    refreshSegments() {
      // Обновляем список сегментов в таблице
      this.$refs.pathSegmentList.fetchActiveSegments();
      this.$refs.pathSegmentList.fetchInactiveSegments();

      // Обновляем список сегментов в компоненте обновления
      this.$refs.updatePathSegment.fetchSegments();
    },
  },
};
</script>


<style>
</style>

