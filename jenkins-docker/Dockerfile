FROM ubuntu:16.04
RUN apt-get update
RUN apt-get update && apt-get install -y \
  default-jre \
  default-jdk \
  git \
  maven

RUN mvn -version
#RUN git clone https://github.com/tharu16/restassured-pet-store.git
RUN mkdir restassured-demo-tests
COPY restassured-pet-store /restassured-demo-tests
#COPY pom.xml /restassured-demo-tests
WORKDIR restassured-demo-tests/
CMD ls && mvn test
#RUN cd restassured-pet-store && mkdir test-output
#CMD mvn test