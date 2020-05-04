#Fetch specific image from Docker Hub
FROM openjdk:8u191-jre-alpine3.8

#Add curl and jq to the image
RUN apk add curl jq

#Working Directory in Image
WORKDIR /usr/share/seleniumdocker

#Add .jar under target from host in the image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs
ADD book-flight-module.xml              book-flight-module.xml
ADD search-module.xml                   search-module.xml

#Healthcheck file to the image
#ADD healthcheck.sh                      healthcheck.sh
# ADD health check script
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

#Variables to be passed. #BROWSER, #HUB_HOST, MODULE for execution
ENTRYPOINT sh healthcheck.sh