FROM openjdk:20

WORKDIR /app

COPY build/libs/createCar-0.0.1-SNAPSHOT.jar /app/createCar-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/createCar-0.0.1-SNAPSHOT.jar"]