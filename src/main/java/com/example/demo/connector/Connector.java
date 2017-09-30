package com.example.demo.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;

/**
 * Created by brian on 2017/9/29.
 */
public class Connector <T>{

    @Autowired
    private RestTemplate restTemplate;

    private String baseUrl;

    public T create(T t, @RequestParam(defaultValue = "") String url) {

        Class<T> entityClass =(Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        t = restTemplate.postForObject(baseUrl + url, t, entityClass);
        return t;
    }
}
