FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY target/messaging-example-hen-1.0-SNAPSHOT.jar /app
ENTRYPOINT ["java","-cp","app:app/messaging-example-hen-1.0-SNAPSHOT.jar","com.github.mitschi.hen.HenMain"]