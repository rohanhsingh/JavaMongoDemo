FROM openjdk:17
MAINTAINER baeldung.com
COPY target/javamongo-0.0.1-SNAPSHOT-exec.jar javamongo-0.0.1-SNAPSHOT-exec.jar
ENTRYPOINT ["java","-jar","/javamongo-0.0.1-SNAPSHOT-exec.jar.jar"]