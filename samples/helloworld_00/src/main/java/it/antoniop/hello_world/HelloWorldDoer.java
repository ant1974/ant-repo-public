package it.antoniop.hello_world;


import org.springframework.beans.factory.annotation.Value;
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
	
    

    @Value("${default.surname}")
    private String surname;
    
    @Value("${default.name}")
    private String name;

	
	
	@RequestMapping(path = "/sayHi")
	public String sayHiProperly(@RequestParam(value = "name", required = false) String inName) {
		//
		String theName = inName==null ? this.name : inName;
		return "Hello to SpringBoot World! Welcome <span style='font-weight: bold; color: blue'>" + theName + " " + surname + " ... </span>";
	}
	
}
