# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application .jar file into the container
COPY target/*.jar /app/surveyproject.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8090

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/surveyproject.jar"]