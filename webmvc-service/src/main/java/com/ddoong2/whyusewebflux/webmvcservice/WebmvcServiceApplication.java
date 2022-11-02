package com.ddoong2.whyusewebflux.webmvcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class WebmvcServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmvcServiceApplication.class, args);
    }

}
