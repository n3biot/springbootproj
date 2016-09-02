FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /opt
VOLUME /opt/config
ADD springboot-0.1.0.jar /opt/app.jar
RUN sh -c 'touch /opt/app.jar'
WORKDIR /opt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
