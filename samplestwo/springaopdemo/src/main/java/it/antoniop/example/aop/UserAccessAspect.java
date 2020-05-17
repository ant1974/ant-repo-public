package it.antoniop.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);

    // What kind of method calls I would intercept
    // execution(* PACKAGE.*.*(..))
    // Weaving & Weaver
    @Before("execution(* it.antoniop.example.aop.model.*.*(..))")
    public void doItBeforeButNameIsNotThatImportant(JoinPoint joinPoint) {
        //Advice
        logger.info(" **@Before** Check for user access ... U can use \"joinPoint\" in input JoinPoint instance ");
        logger.info(" **@Before** Allowed execution for '{}'", joinPoint);

    }
	
}
