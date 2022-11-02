package com.ddoong2.whyusewebflux.webmvcservice.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {

        return new RestTemplateBuilder(restTemplate -> {
            final HttpComponentsClientHttpRequestFactory factory
                    = new HttpComponentsClientHttpRequestFactory();
            final HttpClient client = HttpClientBuilder.create()
                    .setMaxConnTotal(200)
                    .setMaxConnPerRoute(200)
                    .build();
            factory.setHttpClient(client);
            factory.setConnectTimeout(2000);
            factory.setReadTimeout(10000);
            restTemplate.setRequestFactory(factory);
        });
    }

}
