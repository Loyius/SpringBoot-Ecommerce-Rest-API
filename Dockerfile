# build
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw
COPY src ./src
RUN ./mvnw clean package -DskipTests

# runtime
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/course-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]