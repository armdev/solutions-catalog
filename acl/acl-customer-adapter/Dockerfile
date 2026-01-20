FROM bellsoft/liberica-openjdk-alpine:25.0.1-cds

# Create non-root user and app directory
RUN adduser -D -h /home/stmt2076x -s /bin/sh stmt2076x \
    && mkdir -p /opt/app \
    && chown -R stmt2076x:stmt2076x /opt/app


COPY target/acl-customer-adapter.jar /opt/app/acl-customer-adapter.jar

USER stmt2076x

EXPOSE 9090 3001

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS \
    --add-opens=java.base/java.time.zone=ALL-UNNAMED \
    --add-opens=java.base/java.time=ALL-UNNAMED \
    --add-opens=java.base/java.math=ALL-UNNAMED \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.management/sun.management=ALL-UNNAMED \
    --enable-native-access=ALL-UNNAMED \
    --enable-preview \
    -XX:+UseZGC \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:+ExitOnOutOfMemoryError \
    -XX:InitialRAMPercentage=25.0 \
    -XX:MaxRAMPercentage=70.0 \
    -Xss2m \
    -Dsun.net.inetaddr.ttl=60 \
    -Dsun.net.client.defaultConnectTimeout=10000 \
    -Dsun.net.client.defaultReadTimeout=30000 \
    -Djava.security.egd=file:/dev/urandom \
    -XshowSettings:vm \
    -jar /opt/app/acl-customer-adapter.jar"]





