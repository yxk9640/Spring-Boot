### Description
A project to understand the basic working of `kafka message broker` implementation. 

1. `localhost:8080/message=?` will be called from client side 
2. Then the REST controller is loaded. This REST controller is subscribed to a message topic 'news' and produces requests for it.
3. The Consumer will request data from public api and loads in to redis and the topic
4. Then the producer will be able to access the data.


