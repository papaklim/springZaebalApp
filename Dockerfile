FROM openjdk:11-jdk-slim-buster
VOLUME /tmp
ADD target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", ">", "log.txt", "&"]