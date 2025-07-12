FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
VOLUME ["/data"]
CMD ["java", "-jar", "app.jar"]
