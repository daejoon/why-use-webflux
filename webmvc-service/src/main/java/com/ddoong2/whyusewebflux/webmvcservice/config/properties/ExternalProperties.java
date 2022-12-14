package com.ddoong2.whyusewebflux.webmvcservice.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "external")
@ConstructorBinding
@Getter
@RequiredArgsConstructor
public class ExternalProperties {
    private final String serviceHost;
}
