package it.antoniop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import it.antoniop.example.aop.business.BusinessService1;
import it.antoniop.example.aop.business.BusinessService2;


@SpringBootTest
public class BusinessAopSpringBootTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BusinessService1 businessService1;

	@Autowired
	private BusinessService2 businessService2;

	@Test
	public void invokeAOPStuff() {
		logger.info(businessService1.calculateSomething());
		logger.info(businessService2.calculateSomething());
	}

}
