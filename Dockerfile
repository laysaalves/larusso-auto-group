FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/larussoapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "larussoapp.jar"]
