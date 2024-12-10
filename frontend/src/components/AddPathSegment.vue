<script setup>

</script>

<template>
  <div>
    <h1>Add Path Segment</h1>
    <form @submit.prevent="addSegment">
      <label for="id">ID:</label>
      <input v-model="id" type="number" required />

      <label for="pathLength">Path Length:</label>
      <input v-model="path_length" type="number" required />

      <label for="pathName">Path Name:</label>
      <input v-model="path_name" type="text" required />

      <label>
        Active:
        <input type="checkbox" v-model="is_active" />
      </label>

      <button type="submit">Add</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      id: null,
      path_length: null,
      path_name: "",
      is_active: true,
    };
  },
  methods: {
    addSegment() {
      const newSegment = {
        id: this.id,
        path_length: this.path_length,
        path_name: this.path_name,
        is_active: this.is_active,
      };
      axios
          .post("http://localhost:8080/path_segment", newSegment)
          .then(() => {
            alert("Path segment added successfully!");
          })
          .catch((error) => {
            console.error("Error adding segment:", error);
          });
    },
  },
};
</script>


<style scoped>

</style>