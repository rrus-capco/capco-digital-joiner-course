## Gradle
To run application with gradle wrapper:
```
./gradlew bootRun
```
## Docker
To create docker image for application:
```
./gradlew build
docker build --build-arg JAR_FILE=build/libs/*.jar -t ryanrush/rrus-capco-digitalengineeringcourse .
docker run -p 8090:8090 ryanrush/rrus-capco-digitalengineeringcourse

or

./gradlew dockerBuild
```

To run application in docker container from image previously built:
```
docker run -p 8090:8090 ryanrush/rrus-capco-digitalengineeringcourse
```

To build docker image and run application in docker container:
```
./gradlew dockerRun
```

To push docker image to docker hub:
```
docker push ryanrush/rrus-capco-digitalengineeringcourse
```

## API Documentation
To view Swagger API documentation, first run the application and then go to http://localhost:8090/swagger-ui.html in your browser