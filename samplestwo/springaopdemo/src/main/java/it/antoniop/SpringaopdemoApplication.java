package it.antoniop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



/**
 *
 * Let’s spend some time understanding the AOP terminology.
 *
 *  	Pointcut: the expression used to define when a call to a method should be intercepted. 
 *  	In the example code , execution(* it.antoniop.example.aop.data.*.*(..))   is   a   pointcut.	
 *  
 *  	Advice: What do you want to do? An advice is the logic that you want to invoke when you intercept a method. 
 *  
 *  	Aspect: A combination of defining when you want to intercept a method call (Pointcut) and what to do (Advice) is called an Aspect.
 *  
 *  	Join Point: When the code is executed and the condition for pointcut is met, the advice is executed. The Join Point is a specific execution instance of an advice.
 *  
 *   	Weaver: Weaver is the framework that implements AOP - AspectJ or Spring AOP.
 *
 * 
 * 
 * There are five types of advice in aspectj AOP.
 * 
 * 	   @Before : Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
 * 	   @AfterReturning : Advice to be executed after a join point completes normally.
 * 	   @AfterThrowing : Advice to be executed if a method exits by throwing an exception.
 * 	   @After : Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
 * 	   @Around : Advice that surrounds a join point such as a method invocation.
 * 
 */


@SpringBootApplication
public class SpringaopdemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringaopdemoApplication.class, args);

        for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
	}

}
