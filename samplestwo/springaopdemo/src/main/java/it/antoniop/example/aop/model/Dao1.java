package it.antoniop.example.aop.model;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public String retrieveSomething() {
		return "Something done by Dao1";
	}

}
