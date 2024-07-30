FROM openjdk:17
COPY build/libs/otel-spring-demo-0.0.1-SNAPSHOT.jar app.jar

ADD grafana-opentelemetry-java.jar /app/grafana-opentelemetry-java.jar
ENV JAVA_TOOL_OPTIONS=-javaagent:/app/grafana-opentelemetry-java.jar

HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java","-jar","/app.jar"]
