package com.ddoong2.whyusewebflux.webfluxservice.handler;

import com.ddoong2.whyusewebflux.webfluxservice.service.WebFluxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebFluxHandler {
    private final WebFluxService webFluxService;

    public static final String MESSAGE_URL = "/message/{time}";
    public Mono<ServerResponse> message(ServerRequest request) {

        final String time = request.pathVariable("time");
        return webFluxService.getMessage(time)
                .flatMap(webFluxRes ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(fromValue(webFluxRes))
                                .switchIfEmpty(ServerResponse.notFound().build())
                );
    }

}
