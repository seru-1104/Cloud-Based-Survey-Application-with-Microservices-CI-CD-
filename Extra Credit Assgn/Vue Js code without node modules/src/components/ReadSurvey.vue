<template>
  <div class="read-survey">
    <h2>Read Survey</h2>
    <form @submit.prevent="fetchSurvey">
      <label for="email">Enter Email:</label>
      <input type="email" id="email" v-model="email" required />
      <div class="button-container">
        <button type="submit">Fetch Survey</button>
      </div>
    </form>
    <div v-if="survey" class="survey-details">
      <h3>Survey Details</h3>
      <p><strong>First Name:</strong> {{ survey.firstName }}</p>
      <p><strong>Last Name:</strong> {{ survey.lastName }}</p>
      <p><strong>Street Address:</strong> {{ survey.streetAddress }}</p>
      <p><strong>City:</strong> {{ survey.city }}</p>
      <p><strong>State:</strong> {{ survey.state }}</p>
      <p><strong>Zip:</strong> {{ survey.zip }}</p>
      <p><strong>Telephone Number:</strong> {{ survey.telephoneNumber }}</p>
      <p><strong>Email:</strong> {{ survey.email }}</p>
      <p><strong>Date of Survey:</strong> {{ survey.surveyDate }}</p>
      <p><strong>Liked Most:</strong> {{ survey.likedMost }}</p>
      <p><strong>Interest Source:</strong> {{ survey.interestSource }}</p>
      <p><strong>Recommendation Likelihood:</strong> {{ survey.recommendationLikelihood }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      email: "",
      survey: null,
    };
  },
  methods: {
    async fetchSurvey() {
      try {
        const response = await axios.get(`http://localhost:8099/api/surveys/${this.email}`);
        this.survey = response.data;
      } catch (error) {
        console.error("Error fetching survey:", error);
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

.read-survey {
  max-width: 600px;
  margin: 50px auto; /* Center the form */
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
  gap: 15px; /* Add spacing between form elements */
}

label {
  font-weight: bold; /* Bold text for labels */
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

.survey-details {
  margin-top: 30px;
  padding: 15px;
  background-color: #f9f9f9;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.survey-details h3 {
  color: #373776;
  margin-bottom: 10px;
}

.survey-details p {
  font-size: 14px;
  line-height: 1.6;
}
</style>
