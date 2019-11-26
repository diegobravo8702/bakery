# Bakery
Bakery is a delicious online store. You will find the most delicious cakes, biscuits and breads just a click away.

[![Coverage Status](https://coveralls.io/repos/github/diegobravo8702/bakery/badge.svg?branch=master)](https://coveralls.io/github/diegobravo8702/bakery?branch=master)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Ubuntu or Debian derivatives. This application was develop on Ubuntu 18.04

#### Set ENVIRONMENT
- The ENVIRONMENT var should be set in development
    ```sh
    $ vim /etc/environment
    ```
    ```console
    $ ENVIRONMENT=development
    ```
    ```console
    $ source /mnt/environment
    ```
- Check if the var was correctly asigment
    ```console
    $ echo $ENVIRONMENT
    ```
#### Install Maven
- You must be logged in as a user with sudo privileges.
    ```sh
    $ sudo apt update
    ```
- Start by updating the package index:
    ```sh
    $ sudo apt update
    ```
-   Next, install Maven by typing the following command:
    ```sh
    $ sudo apt install maven
    ```
-   Verify the installation by running the mvn -version command:
    ```sh
    $ mvn -version
    ```
-   The output should look something like this:
    ```sh
    Apache Maven 3.6.0
    Maven home: /usr/share/maven
    Java version: 11.0.4, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
    Default locale: es_ES, platform encoding: UTF-8
    OS name: "linux", version: "4.15.0-70-generic", arch: "amd64", family: "unix"
    ```
    
    
### Docker
Bakery is very easy to launch from docker.

By default, the Docker will expose port 18080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd bakery
docker-compose up --build -d
```
Verify the deployment by navigating to your server address in your preferred browser.

```sh
127.0.0.1:18080
```

## Authors

* **Diego Armando Bravo Sanabria** - [GitHub](https://github.com/diegobravo8702) - [LinkedIn](https://www.linkedin.com/in/diego-armando-bravo-sanabria-028918b0/)




