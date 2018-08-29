FROM java:8
VOLUME /tmp
ADD api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
RUN bash -c 'touch /api-gateway.jar'
EXPOSE 4000
ENTRYPOINT ["nohup","java","-jar","/api-gateway.jar","&"]