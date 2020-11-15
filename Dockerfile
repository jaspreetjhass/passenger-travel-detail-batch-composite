FROM openjdk:8
WORKDIR /app/passenger-batch/
ADD ./target/passenger-travel-batch-composite.jar ./
EXPOSE ${SERVER_PORT}
CMD ["java","-jar","passenger-travel-batch-composite.jar"]