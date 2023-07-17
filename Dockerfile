# Base image with Java 8
FROM openjdk:8-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Run the application when the container starts
CMD ["java", "-jar", "app.jar"]