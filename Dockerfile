#IT will give java 17 to run app
FROM eclipse-temurin:17-jdk-alpine

# Copy file from local folder to docker container
COPY target/*.jar app.jar

# The container will be run on this port
EXPOSE 8080

#It will run the app like .jar API
ENTRYPOINT ["java", "-jar", "/app.jar"]