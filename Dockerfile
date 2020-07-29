#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#EXPOSE 8080
#COPY target/demoQueryDSLMongo*.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM maven:3.6.3-jdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
COPY src ./src
#RUN ls -la ./src
RUN mvn clean package -Dmaven.test.skip=true
#RUN ls -la /app

FROM openjdk:8-jdk-alpine
LABEL maintainer="sonia.guadalupe.garcia@gmail.com"
WORKDIR /workspace
#RUN ls -la /workspace
#EXPOSE 8080
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT exec java -jar app.jar/demoQueryDSLMongo-1.0-SNAPSHOT.jar
