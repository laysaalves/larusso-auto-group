FROM eclipse-temurin:17
LABEL maintainer="laysa.developer@gmail.com"
WORKDIR /app
COPY target/larussoautogroup-0.0.1-SNAPSHOT.jar /app/larusso.jar
EXPOSE 8080
CMD ["java", "-jar", "larusso.jar"]