FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY target/*.jar /app/application.jar
EXPOSE 8080
CMD ["java", "-jar", "application.jar"]
