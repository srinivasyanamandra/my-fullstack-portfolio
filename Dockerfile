# Use a base image with Java
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy only necessary files for dependency resolution
COPY pom.xml mvnw ./  
COPY .mvn .mvn  
RUN chmod +x mvnw && ./mvnw dependency:go-offline  

# Copy the entire project and build it
COPY src ./src  
RUN ./mvnw package -DskipTests  

# Find the built JAR file dynamically and run it
CMD ["sh", "-c", "java -jar target/*.jar"]
