<script setup>

</script>

<template>
  <div id="app" class="app-container">
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
/* Общий контейнер для всех компонентов */
.app-container {
  display: flex;
  flex-direction: column; /* Компоненты располагаются друг под другом */
  align-items: stretch;  /* Растягивание компонентов по ширине родителя */
  gap: 20px; /* Расстояние между компонентами */
  padding: 20px; /* Внешние отступы */
  margin: 0 auto; /* Центровка на странице */
}


form {
  display: flex;
  flex-direction: row;
  gap: 10px; /* Расстояние между элементами формы */
}

label {
  font-weight: bold;
}

input,
select,
button {
  padding: 2px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>

