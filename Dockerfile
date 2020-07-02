FROM openjdk:11-jre-slim

COPY ./target/todo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch todo-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","todo-0.0.1-SNAPSHOT.jar"]
