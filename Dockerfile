FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/s19d1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-db:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=Burak123.
ENTRYPOINT ["java", "-jar", "app.jar"]