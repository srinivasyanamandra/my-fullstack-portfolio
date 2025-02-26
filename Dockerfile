# Use a base image with Java
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy only necessary files for dependency resolution
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline

# Copy the entire project and build it
COPY . .
RUN ./mvnw package -DskipTests

# Run the built JAR file
CMD ["java", "-jar", "target/$(ls target/*.jar | grep -v 'original' | head -n 1)"]
