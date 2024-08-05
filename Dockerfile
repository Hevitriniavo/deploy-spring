FROM openjdk:21-jdk-slim AS build
WORKDIR /app

COPY pom.xml .
COPY src src

COPY mvnw .
COPY .mvn .mvn

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests -X

FROM openjdk:21-jdk-slim

COPY --from=build /app/target/deploy-spring-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
