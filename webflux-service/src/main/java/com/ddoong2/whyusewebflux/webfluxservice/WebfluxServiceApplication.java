package com.ddoong2.whyusewebflux.webfluxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class WebfluxServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxServiceApplication.class, args);
    }

}
