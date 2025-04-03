<template>
  <div class="delete-survey">
    <h2>Delete Survey</h2>
    <form @submit.prevent="deleteSurvey">
      <label for="email">Enter Email:</label>
      <input type="email" id="email" v-model="email" required />
      <div class="button-container">
        <button type="submit">Delete Survey</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      email: "",
    };
  },
  methods: {
    async deleteSurvey() {
      try {
        await axios.delete(`http://localhost:8099/api/surveys/${this.email}`);
        alert("Survey deleted successfully!");
        this.$router.push("/");
      } catch (error) {
        console.error("Error deleting survey:", error);
        alert("Survey not found.");
      }
    },
  },
};
</script>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background-color: #ffcccb; /* Light pink background */
}

.delete-survey {
  max-width: 600px;
  margin: 50px auto;
  padding: 20px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #373776; /* Blue heading color */
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px; /* Space between form fields */
}

label {
  font-weight: bold; /* Bold text for label */
}

input {
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 100%;
}

.button-container {
  text-align: center;
  margin-top: 20px;
}

button {
  background-color: #1e0e03; /* Brown button color */
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  transition: transform 0.2s, background-color 0.2s;
}

button:hover {
  background-color: #170904cc; /* Darker brown on hover */
  transform: scale(1.05);
}

button:active {
  transform: scale(0.95);
}
</style>
