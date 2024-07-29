# Getting Started
## Description
This part of the microservice focuses on requesting data to the topic from REST API.
Files that help to achieve this task are:
1. `config > KafkaProducerConfig`
2. `config > KafkaTopicConfig`
3. `Service > MessageService`
4. `Service > Impl > MessageService.java`

### Configuration
1. Visit spring initializer and select the latest version for the configurations.
2. Use Gradle Groove, jar for the project config
3. Select further dependencies
    1. Spring Dev Tools.
    2. Redis supporter.
    3. Kafka supporting dependencies.
4. Change application.properties to `application.yml`
5. Add dependencies for kafka, redis, news API in `application.yml`

## Note
This part of microservice has the starter-config files for Kafka and Redis in `docker-compose.yml`