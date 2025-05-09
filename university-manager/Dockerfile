FROM openjdk:17-jdk-alpine

WORKDIR /university-manager

COPY target/UniversityManagerApplication.jar /app/myapp.jar

ENTRYPOINT ["java", "-jar", "myapp.jar"]
