package com.ddoong2.whyusewebflux.webmvcservice.service.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WebMvcRes {
    private String message;
    public void addMessage(final String addMessage) {
        this.message = addMessage + " | " + message;
    }
}
