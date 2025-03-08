FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="Layseiras <laysa.developer@gmail.com>"
WORKDIR /app
COPY app/target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

