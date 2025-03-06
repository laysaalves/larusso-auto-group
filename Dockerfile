FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY . .
EXPOSE 8080
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
