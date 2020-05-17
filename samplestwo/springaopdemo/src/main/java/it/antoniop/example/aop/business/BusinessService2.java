package it.antoniop.example.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.antoniop.example.aop.model.Dao2;

@Service
public class BusinessService2 {

	@Autowired
	private Dao2 dao2;

	public String calculateSomething() {
		// Business Logic
		return dao2.retrieveSomething();

	}

}