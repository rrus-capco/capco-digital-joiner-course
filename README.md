## Gradle
To run application with gradle wrapper:
```
./gradlew bootRun
```
## Docker
To create docker image for application:
```
./gradlew build
docker build --build-arg JAR_FILE=build/libs/*.jar -t capco-new-joiner-app .
docker run -p 8090:8090 capco-new-joiner-app

or

./gradlew dockerBuild
```

To run application in docker container from image previously built:
```
docker run -p 8090:8090 capco-new-joiner-app
```

To build docker image and run application in docker container:
```
./gradlew dockerRun
```

## API Documentation
To view Swagger API documentation, first run the application and then go to http://localhost:8090/swagger-ui.html in your browser