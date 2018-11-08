package com.demo.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Properties;

@Aspect
public class ServiceAspect {

    @Around("execution(* com.demo.aop.services.NonSpringService.hello(..)) && args(properties)")
    public Object logServiceAccessAround(ProceedingJoinPoint joinPoint, Properties properties) throws Throwable {

        System.out.println(properties.getProperty("something"));
        properties = new Properties();
        properties.setProperty("something", "from aspect");

        System.out.println("in the around");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------");

        return joinPoint.proceed(new Object[]{properties});
    }

    @Before("execution(* com.demo.aop.services.NonSpringService.hello(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("in the before");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------");
    }

}