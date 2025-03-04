# add create jar for railway api deploy
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY . .

# final app image
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar larussoapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "larussoapi.jar"]
