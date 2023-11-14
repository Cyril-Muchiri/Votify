# Build Stage
FROM maven:3.6.3-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

# Deployment Stage
FROM quay.io/wildfly/wildfly:latest-jdk11
WORKDIR /opt/jboss/wildfly/standalone/deployments/
COPY --from=build /app/target/Votify.war .

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"] && /opt/jboss/wildfly/bin/jboss-cli.sh --connect --command="deploy /opt/jboss/wildfly/standalone/deployments/Votify.war"
