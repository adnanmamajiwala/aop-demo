package com.demo.aop.services;

import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SpringService {

    public void greetings(Properties properties){
        System.out.println("-------------------------");
        System.out.println("inside --- hello");
        System.out.println("-------------------------");
        System.out.println("[properties.getProperty('greetings')=" + properties.getProperty("greetings") + "]");
    }
}
