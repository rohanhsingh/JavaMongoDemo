FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY out/artifacts/javamongo_jar/javamongo.jar javamongo.jar
ENTRYPOINT ["java","-jar","/javamongo.jar"]