<template>
  <div class="update-survey">
    <h2>Update Survey</h2>
    <form @submit.prevent="fetchSurvey">
      <label for="email">Enter Email:</label>
      <input type="email" id="email" v-model="email" required />
      <div class="button-container">
        <button type="submit">Fetch Survey</button>
      </div>
    </form>

    <form v-if="survey" @submit.prevent="updateSurvey">
      <h3>Update Survey Details</h3>

      <label for="firstName">First Name:</label>
      <input type="text" id="firstName" v-model="survey.firstName" required />

      <label for="lastName">Last Name:</label>
      <input type="text" id="lastName" v-model="survey.lastName" required />

      <label for="streetAddress">Street Address:</label>
      <input type="text" id="streetAddress" v-model="survey.streetAddress" required />

      <label for="city">City:</label>
      <input type="text" id="city" v-model="survey.city" required />

      <label for="state">State:</label>
      <input type="text" id="state" v-model="survey.state" required />

      <label for="zip">Zip:</label>
      <input type="text" id="zip" v-model="survey.zip" required />

      <label for="telephoneNumber">Telephone Number:</label>
      <input type="tel" id="telephoneNumber" v-model="survey.telephoneNumber" required />

      <label for="surveyDate">Date of Survey:</label>
      <input type="date" id="surveyDate" v-model="survey.surveyDate" required />

      <label for="likedMost">What did you like most about the campus?</label>
      <input type="text" id="likedMost" v-model="survey.likedMost" required />

      <label for="interestSource">How did you become interested in the university?</label>
      <input type="text" id="interestSource" v-model="survey.interestSource" required />

      <label for="recommendationLikelihood">Likelihood of recommending this school:</label>
      <select id="recommendationLikelihood" v-model="survey.recommendationLikelihood">
        <option value="veryLikely">Very Likely</option>
        <option value="likely">Likely</option>
        <option value="unlikely">Unlikely</option>
      </select>

      <div class="button-container">
        <button type="submit">Update Survey</button>
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
      survey: null,
    };
  },
  methods: {
    async fetchSurvey() {
      try {
        const response = await axios.get(`http://localhost:8099/api/surveys/${this.email}`);
        this.survey = response.data;
        alert("Survey data fetched successfully!");
      } catch (error) {
        console.error("Error fetching survey:", error);
        alert("Survey not found. Please check the email address.");
      }
    },
    async updateSurvey() {
      try {
        const response = await axios.put(`http://localhost:8099/api/surveys/${this.email}`, this.survey);
        alert("Survey updated successfully!");
        console.log(response.data);
        this.$router.push("/");
      } catch (error) {
        console.error("Error updating survey:", error);
        alert("Error occurred while updating the survey.");
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

.update-survey {
  max-width: 600px;
  margin: 50px auto;
  padding: 20px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

h2, h3 {
  text-align: center;
  margin-bottom: 20px;
  color: #373776; /* Blue heading color */
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px; /* Space between fields */
}

label {
  font-weight: bold; /* Bold text for labels */
}

input,
select {
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 5px;
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
