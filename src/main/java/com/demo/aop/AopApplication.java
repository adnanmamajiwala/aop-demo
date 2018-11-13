package com.demo.aop;

import com.demo.aop.models.SampleModel;
import com.demo.aop.services.NonSpringService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        NonSpringService service = new NonSpringService();
        service.hello(new Properties());
        System.out.println("---- Value now :" + ToStringBuilder.reflectionToString(new SampleModel("SomeName")));
    }
}
