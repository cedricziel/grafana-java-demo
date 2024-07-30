# OTel Java Demo

![Title](.github/img.png)

This repository contains a simple Java application that demonstrates how to use the 
[Grafana OpenTelemetry Distribution for Java].

**Ensure you replace the placeholders in `docker/otelcol/config.yaml` with your own Grafana Cloud API key.**

**Ensure you add your own frontend o11y key in `docker/nginx/default.conf`**

```shell
./gradlew clean bootJar
docker compose build app
docker compose up
```

The application will be available at [http://localhost:8081](http://localhost:8081).

## Architecture

The application consists of the following components:
* app - A simple Spring Boot application that serves a single page and a single async request
* nginx - A simple Nginx server that serves the frontend and proxies requests to the app and injects the frontend observability web sdk
* otelcol - The OpenTelemetry Collector that receives telemetry data from the app and forwards it to Grafana Cloud

## License

This project is licensed under the Apache 2.0 License.
