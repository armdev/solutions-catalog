FROM bellsoft/liberica-openjdk-alpine:25-cds

# Create non-root user and app directory
RUN adduser -D -h /home/notSec2075 -s /bin/sh notSec2075 \
    && mkdir -p /opt/app \
    && chown -R notSec2075:notSec2075 /opt/app

# Copy application JAR
COPY target/backend.jar /opt/app/backend.jar

USER notSec2075

EXPOSE 2024 3001

# Use JAVA_OPTS for flexible memory tuning
ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS \
    --add-opens=java.base/java.time=ALL-UNNAMED \
    --add-opens=java.base/java.math=ALL-UNNAMED \
    --add-opens=java.base/java.lang=ALL-UNNAMED \
    --add-opens=java.management/sun.management=ALL-UNNAMED \
    --enable-preview \
    -XX:+UseZGC \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:+ExitOnOutOfMemoryError \
    -XX:InitialRAMPercentage=25.0 \
    -XX:MaxRAMPercentage=70.0 \
    -Xss1m \
    -Dsun.net.inetaddr.ttl=60 \
    -Dsun.net.client.defaultConnectTimeout=10000 \
    -Dsun.net.client.defaultReadTimeout=30000 \
    -Djava.security.egd=file:/dev/urandom \
    -XshowSettings:vm \
    -jar /opt/app/backend.jar"]
