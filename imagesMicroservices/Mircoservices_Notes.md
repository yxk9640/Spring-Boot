# Microservices

When you get a project to add in this folder change the current folder structure.

current:

	-|imagesMicroservice
	
update:
	
	-|MicroServices
	--|images
	--|version-project

## Intro 
The services which use to handle whole application is revised to manage small/micro tasks of the application.
These services should be REST enabled, small and well choosen deployable boundaries and have ![multiple instances(cloud enabled).](./imagesMicroservices/cloud_instance.png)

### Challenges 
- Limiting operations/scope of a service
- Configuration -> 10 micro-service, 5 env and 50 multiple instances will have huge config <- how to do it?
- Scale up and down -> Done by dynamic load balancing ( how to scale and when to scale)
- Visibility -> identifying the bug so have centralised log as Anil bro told maintain X-Request-ID
- Strong Architecture and have Fault tolerance 

Spring cloud addresses most of the challenges mentioned above.

- *Config* -> Spring Cloud will store all the config in git server and **SpringCloudConfigServer** will expose all these.
<img src="./imagesMicroservices/SprinCloudConfigServer.png" alt="SpringCloudConfigServer" 100 width="350" height="280" />

- *Load Balancing* -> Naming Server will handle load on all these instances. We use Naming server(service registration and service discovery)`Eureka`, client side load balance `Ribbon`.
- *Visiblity* -> Distributed tracing to trace the request. (Log, Security, Analytics) all features are handled by API GateWay 
- *Falut Tolerance* -> Tools available to sent Response to the client when a service is down. 


> Eureka - Naming Server
> 
> Ribbon - Client side load balancer
> 
> Feign - Easy REST mechanism
> 
> Zipkin - Tracing all microservices
> 
> Netflix API Gateway - Implement Common features among all MicroServices
> 
> Hystrix - Fault Tolerance

### Adv of MicroService Arch
- Flexibility of New Diverse Tech/language
- Scaling
- Fast Release Cycle


### Microservices Environment




