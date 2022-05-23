FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/customer-challenge-0.0.1.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]