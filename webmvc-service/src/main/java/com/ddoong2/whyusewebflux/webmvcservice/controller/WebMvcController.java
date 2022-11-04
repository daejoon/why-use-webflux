package com.ddoong2.whyusewebflux.webmvcservice.controller;

import com.ddoong2.whyusewebflux.webmvcservice.service.WebMvcService;
import com.ddoong2.whyusewebflux.webmvcservice.service.response.WebMvcRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebMvcController {

    private final WebMvcService webMvcService;


    @GetMapping(value = "/message/{time}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public WebMvcRes getMessage(@PathVariable String time) {

        return webMvcService.getMessage(time);
    }


}
