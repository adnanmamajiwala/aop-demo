package com.demo.aop.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonSpringServiceTest {

    @Test
    public void name() {
        NonSpringService service = new NonSpringService();
        service.hello(new Properties());
//        services.hello();
    }

}