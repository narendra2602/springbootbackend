FROM openjdk:8

COPY target/springboot-backend-0.0.1-SNAPSHOT.jar springapi.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/springapi.jar"]
