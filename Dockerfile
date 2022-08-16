#defining base docker image

FROM tomcat:9.0.65-jdk8-corretto
LABEL maintainer="ABDELHADI MOUZAFIR"
ADD target/demo1-1.0-SNAPSHOT.war   /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh","run"]
#ADD target/demo1-1.0-SNAPSHOT.war servlets-docker.war
#RUN jar -cvf servlets-docker.war *
#RUN cp servlets-docker.war $CATALINA_BASE/webapps/servlets-docker.war
#-Djava.security.edge-file:/dev/./urandom