# Base Image
FROM openjdk:8

MAINTAINER Alok Verma <aloknarayan52@gmail.com>

# Create DIR
RUN mkdir -p /usr/src/myapp
# COPY APPLICTAION COde
COPY /target/todo-management-0.0.1-SNAPSHOT.jar /usr/src/myapp

# Setup Working DIR
WORKDIR /usr/src/myapp

# Start the Bot Service
CMD ["java", "-jar", "todo-management-0.0.1-SNAPSHOT.jar"]


