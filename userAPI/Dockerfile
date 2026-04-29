FROM eclipse-temurin:25-jdk-ubi10-minimal AS build
LABEL authors="Miquéias Ferreira"

WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:25-jre-ubi10-minimal AS runtime
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]