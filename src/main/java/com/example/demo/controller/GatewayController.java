package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by brian on 2017/11/15.
 */
@Slf4j
@RestController
public class GatewayController {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/gateway/test")
    public void getRestemplateErrorBody() {

        String url = "http://127.0.0.1:8080";
        try {
            restTemplate.getForObject(url+ "/users", Object.class);
        } catch (HttpStatusCodeException e) {
            log.error(e.getResponseBodyAsString());
        }
    }

}
