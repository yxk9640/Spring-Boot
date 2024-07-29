# Getting Started
## Description
This part of the microservice focuses on getting data from public api.
Files that help to achieve this task are:

1. `config > WebClientConfig` 
2. `Service > WebClientService`
3. `Service > Impl > WebClientServiceImpl.java`
4. `Listener > !KafkaListeners`

### Configuration
1. Visit spring initializer and select the latest version for the configurations.
2. Use Gradle Groove, jar for the project config
3. Select further dependencies
   1. Spring Dev Tools.
   2. Redis supporter.
   3. Kafka supporting dependencies.
4. Change application.properties to `application.yml`
5. Add dependencies for kafka, redis, news API in `application.yml`



### Reference Official Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/#build-image)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.nosql.redis)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)

#### Guides
The following guides illustrate how to use some features concretely:

* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

#### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

