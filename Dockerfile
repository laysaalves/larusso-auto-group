FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY . .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "larussoapp.jar"]
