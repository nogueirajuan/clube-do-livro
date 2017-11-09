FROM 10.51.163.76:5000/altice-br_basic_img_debian:latest

#
# Application Install
#
CMD  ["mkdir","/opt/shield/starktower/config"]
CMD  ["mkdir","/opt/shield/starktower/log"]
CMD  ["mkdir","/opt/shield/starktower/log/sip"]
CMD  ["mkdir","/opt/shield/starktower/media"]
ADD helicarrier-*.jar /opt/shield/starktower/app.jar
RUN sh -c 'touch /opt/shield/starktower/app.jar'

#
# JVM parameters
# 
#Only for Oracle Jdk
ENV JAVA_TOOL_OPTIONS "-Xms256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

EXPOSE 9000 8000
WORKDIR /opt/shield/starktower

ENTRYPOINT [ "sh", "-c", "java -jar /opt/shield/starktower/app.jar" ]

#docker run -p 9000:9000 -p 8000:8000 -e "CONT_INST=SKT_1" -e "CONT_TYPE=DEV" -v /opt/shield/starktower/config/:/opt/shield/starktower/config -v /tmp:/tmp -v /var/log/starktower:/opt/shield/starktower/log -v /opt/shield/starktower/media/:/opt/shield/starktower/media -v /var/log/starktower/:/opt/shield/starktower/log/sip -t shield:starktower-1.0-SNAPSHOT
