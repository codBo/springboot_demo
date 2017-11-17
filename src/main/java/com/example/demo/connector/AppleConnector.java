package com.example.demo.connector;

import com.example.demo.dto.Apple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by brian on 2017/9/29.
 */
@Component("connector.AppleConnector")
public class AppleConnector {

    private static final RestTemplate restTemplate = new RestTemplate();
    @Value(value = "${core.apple.url:127.0.0.1:8080}")
    private String baseUrl;

    public Apple create(Apple apple) {

        return restTemplate.postForObject(baseUrl, apple, Apple.class);
    }
}
