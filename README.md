# restassured-pet-store
This project is an example demonstration of setting up Api test automation project from scratch using RestAssured, Java, TestNG, Maven and Extentreports.

#### Installation
Project dependencies are in ```pom.xml``` file. ```mvn clean install``` would install project dependencies

#### Framework setup
   TODO DOCUMENTATION
   
#### Run API test
###### option 1 - Maven
  Navigate to project root directory and run :
 ```
 mvn test
 ```
 ###### option 2 -  Docker (Run on local env)
 Navigate to project root directory and run :
 ```
 docker build -f local-docker/Dockerfile -t demo:restassured-local .
 docker run -it demo:restassured-local
 ```
 
 ###### option 3 -  Docker (Run on Jenkins env)
 Navigate to project root directory and run :
 ```
 docker build -f jenkins-docker/Dockerfile -t demo:restassured-jenkins .
 docker run -it demo:restassured-jenkins
 ```
 
 #### Extent reports
 Reports are generated under ```test-output``` folder
 It will be genreated as ```report.html```. To view the generated reports right click on html file and select'Open on browser option'
