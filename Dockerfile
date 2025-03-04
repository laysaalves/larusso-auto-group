FROM maven:3.8.6-openjdk-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src

FROM openjdk:21-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/larusso.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "larusso.jar"]
