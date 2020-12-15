# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8u141-jre
VOLUME /tmp
#ADD target/RMIServer-1.0-SNAPSHOT.jar app.jar
ADD out/artifacts/RMIServer.jar server.jar
ENTRYPOINT exec java -jar server.jar

