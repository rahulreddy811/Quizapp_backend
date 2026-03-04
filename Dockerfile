# -----------------------------
# Stage 1: Build the JAR
# -----------------------------
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first to download dependencies (caching benefit)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Create minimal runtime image
# -----------------------------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
