FROM openjdk:17
MAINTAINER baeldung.com
COPY out/artifacts/javamongo_jar/javamongo.jar javamongo.jar
ENTRYPOINT ["java","-jar","/javamongo.jar"]