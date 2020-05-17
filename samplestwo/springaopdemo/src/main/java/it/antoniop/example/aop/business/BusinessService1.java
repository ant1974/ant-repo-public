package it.antoniop.example.aop.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.antoniop.example.aop.model.Dao1;

@Service
public class BusinessService1 {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Dao1 dao1;

	public String calculateSomething() {
		// Business Logic
		String value = dao1.retrieveSomething();
		logger.info("In Business - {}", value);
		return value;

	}
}
