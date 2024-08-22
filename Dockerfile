# Stage 1: Build the application
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build

# Stage 2: Create the final image
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]