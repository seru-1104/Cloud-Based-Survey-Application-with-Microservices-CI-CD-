<template>
  <div class="create-survey">
    <h2>Create Survey</h2>
    <form @submit.prevent="createSurvey">
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

      <label for="email">E-mail:</label>
      <input type="email" id="email" v-model="survey.email" required />

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
        <button type="submit">Submit</button>
        <button type="button" @click="cancelForm">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      survey: {
        firstName: "",
        lastName: "",
        streetAddress: "",
        city: "",
        state: "",
        zip: "",
        telephoneNumber: "",
        email: "",
        surveyDate: "",
        likedMost: "",
        interestSource: "",
        recommendationLikelihood: "",
      },
    };
  },
  methods: {
    async createSurvey() {
      try {
        const response = await axios.post("http://localhost:8099/api/surveys", this.survey);
        alert("Survey created successfully!");
        console.log(response.data);
        this.$router.push("/");
      } catch (error) {
        console.error(error);
        alert("Error creating survey.");
      }
    },
    cancelForm() {
      this.$router.push("/");
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

.create-survey {
  max-width: 800px;
  margin: 50px auto; /* Center the form horizontally and add top margin */
  padding: 20px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #373776; /* Blue heading color */
}

form {
  display: flex;
  flex-direction: column;
  gap: 15px; /* Add space between form fields */
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
  display: flex;
  justify-content: center; /* Center the buttons */
  gap: 15px; /* Add space between buttons */
  margin-top: 20px;
}

button {
  background-color: #1e0e03; /* Brown color */
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
