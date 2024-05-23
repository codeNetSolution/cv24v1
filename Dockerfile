# rust tooling is provided by `archlinux-rust`
FROM ubuntu
MAINTAINER Abdelkrim SAIDOUN



# relevant files are in `./source`
ADD . /
WORKDIR /

# Clever Cloud expects your app to listen on port 8080
EXPOSE 8080


# Build your application
RUN docker-compose up -d --build


