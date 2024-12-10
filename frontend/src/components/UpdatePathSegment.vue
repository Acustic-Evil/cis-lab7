<script setup>

</script>

<template>
  <div>
    <h1>Update Path Segment</h1>
    <form @submit.prevent="updateSegment">
      <label for="id">ID (Select Existing):</label>
      <select v-model="id" @change="fetchSegmentDetails" required>
        <option v-for="segment in segments" :key="segment.id" :value="segment.id">
          {{ segment.id }}
        </option>
      </select>

      <label for="pathLength">Path Length:</label>
      <input v-model="path_length" type="number" required />

      <label for="pathName">Path Name:</label>
      <input v-model="path_name" type="text" required />

      <label>
        Active:
        <input type="checkbox" v-model="is_active" />
      </label>

      <button type="submit">Update</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      id: null, // ID для выбора
      path_length: null,
      path_name: "",
      is_active: false,
      segments: [], // Список всех сегментов для выбора
    };
  },
  methods: {
    fetchSegments() {
      // Получение списка всех активных сегментов
      axios
          .get("http://localhost:8080/path_segment/get_all")
          .then((response) => {
            this.segments = response.data;
          })
          .catch((error) => {
            console.error("Error fetching segments:", error);
          });
    },
    fetchSegmentDetails() {
      // Получение деталей выбранного сегмента
      const selectedSegment = this.segments.find((segment) => segment.id === this.id);
      if (selectedSegment) {
        this.path_length = selectedSegment.path_length;
        this.path_name = selectedSegment.path_name;
        this.is_active = selectedSegment.is_active;
      }
    },
    updateSegment() {
      // Отправка обновлённых данных на сервер
      const updatedSegment = {
        id: this.id,
        path_length: this.path_length,
        path_name: this.path_name,
        is_active: this.is_active,
      };

      axios
          .put("http://localhost:8080/path_segment", updatedSegment)
          .then(() => {
            alert("Path segment updated successfully!");
            this.$emit("refreshSegments"); // Отправляем событие в родительский компонент
          })
          .catch((error) => {
            console.error("Error updating segment:", error);
          });
    },
  },
  mounted() {
    this.fetchSegments(); // Загрузка списка сегментов при открытии компонента
  },
  watch: {
    // Слушаем событие от родителя для обновления списка сегментов
    "$props.refresh": {
      handler() {
        this.fetchSegments();
      },
      immediate: true,
    },
  },
};
</script>

<style>
/* Optional styles */
</style>


<style scoped>

</style>