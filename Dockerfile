# Build Stage
FROM maven:3.6.3 AS build
WORKDIR /app
COPY . .
RUN mvn clean compile package

# Deployment Stage
FROM jboss/wildfly:latest AS deploy
COPY --from=build /app/target/Votify.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
