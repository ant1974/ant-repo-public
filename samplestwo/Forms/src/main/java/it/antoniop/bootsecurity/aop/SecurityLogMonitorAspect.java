package it.antoniop.bootsecurity.aop;

import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import it.antoniop.bootsecurity.security.UserPrincipal;

@Aspect
@Component
public class SecurityLogMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityLogMonitorAspect.class);
    

    // @Before("execution(* it.antoniop.bootsecurity.security.UserPrincipalDetailsService.*(..))")
    @Before("execution(* it.antoniop.bootsecurity.db.UserRepository.find*(..))")
    public void beforeAdviceActingAsLogUserInMonitor(JoinPoint joinPoint)  {
    	Object[] args = joinPoint.getArgs();
		String name = (String) args[0];
		
        //Get intercepted method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" *AP* @Before Advice \"Who's knocking at this door?\" .. ");
		sb.append(" Somebody named '");
		sb.append(name);
		sb.append("'");
		sb.append(" is trying to log in calling:  [");
		sb.append(className);
		sb.append(".");
		sb.append(methodName);
		sb.append("() ] *AP*");
		// //
		LOGGER.info(sb.toString());
    } 

   
    @AfterReturning(value = "execution(* it.antoniop.bootsecurity.security.UserPrincipalDetailsService.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    	
    	Object[] args = joinPoint.getArgs();
		String name = (String) args[0];
		
        //Get intercepted method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" *AP* @AfterReturning Advice (1) (Only return normally ... NOT when throwing an exception) ...  *AP* ");
		LOGGER.info(sb.toString());
		
		String csvAuth = ""; 
		
		if (result!=null) {
			Collection<? extends GrantedAuthority> list = ((UserPrincipal) result).getAuthorities();
			for (GrantedAuthority grantedAuthority : list) {
				csvAuth = csvAuth + grantedAuthority.getAuthority();
				csvAuth = csvAuth + ",";
			}
			if (!csvAuth.isEmpty()) {
				csvAuth = csvAuth.substring(0, csvAuth.lastIndexOf(","));
			}
		}
		
		// 
		sb = new StringBuffer();
		sb.append(" *AP* @AfterReturning Advice (2) '");
		sb.append(name);
		sb.append("'");
		sb.append(" had [" + csvAuth  +"] as a result when trying to log in calling:  [");
		sb.append(className);
		sb.append(".");
		sb.append(methodName);
		sb.append("() ] *AP* ");
		// //
		LOGGER.info(sb.toString());
    }
    
}

