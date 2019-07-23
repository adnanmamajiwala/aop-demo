package com.demo.aop.aspects;

import com.demo.aop.models.SampleModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Properties;

@Aspect
public class ServiceAspect {

    @Around("execution(* com.demo.aop.services.NonSpringService.hello(..)) && args(properties)")
    public Object logServiceAccessAround(ProceedingJoinPoint joinPoint, Properties properties) throws Throwable {

        System.out.println("properties.getProperty(\"something\") = " + properties.getProperty("something"));
        System.out.println("Setting the value of property 'something' to 'this value was set from aspect'");
//        properties = new Properties();
        properties.setProperty("something", "this value was set from aspect");


        System.out.println("in the around");
        System.out.println("-------------------------");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------");

        return joinPoint.proceed(new Object[]{properties});
    }

    @Around("execution(* org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(..)) && args(object)")
    public Object reflectionToStringAccessAround(ProceedingJoinPoint joinPoint, Object object) throws Throwable {

        System.out.println("-------------------------");
        System.out.println("Inside around [reflectionToStringAccessAround= " + object + "]");
        System.out.println("  Completed: " + joinPoint);
        System.out.println("-------------------------\n");

        object = new SampleModel("New value injected");

        return joinPoint.proceed(new Object[]{object});
    }

}