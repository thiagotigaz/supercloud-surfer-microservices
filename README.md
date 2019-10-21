# Super Cloud Surfer Microservices
The purpose of this project is to demonstrate the usage of spring cloud stack and some of the microservices patterns

# Components
| Component       | Port | Purpose |
|:----------------|:----:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| config-server   | 8888 | Serves configuration stored on git repository to all services                                                                                                                 | 
| eureka-server   | 8761 | Service Discovery, dinamically add/register new containers                                                                                                                    | 
| zuul-server     | 8765 | Server as a single entrypoint for all microservices, centralizes authentication                                                                                               | 
| uaa-server      | 9999 | Authorization server that issues JWT tokens                                                                                                                                                         | 
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
* [Using JHipster UAA for Microservice Security](https://www.jhipster.tech/using-uaa/)
* [Handle Security in Zuul, with OAuth2 and JWT](https://www.baeldung.com/spring-security-zuul-oauth-jwt)
* [Creating Self-Signed Certificate](https://dzone.com/articles/creating-self-signed-certificate)
* [Spring Microservices in Action](https://www.amazon.com/Spring-Microservices-Action-John-Carnell/dp/1617293989/ref=asc_df_1617293989/?tag=hyprod-20&linkCode=df0&hvadid=312140868236&hvpos=1o2&hvnetw=g&hvrand=11535336325122309593&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9031332&hvtargid=pla-381321456943&psc=1)
* [Building Microservices: Designing Fine-Grained Systems](https://www.amazon.com/Building-Microservices-Designing-Fine-Grained-Systems/dp/1491950358/ref=pd_bxgy_14_img_3/134-9274178-7206201?_encoding=UTF8&pd_rd_i=1491950358&pd_rd_r=41718b49-82b2-4da4-a7e7-df634c326204&pd_rd_w=EEysZ&pd_rd_wg=c791S&pf_rd_p=3edd75bb-e36e-488e-b666-80dd1a52c658&pf_rd_r=46EDYD28JS7YRYSHSBPV&psc=1&refRID=46EDYD28JS7YRYSHSBPV)
* [Microservices Patterns: With examples in Java](https://www.amazon.com/Microservices-Patterns-examples-Chris-Richardson/dp/1617294543/ref=pd_sbs_14_2/134-9274178-7206201?_encoding=UTF8&pd_rd_i=1617294543&pd_rd_r=f450dbe1-cece-4246-8644-e90881dc5a52&pd_rd_w=jPBpk&pd_rd_wg=7rA58&pf_rd_p=d66372fe-68a6-48a3-90ec-41d7f64212be&pf_rd_r=7DMW89E5PE8QXPX5GTB5&psc=1&refRID=7DMW89E5PE8QXPX5GTB5)
* [A pattern language for microservices](https://microservices.io/patterns/index.html)
* [Centralized Authorization with OAuth2 + JWT using Spring Boot 2](https://blog.marcosbarbero.com/centralized-authorization-jwt-spring-boot2/)
* [Microservices with Spring Boot and Spring Cloud. From config server to OAuth2 server (without inMemory things)](https://github.com/marcusdacoregio/oauth2-spring-boot)
