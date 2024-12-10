<script setup>

</script>

<template>
  <div>
    <h1>Active Path Segments</h1>
    <ul>
      <li v-for="segment in active_segments" :key="segment.id">
        <p><strong>ID:</strong> {{ segment.id }}</p>
        <p><strong>Length:</strong> {{ segment.path_length }}</p>
        <p><strong>Name:</strong> {{ segment.path_name }}</p>
        <p><strong>Active:</strong> {{ segment.is_active }}</p>
        <button @click="deactivateSegment(segment.id)">Deactivate</button>
        <button @click="deleteSegment(segment.id)">Delete</button>
      </li>
    </ul>

    <h1>Inactive Path Segments</h1>
    <ul>
      <li v-for="segment in inactive_segments" :key="segment.id">
        <p><strong>ID:</strong> {{ segment.id }}</p>
        <p><strong>Length:</strong> {{ segment.path_length }}</p>
        <p><strong>Name:</strong> {{ segment.path_name }}</p>
        <p><strong>Active:</strong> {{ segment.is_active }}</p>
        <button @click="deleteSegment(segment.id)">Delete</button>
      </li>
    </ul>

  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      active_segments: [],
      inactive_segments: [],
    };
  },
  methods: {
    fetchActiveSegments() {
      axios
          .get("http://localhost:8080/path_segment")
          .then((response) => {
            this.active_segments = response.data;
          })
          .catch((error) => {
            console.error("Error fetching active segments:", error);
          });
    },
    fetchInactiveSegments() {
      axios
          .get("http://localhost:8080/path_segment/get_inactive")
          .then((response) => {
            this.inactive_segments = response.data;
          })
          .catch((error) => {
            console.error("Error fetching inactive segments:", error);
          });
    },
    deactivateSegment(id) {
      axios
          .delete(`http://localhost:8080/path_segment/${id}`)
          .then(() => {
            this.fetchActiveSegments(); // Refresh the list
            this.fetchInactiveSegments();
          })
          .catch((error) => {
            console.error("Error deactivating segment:", error);
          });
    },
    deleteSegment(id) {
      axios
          .delete(`http://localhost:8080/path_segment/full_delete/${id}`)
          .then(() => {
            this.fetchActiveSegments(); // Refresh the list
            this.fetchInactiveSegments();
          })
          .catch((error) => {
            console.error("Error deleting segment:", error);
          });
    },
  },
  mounted() {
    this.fetchActiveSegments();
    this.fetchInactiveSegments();
  },
};
</script>

<style>
/* Optional styles */
</style>


<style scoped>

</style>