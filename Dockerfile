FROM openjdk:17
COPY target/ManagementHospital-0.0.1-SNAPSHOT.jar apps.jar
ENTRYPOINT ["java", "-jar", "/apps.jar"]