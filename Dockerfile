FROM java:8

MAINTAINER Alok Verma <alok.verma@mindtree.com>

ADD /target/todo-management-0.0.1-SNAPSHOT.jar todo-management-0.0.1-SNAPSHOT.jar

EXPOSE 8081

CMD ["java", "-jar", "todo-management-0.0.1-SNAPSHOT.jar"]


