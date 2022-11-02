package com.ddoong2.whyusewebflux.webmvcservice.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "external")
@ConstructorBinding
@Getter
@AllArgsConstructor
public class ExternalProperties {
    private final String serviceHost;
}
