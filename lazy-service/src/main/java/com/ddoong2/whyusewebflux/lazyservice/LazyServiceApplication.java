package com.ddoong2.whyusewebflux.lazyservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LazyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyServiceApplication.class, args);
    }


    @Slf4j
    @RestController
    public static class LazyController {

        @GetMapping("/wait/{time}")
        public String wait(@PathVariable Integer time) {
            try {
                Thread.sleep(time.longValue());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return String.format("%d millisecond", time.longValue());
        }

    }
}
