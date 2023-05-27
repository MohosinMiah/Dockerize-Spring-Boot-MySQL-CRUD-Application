FROM eclipse-temurin:17

LABEL mentainer="mohosin.csm@gmail.com"

WORKDIR /app

COPY /target/post-0.0.1-SNAPSHOT.jar /app/post-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar" , "post-0.0.1-SNAPSHOT.jar" ]