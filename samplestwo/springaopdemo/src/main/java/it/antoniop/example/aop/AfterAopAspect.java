package it.antoniop.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


// We want AOP !!
// This class contains  Configuration !!!
@Aspect
@Configuration
public class AfterAopAspect {

    private Logger logger = LoggerFactory.getLogger(AfterAopAspect.class);

    @AfterReturning(value = "execution(* it.antoniop.example.aop.business.*.*(..))", returning = "result")
    public void doItAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info(" **@AfterReturning** '{}' returned with value '{}'", joinPoint, result);
    }
    

    @After(value = "execution(* it.antoniop.example.aop.business.*.*(..))")
    public void pleaseDotItAfter(JoinPoint joinPoint) {
        logger.info(" **@After** after execution of '{}'", joinPoint);

    }
	
}
