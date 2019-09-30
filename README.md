# Super Cloud Surfer Microservices
The purpose of this project is to demonstrate the usage of spring cloud stack and some of the microservices patterns

# Components
| Component       | Port | Purpose |
|:----------------|:----:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| config-server   | 8888 | Serves configuration stored on git repository to all services                                                                                                                 | 
| eureka-server   | 8761 | Service Discovery, dinamically add/register new containers                                                                                                                    | 
| zuul-server     | 8765 | Server as a single entrypoint for all microservices, centralizes authentication                                                                                               | 
| zipkin-server   | 9411 | Distributed Tracing, tracks the microservices requests to other microservices, show failures between requests                                                                 | 
| zipkin-ui       | 80   | UI for zipkin service                                                                                                                                                         | 
| kafka-zookeeper | 9092 | Serves as a buffer for the zipkin server, the microservices pushes/produces the events to kafka stream and zipkin consumes the stream of events and persists to elasticsearch | 
| elasticsearch   | 9200 | Storage for zipkin server                                                                                                                                                     | 
| users-service   | 8001 | Manages User entity                                                                                                                                                           | 
| boards-service  | 8002 | Manages Board entity                                                                                                                                                          | 
| quivers-service | 8003 | Manages Quiver entity                                                                                                                                                         | 

## References
* [Master Microservices with Spring Boot and Spring Cloud](https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/)
* [A Guide to Spring Cloud Netflix – Hystrix](https://www.baeldung.com/spring-cloud-netflix-hystrix)
* [Hystrix CircuitBreaker and Feign](http://www.appsdeveloperblog.com/hystrix-circuitbreaker-and-feign/)
* [Zipkin docker github](https://github.com/openzipkin/docker-zipkin)
* [Monitoring Microservices With Spring Cloud Sleuth, ELK, and Zipkin](https://dzone.com/articles/monitoring-microservices-with-spring-cloud-sleuth)
* [Linkedin Learning - Spring: Spring Cloud](https://www.linkedin.com/learning/spring-spring-cloud)
