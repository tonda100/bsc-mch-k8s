FROM jboss/wildfly

COPY target/mch.war /opt/jboss/wildfly/standalone/deployments/