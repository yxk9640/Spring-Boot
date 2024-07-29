# FirstDropWizard

How to setup and start the FirstDropWizard application 

SetUp 
---
Official Way use the below 

* `$mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=[REPLACE WITH A VALID DROPWIZARD VERSION]`
* Current Version - 4.0.0
* Use this and add the names as the terminal prompts the queries.

Overview example to do it in a single go

`$ mvn archetype:generate -B -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.0 -Dgr oupId=com.firstProject -DartifactId=Firstdropwizard -Dversion=1.0-SNAPSHOT -Dpackage=com.FirstDropWizard -Dname=FirstDropWizard`

Run the Project
-
`$java -jar project.jar server config.yml`

We must include server, config.yml while running the project. In IntelliJ add these in parameters of run configuration.

Build and Run the project
---
1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/first-dropwizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
