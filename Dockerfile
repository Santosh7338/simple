FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/sample-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4001

ENTRYPOINT ["java", "-jar", "app.jar"]
