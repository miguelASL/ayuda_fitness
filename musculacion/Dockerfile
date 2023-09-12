FROM openjdk:17-jdk-slim

LABEL authors="Miguel Sarmiento"

COPY pom.xml .
COPY src ./src

WORKDIR /app

ECHO "Nutritional Calculation API with Spring Boot🏃🚴‍♀️ !"

EXPOSE 8080

RUN apt-get update && apt-get install -y maven && mvn clean install

ENTRYPOINT ["java", "-jar", "target/Service-0.0.1-SNAPSHOT.jar"]