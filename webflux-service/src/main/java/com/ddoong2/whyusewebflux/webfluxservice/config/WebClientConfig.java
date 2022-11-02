package com.ddoong2.whyusewebflux.webfluxservice.config;

import io.netty.channel.ChannelOption;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClientCustomizer customizer() {

        return webClientBuilder -> {
            final HttpClient client = HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                    .responseTimeout(Duration.ofMillis(10000));
            webClientBuilder.clientConnector(new ReactorClientHttpConnector(client));
        };
    }
}
