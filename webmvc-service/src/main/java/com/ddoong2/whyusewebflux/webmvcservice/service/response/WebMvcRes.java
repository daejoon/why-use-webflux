package com.ddoong2.whyusewebflux.webmvcservice.service.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WebMvcRes {
    private String message;
    public void addMessage(final String addMessage) {
        this.message = addMessage + " | " + message;
    }
}
