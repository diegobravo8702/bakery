### BUILD image
FROM maven:3.6-jdk-8-alpine as builder

# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build

#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins

#Copy source code
COPY src /build/src

# Build application
RUN mvn package




### RUNTIME image
#FROM openjdk:8-jre-alpine as runtime
FROM maven:3.6-jdk-8-alpine as runtime
EXPOSE 18080

#Set app home folder
ENV APP_HOME /app
ENV APP_LOGS /var/log/bakery/

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=$ENVIRONMENT

#Create base app folder
RUN mkdir $APP_HOME

#Create folder with application logs
RUN mkdir $APP_LOGS

WORKDIR $APP_HOME
#Copy executable jar file from the builder image
COPY --from=builder /build/target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]
