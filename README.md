docker-play-framework
=======================
A proof of concept with two play apps running in separate docker containers

### Concept
This project contains two separate play framework applications that form a fictitious web service, `/dev/null for the cloud`. 

The dev-null project contains the actual web service with a single endpoint that throws away the input and then returns Ok in most cases but will also sometimes return a couple random status codes.

The client project is the web interface that consumes the dev-null service.

Currently, the `run` shell script packages both services into docker containers with `sbt-native-packager` and then links the two together, but the goal is to use Docker Compose in the near future.
