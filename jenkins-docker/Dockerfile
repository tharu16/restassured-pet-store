FROM ubuntu:16.04
RUN apt-get update
RUN apt-get update && apt-get install -y \
  default-jre \
  default-jdk \
  git \
  maven

RUN mvn -version
RUN git clone https://github.com/tharu16/restassured-pet-store.git
WORKDIR restassured-pet-store
CMD mkdir test-output && mvn test
#CMD ls && mvn test