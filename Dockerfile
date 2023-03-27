FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE
ADD target/cakemanagerapp-0.0.1-SNAPSHOT.jar cakemanagerapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cakemanagerapp-0.0.1-SNAPSHOT.jar"]