FROM ubuntu-jdk

MAINTAINER Armen "armen@yahoo.com"

ENV dbuser=postgres
ENV dbpass=password
ENV jdbcurl=jdbc:postgresql://pma.c2cc2mu0mve0.us-east-1.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin

ADD pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]


