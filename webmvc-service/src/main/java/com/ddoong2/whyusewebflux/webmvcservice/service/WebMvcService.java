package com.ddoong2.whyusewebflux.webmvcservice.service;

import com.ddoong2.whyusewebflux.webmvcservice.config.properties.ExternalProperties;
import com.ddoong2.whyusewebflux.webmvcservice.service.response.WebMvcRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebMvcService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final ExternalProperties externalProperties;

    @Value("${spring.application.name}")
    private String applicationName;

    public WebMvcRes getMessage() {

        final RestTemplate build = restTemplateBuilder
                .build();
        final WebMvcRes response = build.getForObject(externalProperties.getServiceHost() + "/wait/2000", WebMvcRes.class);
        response.addMessage(applicationName);
        return response;
    }
}
