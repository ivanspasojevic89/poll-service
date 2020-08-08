FROM openjdk:8-jdk-alpine

VOLUME /tmp
EXPOSE 8080

ADD build/libs/poll-service-0.1.0.jar poll-service.jar
ENTRYPOINT ["java","-jar","/poll-service.jar"]