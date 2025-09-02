#Base image for the Docker container
FROM maven:3.9.6-eclipse-temurin-21 AS build
#Sets the working directory inside the container
RUN mkdir /project
#Copy Files into the Container
COPY . /project
WORKDIR /project
#Build the Spring Boot Application
RUN mvn clean package -DskipTests

#build an image with a JRE and the compiled Java artifact. Debian-based
FROM eclipse-temurin:21-jre
#package manager. Install dumb-init
RUN apt-get update && apt-get install -y dumb-init && rm -rf /var/lib/apt/lists/*
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/task-manager-0.0.1-SNAPSHOT.jar /app/task-manager.jar
WORKDIR /app
#Set permissions
RUN chown -R javauser:javauser /app
USER javauser
#Declare the Application Port
EXPOSE 8080
#command that runs when the container starts
CMD ["dumb-init" "java" "-jar" "task-manager.jar"]