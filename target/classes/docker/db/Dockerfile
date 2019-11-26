FROM mariadb:5

ARG ENVIRONMENT
#Var from Dockerfile to execution
ENV ENVIRONMENT=$ENVIRONMENT

#Server
EXPOSE 3306 

ARG MYSQL_ROOT_PASSWORD
ARG MYSQL_USER
ARG MYSQL_PASSWORD
ARG MYSQL_DATABASE

ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD
ENV MYSQL_USER=$MYSQL_USER
ENV MYSQL_PASSWORD=$MYSQL_PASSWORD
ENV MYSQL_DATABASE=$MYSQL_DATABASE


# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically executed during container startup
COPY scripts-init/ /docker-entrypoint-initdb.d/

ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 3306
CMD ["mysqld"]