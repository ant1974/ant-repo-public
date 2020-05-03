Intro
============================
[Introducing Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-introducing-spring-boot)

Spring Boot makes it easy to create stand-alone, production-grade Spring-based Applications that you can run. We take an opinionated view of the Spring platform and third-party libraries, so that you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.

You can use Spring Boot to create Java applications that can be started by using java -jar or more traditional war deployments.

Our primary goals are:

* Provide a radically faster and widely accessible getting-started experience for all Spring development.
* Be opinionated out of the box but get out of the way quickly as requirements start to diverge from the defaults.
* Provide a range of non-functional features that are common to large classes of projects (such as embedded servers, security, metrics, health checks, and externalized configuration).
* Absolutely no code generation and no requirement for XML configuration.




<br/><br/>

Starters
============================
[Using boot starter](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter)

Starters are a set of convenient dependency descriptors that you can include in your application. You get a one-stop shop for all the 
Spring and related technologies that you need without having to hunt through sample code and copy-paste loads of dependency descriptors. 
For example, if you want to get started using Spring and JPA for database access, 
include the spring-boot-starter-data-jpa dependency in your project.




Spring Boot application starters
--------------

* ***<span style="color: red; font-size: 14pt">spring-boot-starter</span>***  
Core starter, including auto-configuration support, logging and YAML
	
* ***spring-boot-starter-activemq***  
Starter for JMS messaging using Apache ActiveMQ

* ***spring-boot-starter-amqp***  
Starter for using Spring AMQP and Rabbit MQ

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-aop</span>***  
Starter for aspect-oriented programming with Spring AOP and AspectJ

* ***spring-boot-starter-artemis***  
Starter for JMS messaging using Apache Artemis
	
* ***spring-boot-starter-batch***  
Starter for using Spring Batch

* ***spring-boot-starter-cache***  
Starter for using Spring Framework's caching support

* ***spring-boot-starter-cloud-connectors***  
Starter for using Spring Cloud Connectors which simplifies connecting to services in cloud platforms like Cloud Foundry and Heroku. Deprecated in favor of Java CFEnv
	
* ***spring-boot-starter-data-cassandra***  
Starter for using Cassandra distributed database and Spring Data Cassandra

* ***spring-boot-starter-data-cassandra-reactive***  
Starter for using Cassandra distributed database and Spring Data Cassandra Reactive

* ***spring-boot-starter-data-couchbase***  
Starter for using Couchbase document-oriented database and Spring Data Couchbase

* ***spring-boot-starter-data-couchbase-reactive***  
Starter for using Couchbase document-oriented database and Spring Data Couchbase Reactive

* ***spring-boot-starter-data-elasticsearch***  
Starter for using Elasticsearch search and analytics engine and Spring Data Elasticsearch
	
* ***<span style="color: red; font-size: 14pt">spring-boot-starter-data-jdbc</span>***  
Starter for using Spring Data JDBC

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-data-jpa</span>***  
Starter for using Spring Data JPA with Hibernate

* ***spring-boot-starter-data-ldap***  
Starter for using Spring Data LDAP

* ***spring-boot-starter-data-mongodb***  
Starter for using MongoDB document-oriented database and Spring Data MongoDB
	
* ***spring-boot-starter-data-mongodb-reactive***  
Starter for using MongoDB document-oriented database and Spring Data MongoDB Reactive

* ***spring-boot-starter-data-neo4j***  
Starter for using Neo4j graph database and Spring Data Neo4j

* ***spring-boot-starter-data-redis***  
Starter for using Redis key-value data store with Spring Data Redis and the Lettuce client

* ***spring-boot-starter-data-redis-reactive***  
Starter for using Redis key-value data store with Spring Data Redis reactive and the Lettuce client

* ***spring-boot-starter-data-rest***  
Starter for exposing Spring Data repositories over REST using Spring Data REST

* ***spring-boot-starter-data-solr***  
Starter for using the Apache Solr search platform with Spring Data Solr

* ***spring-boot-starter-freemarker***  
Starter for building MVC web applications using FreeMarker views

* ***spring-boot-starter-groovy-templates***  
Starter for building MVC web applications using Groovy Templates views

* ***spring-boot-starter-hateoas***  
Starter for building hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS

* ***spring-boot-starter-integration***  
Starter for using Spring Integration

* ***spring-boot-starter-jdbc***  
Starter for using JDBC with the HikariCP connection pool

* ***spring-boot-starter-jersey***  
Starter for building RESTful web applications using JAX-RS and Jersey. An alternative to spring-boot-starter-web

* ***spring-boot-starter-jooq***  
Starter for using jOOQ to access SQL databases. An alternative to spring-boot-starter-data-jpa or spring-boot-starter-jdbc

* ***spring-boot-starter-json***  
Starter for reading and writing json

* ***spring-boot-starter-jta-atomikos***  
Starter for JTA transactions using Atomikos

* ***spring-boot-starter-jta-bitronix***  
Starter for JTA transactions using Bitronix

