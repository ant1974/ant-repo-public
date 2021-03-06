package it.antoniop.bootsecurity.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;


/**
 * 
 * @Component Indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detection
 * when using annotation-based configuration and classpath scanning.
 *
 * <p>Other class-level annotations may be considered as identifying
 * a component as well, typically a special kind of component:
 * e.g. the {@link Repository @Repository} annotation or AspectJ's
 * {@link org.aspectj.lang.annotation.Aspect @Aspect} annotation.
 *
 */
@Aspect
@Component
public class SecurityAroundUserServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityAroundUserServiceAspect.class);
    

    @Around("execution(* it.antoniop.bootsecurity.security.UserPrincipalDetailsService.*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        /*
         *  org.springframework.util.StopWatch
         *
         *      Simple stop watch, allowing for timing of a number of tasks, exposing total running time and running time for each named task. 
         *      Conceals use of System.nanoTime(), improving the readability of application code and reducing the likelihood of calculation errors. 
         *      Note that this object is not designed to be thread-safe and does not use synchronization. 
         *      This class is normally used to verify performance during proof-of-concept work and in development, 
         *      rather than as part of production applications. 
         * 
         */
        StopWatch stopWatch = new StopWatch();
          
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        StringBuilder sb = createTimeTraceMessage(className, methodName, stopWatch);
        // //
        if (LOGGER.isInfoEnabled()) {
        	LOGGER.info(sb.toString());
        }
        

        return result;
    }


    /*
     * 
     * @param className
     * @param methodName
     * @param stopWatch
     * @return
     */
	private StringBuilder createTimeTraceMessage(String className, String methodName, StopWatch stopWatch) {
		// Log method execution time
        StringBuilder sb = new StringBuilder();
        sb.append(" *AROUND* Execution time of ");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append(" :: ");
        sb.append(stopWatch.getTotalTimeMillis());
        sb.append(" ms *AROUND* ");
		return sb;
	}
}
