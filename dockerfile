FROM openjdk:8

#COPY target/springboot-backend-0.0.1-SNAPSHOT.jar springapinew.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/springapinew.jar"]
