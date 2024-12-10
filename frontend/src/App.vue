<script setup>

</script>

<template>
  <div id="app">
    <AddPathSegment />
    <PathSegmentList />
    <UpdatePathSegment />
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
};
</script>

<style>
</style>

