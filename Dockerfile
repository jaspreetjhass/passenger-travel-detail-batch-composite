FROM openjdk:8
WORKDIR /app/passenger-batch/
ADD ./target/passenger-travel-detail-batch-composite.jar ./
EXPOSE ${SERVER_PORT}
CMD ["java","-jar","passenger-travel-detail-batch-composite.jar"]