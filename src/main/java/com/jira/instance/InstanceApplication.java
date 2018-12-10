package com.jira.instance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstanceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(InstanceApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);

        springApplication.run(args);
    }
}
