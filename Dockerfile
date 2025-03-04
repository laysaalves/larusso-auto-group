FROM eclipse-temurin:21
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/larussodeploy.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "larussodeploy.jar"]