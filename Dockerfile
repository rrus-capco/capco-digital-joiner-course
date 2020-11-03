FROM openjdk:8-jdk-alpine AS builder
RUN apk add git
RUN mkdir /app
RUN git clone https://github.com/rrus-capco/capco-digital-joiner-course.git /app
WORKDIR app
RUN ./gradlew clean bootJar

FROM openjdk:8-jdk-alpine
WORKDIR /Executables
COPY --from=builder /app/build/libs .
ENTRYPOINT ["java","-jar","capco-joiner-project-1.0-SNAPSHOT.jar"]