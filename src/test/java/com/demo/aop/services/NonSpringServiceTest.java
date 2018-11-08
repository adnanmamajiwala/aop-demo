package com.demo.aop.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonSpringServiceTest {

    @Autowired
    private SpringService springService;

    @Test
    public void name() {
        NonSpringService service = new NonSpringService();
        service.hello(new Properties());
//        services.hello();
    }

    @Test
    public void anotherTest() {
        springService.greetings(new Properties());
    }
}