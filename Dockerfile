# add create jar for railway api deploy
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/larussoapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "larussoapi.jar"]