FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/RedisCustomProject-1.0.0.jar app.jar
EXPOSE 4001
ENTRYPOINT ["java", "-jar", "app.jar"]