* ***spring-boot-starter-mail***  
Starter for using Java Mail and Spring Framework's email sending support

* ***spring-boot-starter-mustache***  
Starter for building web applications using Mustache views	

* ***spring-boot-starter-oauth2-client***  
Starter for using Spring Security's OAuth2/OpenID Connect client features

* ***spring-boot-starter-oauth2-resource-server***  
Starter for using Spring Security's OAuth2 resource server features

* ***spring-boot-starter-quartz***  
Starter for using the Quartz scheduler

* ***spring-boot-starter-rsocket***  
Starter for building RSocket clients and servers.

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-security</span>***  
Starter for using Spring Security

* ***spring-boot-starter-test***  
Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-thymeleaf</span>***  
Starter for building MVC web applications using Thymeleaf views

* ***spring-boot-starter-validation***  
Starter for using Java Bean Validation with Hibernate Validator
	
* ***<span style="color: red; font-size: 14pt">spring-boot-starter-web</span>***  
Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container

* ***spring-boot-starter-web-services***  
Starter for using Spring Web Services

* ***spring-boot-starter-webflux***  
Starter for building WebFlux applications using Spring Framework's Reactive Web support

* ***spring-boot-starter-websocket***  
Starter for building WebSocket applications using Spring Framework's WebSocket support


Spring Boot production starters
---------------
* ***<span style="color: red; font-size: 14pt">spring-boot-starter-actuator</span>***  
Starter for using Spring Boot's Actuator which provides production ready features to help you monitor and manage your application


Spring Boot technical starters  
---------------
* ***spring-boot-starter-jetty***  
Starter for using Jetty as the embedded servlet container. An alternative to spring-boot-starter-tomcat
	
* ***<span style="color: red; font-size: 14pt">spring-boot-starter-log4j2</span>***  
Starter for using Log4j2 for logging. An alternative to spring-boot-starter-logging

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-logging</span>***  
Starter for logging using Logback. Default logging starter
	
* ***spring-boot-starter-reactor-netty***  
Starter for using Reactor Netty as the embedded reactive HTTP server.

* ***<span style="color: red; font-size: 14pt">spring-boot-starter-tomcat</span>***  
Starter for using Tomcat as the embedded servlet container. Default servlet container starter used by spring-boot-starter-web
	
* ***spring-boot-starter-undertow***  
Starter for using Undertow as the embedded servlet container. An alternative to spring-boot-starter-tomcat



<br/><br/>

Configuration Classes
============================
* [Auto Configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-auto-configuration)
* [Spring Beans and Dependency Injection](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-spring-beans-and-dependency-injection)
* [SpringBootApplication Annotation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-using-springbootapplication-annotation)


Spring Boot favors Java-based configuration. Although it is possible to use SpringApplication with XML sources, we generally recommend that your primary source be a single @Configuration class.
Usually the class that defines the main method is a good candidate as the primary @Configuration.


Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added. 
For example, if HSQLDB is on your classpath, and you have not manually configured any database connection beans, then Spring Boot auto-configures an in-memory database.

You need to opt-in to auto-configuration by adding the @EnableAutoConfiguration or @SpringBootApplication annotations to one of your @Configuration classes.
You should only ever add one @SpringBootApplication or @EnableAutoConfiguration annotation. We generally recommend that you add one or the other to your primary @Configuration class only.



You are free to use any of the standard Spring Framework techniques to define your beans and their injected dependencies. 
For simplicity, we often find that using @ComponentScan (to find your beans) and using @Autowired (to do constructor injection) works well.

If you structure your code as suggested above (locating your application class in a root package), you can add @ComponentScan 
without any arguments. All of your application components (@Component, @Service, @Repository, @Controller etc.) are automatically registered as Spring Beans.




Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class". 
A single @SpringBootApplication annotation can be used to enable those three features, that is:

	@EnableAutoConfiguration: enable Spring Boot's auto-configuration mechanism  

	@ComponentScan: enable @Component scan on the package where the application is located (see the best practices)  

	@Configuration: allow to register extra beans in the context or import additional configuration classes  




<br/><br/>

Running Your Application
============================
Running from an IDE
---------------
You can run a Spring Boot application from your IDE as a simple Java application. However, you first need to import your project. 
Import steps vary depending on your IDE and build system. Most IDEs can import Maven projects directly. For example, Eclipse users can select "Import"  >  "Existing Maven Projects" from the File menu.

Running as a Packaged Application
---------------
* `$ java -jar target/myapplication-0.0.1-SNAPSHOT.jar`

* `$ java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/myapplication-0.0.1-SNAPSHOT.jar`

* `$ java -jar target/myapplication-0.0.1-SNAPSHOT.jar --server.port=8082`

Using the Spring Maven Plugin
---------------
The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. Applications run in an exploded form, 
as they do in your IDE. The following example shows a typical Maven command to run a Spring Boot application:

* `$ mvnw spring-boot:run`

<br/>
<br/>

Exploring  Maven dependencies
================================

* `mvnw dependency:tree`








