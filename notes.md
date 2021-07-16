### user table structrue
create table user (
id integer not null, 
birth_date timestamp, 
name varchar(255), 
primary key (id)
)

#Richardson Maturity Model
Level 0 - expose SOAP web services in Rest style
ex: http://server/getPosts
ex: http://server/deletePosts
ex: http://server/doThis

Level 1: Expose Resources with proper URIs
ex: http://server/posts
ex: http://server/posts/10
Note: improper user of HTTP

Level 2: level 1 + http method

Level 3: level 2 + HATEOS
Data + next possible action

#Best practice
Consumer first - think from the perspective of your consumer
Great Documentation - Make sure your consumer understands it well
Best use of HTTP method - GET, POST, DELETE, PUT, 
RESPONSE STATUS - 
200 -SUCCESS
404- RESOURCE NOT FOUND
400 - BAD Request
201 - Created
401- UNAUTHORIZED
500- SERVER ERROR

NO SECURE INFO in URI

Use PLURAL
-Prefer users to /user

Use Nouns for Resources but exception is everywhere ( be consistent in approaching these exceptions)

exception - /search
PUT /gists/{id}/start
DELETE /gists/{id}/start


SECTION-4: Introduction to microservices
small autonomous services which works together
--> REST
--> Small well-chosen deployable unit
--> cloud enabled (multiple instances of services) (easy to up and take down these instances)

Challenges with microservices ->
            Bounded Context -> boundary of each microservice
        Deciding the boundary of service is an evolutionary process.

        Configuration Management
        Mulitple environment - > 10 microservice and 5 environment --> lots of configuration

        Dynamic load balancing.

Visibility: functionality broken into mulitple frequency
how you find the bug. Monitoring

PACK of CARDS: 
Fault tolerance

**Introduction to Spring Cloud**

        Configuraton management -> Use Spring Cloud Config Server stores all configuration 
        into git repository

        Dynamic Scale up and scale down -> Solution
        Naming Server --> Eureka (service -discovery)
        Ribbon --> client side load balancing
        Feign -> to write simple Restful clien

        visibility and maintainablity ->
        Zipking distributing tracing
        Netflix API gateways(zool)

        Fault tolerance ->
        Hystrix

**Advantage of microservices**

*Dynamic Scaling*

**Ports**

    Application	Port
    Limits Service	8080, 8081, ...
    Spring Cloud Config Server	8888
    Currency Exchange Service	8000, 8001, 8002, ..
    Currency Conversion Service	8100, 8101, 8102, ...
    Netflix Eureka Naming Server	8761
    Netflix Zuul API Gateway Server	8765
    Zipkin Distributed Tracing Server	9411
**URLs**

    Application	URL
    Limits Service	http://localhost:8080/limits http://localhost:8080/actuator/refresh (POST)
    Spring Cloud Config Server	http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev
    Currency Converter Service - Direct Call	http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10
    Currency Converter Service - Feign	http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000
    Currency Exchange Service	http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR
    Eureka	http://localhost:8761/
    Zuul - Currency Exchange & Exchange Services	http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10
    Zipkin	http://localhost:9411/zipkin/
    Spring Cloud Bus Refresh	http://localhost:8080/actuator/bus-refresh (POST)






