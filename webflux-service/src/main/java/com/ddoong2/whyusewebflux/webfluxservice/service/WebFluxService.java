package com.ddoong2.whyusewebflux.webfluxservice.service;

import com.ddoong2.whyusewebflux.webfluxservice.config.properties.ExternalProperties;
import com.ddoong2.whyusewebflux.webfluxservice.service.response.WebFluxRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebFluxService {

    private final ExternalProperties externalProperties;
    private final WebClient.Builder builder;

    @Value("${spring.application.name}")
    private String applicationName;


    public Mono<WebFluxRes> getMessage(final String time) {

        final WebClient client = builder
                .baseUrl(UriComponentsBuilder
                        .fromHttpUrl(externalProperties.getServiceHost() + "/wait/{time}")
                        .buildAndExpand(time)
                        .toUriString())
                .build();

        return client.get()
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(WebFluxRes.class)
                        .map(webFluxRes -> {
                            log.info("response: {}", webFluxRes);
                            webFluxRes.addMessage(applicationName);
                            return webFluxRes;
                        }));
    }
}
