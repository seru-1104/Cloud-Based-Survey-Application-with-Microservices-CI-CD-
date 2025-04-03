<template>
  <div class="home">
    <h1>Survey Management</h1>
    <div class="button-container">
      <button @click="goToPage('/create')">Create Survey</button>
      <button @click="goToPage('/read')">Read Survey</button>
      <button @click="goToPage('/update')">Update Survey</button>
      <button @click="goToPage('/delete')">Delete Survey</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  methods: {
    goToPage(page) {
      this.$router.push(page);
    },
  },
};
</script>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background-color: #ffcccb; /* Light pink background color */
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
}

.home {
  text-align: center;
  color: #ffffff; /* White text for better contrast */
  text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

h1 {
  font-size: 3em;
  margin-bottom: 40px; /* Increased gap between heading and buttons */
  color: #373776; /* Blue color for the heading */
}

.button-container {
  display: flex;
  justify-content: center;
  gap: 25px; /* Increased gap between buttons */
  flex-wrap: wrap;
}

button {
  background-color: #1e0e03; /* Brown background color for buttons */
  color: white; /* White text inside buttons */
  border: none;
  border-radius: 12px;
  padding: 20px 35px; /* Larger button size */
  font-size: 1.5em; /* Larger text size */
  font-weight: bold;
  cursor: pointer;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  transition: transform 0.2s, box-shadow 0.2s;
}

button:hover {
  background-color: #170904cc; /* Darker shade of brown for hover effect */
  transform: scale(1.05);
  font-weight: bold;
  box-shadow: 0 7px 15px rgba(0, 0, 0, 0.3);
}

button:active {
  transform: scale(0.95);
}
</style>
