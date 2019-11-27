#
# DOCKERFILE APP 
# DIEGO BRAVO
#

FROM maven:3.6-jdk-8-alpine as build

RUN echo "ini 10"

#Var from Dockerfile to execution

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=$ENVIRONMENT

#Server
EXPOSE 18080


RUN echo "## - ENVIRONMENT:[$ENVIRONMENT]"
RUN echo "## - SPRING_PROFILES_ACTIVE: [$SPRING_PROFILES_ACTIVE]"

#Clonar repo
COPY . /app

WORKDIR /app

#Imprimir escructura de archivos en log
RUN echo "## - ========================================================================"
RUN ls -lah 


#Ejecutar servidor#CMD java -jar target/bakery-1.0.0.ja
RUN mvn clean package



# IMAGEN PRODUCCION


FROM openjdk:8-jre-alpine

RUN echo "ini A"

USER root

#Var from Dockerfile to execution

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=$ENVIRONMENT

#Server
EXPOSE 18080


RUN echo "## - ENVIRONMENT:[$ENVIRONMENT]"
RUN echo "## - SPRING_PROFILES_ACTIVE: [$SPRING_PROFILES_ACTIVE]"


WORKDIR /app
COPY --from=build "/app/target/bakery-1.0.0.jar" .

#Imprimir escructura de archivos en log
RUN echo "## - ========================================================================"
RUN ls -lah 


#Ejecutar servidor
ENTRYPOINT [ "java", "-jar", "/app/bakery-1.0.0.jar"]











