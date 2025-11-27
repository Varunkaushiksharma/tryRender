# Use official Java runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy project source
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/mogodb-0.0.1-SNAPSHOT.jar"]
