package com.ddoong2.whyusewebflux.webmvcservice.controller;

import com.ddoong2.whyusewebflux.webmvcservice.service.WebMvcService;
import com.ddoong2.whyusewebflux.webmvcservice.service.response.WebMvcRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebMvcController {

    private final WebMvcService webMvcService;


    @GetMapping("/message")
    public WebMvcRes getMessage() {

        return webMvcService.getMessage();
    }


}
