FROM openjdk:17-jdk-slim

LABEL authors="Miguel Sarmiento"

COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src

WORKDIR /usr/local/service

EXPOSE 8080

RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package

ENTRYPOINT ["java", "-jar", "target/Service-0.0.1-SNAPSHOT.jar"]