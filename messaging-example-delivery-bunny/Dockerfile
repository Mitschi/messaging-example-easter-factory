FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#OPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY target/messaging-example-delivery-bunny-1.0-SNAPSHOT.jar /app
ENTRYPOINT ["java","-cp","app:app/messaging-example-delivery-bunny-1.0-SNAPSHOT.jar","com.github.mitschi.deliveryBunny.DeliveryBunnyMain"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.github.mitschi.deliveryBunny.DeliveryBunnyMain"]