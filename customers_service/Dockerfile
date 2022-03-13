FROM openjdk:11
COPY ./build/libs/crud_application-0.0.1-SNAPSHOT.jar /user/application/
WORKDIR /user/application
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "crud_application-0.0.1-SNAPSHOT.jar"]