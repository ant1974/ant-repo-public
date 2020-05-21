Let's spend some time understanding the AOP terminology.
============================

Glossary
-----
* <b>Pointcut</b>: the expression used to define when a call to a method should be intercepted.<br> 
   	In the example code , <code>execution(* it.antoniop.example.aop.model.*.*(..))</code>   is   a   pointcut.	
   
* <b>Advice</b>: What do you want to do? An advice is the logic that you want to invoke when you intercept a method. 
   
* <b>Aspect</b>: A combination of defining when you want to intercept a method call (Pointcut) and what to do (Advice) is called an Aspect.
   
* <b>Join Point</b>: When the code is executed and the condition for pointcut is met, the advice is executed. The Join Point is a specific execution instance of an advice.
   
* <b>Weaver</b>: Weaver is the framework that implements AOP - AspectJ or Spring AOP.

  
  


There are five types of advice in aspectj AOP.
-----

* <b>@Before</b>: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
      
* <b>@AfterReturning</b>: Advice to be executed after a join point completes normally.
      
* <b>@AfterThrowing</b>: Advice to be executed if a method exits by throwing an exception.
      
* <b>@After</b>: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
      
* <b>@Around</b>: Advice that surrounds a join point such as a method invocation.

