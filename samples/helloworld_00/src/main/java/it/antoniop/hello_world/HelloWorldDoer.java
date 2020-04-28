package it.antoniop.hello_world;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldDoer {

	@RequestMapping(path = "/sayHello")
	public String sayHello(@RequestParam(value = "name", defaultValue = "Marco", required = false) String name) {
		//
		return "Hello to SpringBoot World! Welcome <span style='font-weight: bold; color: blue'>" + name + " ... </span>";
	}
}
