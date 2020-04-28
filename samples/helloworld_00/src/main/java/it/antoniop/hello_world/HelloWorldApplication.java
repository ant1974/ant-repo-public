package it.antoniop.hello_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

The @SpringBootApplication annotation adds the following annotations:

    @Configuration – which marks the class as a source of bean definitions
    @EnableAutoConfiguration – which tells the framework to add beans based on the dependencies on the classpath automatically
    @ComponentScan – which scans for other configurations and beans in the same package as the Application class or below

By default, the @SpringBootApplication annotation scans all classes in the same package or below.

*/


@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
