FROM openjdk:13-jdk-alpine
VOLUME /tmp
COPY target/*.jar auth.jar
EXPOSE 6000
ENTRYPOINT ["java","-jar","/auth.jar"]