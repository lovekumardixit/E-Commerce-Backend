#IT will give java 17 to run app
#FROM eclipse-temurin:17-jdk-alpine

# Copy file from local folder to docker container
#COPY target/*.jar app.jar

# The container will be run on this port
#EXPOSE 8080

#It will run the app like .jar API
#ENTRYPOINT ["java", "-jar", "/app.jar"]


# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
# Sirf pom.xml aur source code copy kar rahe hain
COPY pom.xml .
COPY src ./src
# JAR file banane ki command (Docker ke andar chalegi)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
# Stage 1 se bani hui JAR ko copy karna
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

#Kindly ignore this comment it just for checking git