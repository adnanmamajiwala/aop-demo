package com.demo.aop.services;

import java.util.Properties;

public class NonSpringService {

    public void hello(Properties properties){
        System.out.println("-------------------------");
        System.out.println("inside --- hello");
        System.out.println("-------------------------");

        System.out.println(properties.getProperty("something"));
    }
}
