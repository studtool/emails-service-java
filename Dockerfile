FROM openjdk:12.0-jdk as base
WORKDIR /tmp
COPY . .
RUN ./gradlew build \
    && cp $(./gradlew -q printJarPath) ./service.jar

FROM openjdk:12.0-jdk
WORKDIR /tmp
COPY --from=base /tmp/service.jar ./service.jar
ENTRYPOINT ["java", "-jar", "./service.jar"]
