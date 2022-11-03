package com.ddoong2.whyusewebflux.lazyservice;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class LazyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyServiceApplication.class, args);
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class LazyMessage {
        private String message;
    }


    @Slf4j
    @RestController
    public static class LazyController {

        @Value("${spring.application.name}")
        private String applicationName;

        @GetMapping("/wait/{time}")
        public LazyMessage wait(@PathVariable Long time) {
            final int millis = (int) (Math.random() * time + 0);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info(String.format("%s - %d millisecond", applicationName, millis));
            return LazyMessage.builder()
                    .message(String.format("%s - %d millisecond", applicationName, millis))
                    .build();
        }

    }
}
