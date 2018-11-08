package com.demo.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Properties;

@Aspect
public class ServiceAspect {

    @Around("execution(* com.demo.aop.services.NonSpringService.hello(..)) && args(properties)")
    public Object logServiceAccessAround(ProceedingJoinPoint joinPoint, Properties properties) throws Throwable {
        System.out.println("Inside around  [properties.getProperty('something')=" + properties.getProperty("something") + "]");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("------------------------- \n");

        properties = new Properties();
        properties.setProperty("something", "from aspect");
        return joinPoint.proceed(new Object[]{properties});
    }

    //    @Before("execution(* com.demo.aop.services.NonSpringService.hello(..)) && args(properties)")
    public void logServiceAccess(JoinPoint joinPoint, Properties properties) {
        System.out.println("inside before");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------");
    }

    @Around("execution(* com.demo.aop.services.SpringService.greetings(..)) && args(properties)")
    public Object greetingsAccessAround(ProceedingJoinPoint joinPoint, Properties properties) throws Throwable {

        System.out.println("Inside around  [properties.getProperty('greetings')=" + properties.getProperty("greetings") + "]");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------\n");

        properties = new Properties();
        properties.setProperty("greetings", "aspect set this");

        return joinPoint.proceed(new Object[]{properties});
    }

}