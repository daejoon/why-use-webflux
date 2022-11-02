package com.ddoong2.whyusewebflux.webfluxservice.config;

import com.ddoong2.whyusewebflux.webfluxservice.handler.WebFluxHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@EnableWebFlux
@Configuration
public class RouteConfig {

    @Bean
    public RouterFunction<ServerResponse> defaultRouter(WebFluxHandler handler) {

        return RouterFunctions.route()
                .GET("/message", handler::message)
                .build();
    }

}
