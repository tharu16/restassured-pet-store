#!/bin/sh

docker build -f jenkins-docker/Dockerfile -t demo:restassured-jenkins .
docker run -it demo:restassured-jenkins
