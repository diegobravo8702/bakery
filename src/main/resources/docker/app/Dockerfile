FROM maven:3.6-jdk-8-alpine

ARG ENVIRONMENT
#Var from Dockerfile to execution
ENV SPRING_PROFILES_ACTIVE=$ENVIRONMENT


#Server
EXPOSE 18080
#Variables de entorno
ENV BAKERY_LOG "/var/log/bakery/"
ENV BAKERY_APP "/home/diego/bakery/"

RUN echo "Make log folder:[$BAKERY_LOG]"
RUN mkdir -p $BAKERY_LOG
RUN chmod 777 $BAKERY_LOG 

RUN echo "## - ENVIRONMENT:[$ENVIRONMENT]"
RUN echo "## - SPRING_PROFILES_ACTIVE: [$SPRING_PROFILES_ACTIVE]"

#Clonar repo
WORKDIR /app
#COPY target/ target/

#Imprimir escructura de archivos en log
RUN ls -al

#Ejecutar servidor
CMD java -jar target/bakery-1.0.0.jar