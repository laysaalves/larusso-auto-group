FROM eclipse-temurin:21
LABEL maintainer="Layseiras <laysa.developer@gmail.com>"
WORKDIR /app
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

