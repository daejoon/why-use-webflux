package com.ddoong2.whyusewebflux.webfluxservice.service.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WebFluxRes {
    private String message;

    public void addMessage(final String addMessage) {
        this.message = addMessage + " | " + message;
    }
}
