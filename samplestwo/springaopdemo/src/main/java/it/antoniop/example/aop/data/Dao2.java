package it.antoniop.example.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String retrieveSomething() {
		return "Something done by Dao2";
	}

}
