FROM openjdk:8-jdk-alpine
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]
