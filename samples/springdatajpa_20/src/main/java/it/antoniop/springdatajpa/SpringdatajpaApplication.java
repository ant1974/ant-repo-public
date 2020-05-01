package it.antoniop.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpaApplication {

	/* 
	 * Remember to include only JPA API annotations (javax.persistence.*) 
	 * to de-couple Hibernate from application code.
	 *  
	 */
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

}
