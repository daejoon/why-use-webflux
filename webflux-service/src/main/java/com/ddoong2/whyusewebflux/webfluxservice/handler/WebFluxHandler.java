package com.ddoong2.whyusewebflux.webfluxservice.handler;

import com.ddoong2.whyusewebflux.webfluxservice.service.WebFluxService;
import com.ddoong2.whyusewebflux.webfluxservice.service.response.WebFluxRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebFluxHandler {

    private final WebFluxService webFluxService;

    public Mono<ServerResponse> message(ServerRequest request) {

        return ServerResponse.ok()
                .body(webFluxService.getMessage(), WebFluxRes.class);
    }

}
