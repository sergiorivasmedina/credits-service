FROM maven:latest
MAINTAINER srivasme@everis.com

COPY ./target/ ./app
EXPOSE 8080
WORKDIR ./app/
ENTRYPOINT ["java", "-jar", "credit-0.0.1-SNAPSHOT.jar"]