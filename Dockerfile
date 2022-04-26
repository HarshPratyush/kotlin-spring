FROM openjdk:11 as build
MAINTAINER Harsh Pratyush
ADD . .
CMD ./gradlew build

FROM adoptopenjdk/openjdk11

ARG JAR_FILE=build/libs/*.jar
COPY --from=build ${JAR_FILE} kotlin-api.jar

ENTRYPOINT ["java", "-jar", "kotlin-api.jar"]