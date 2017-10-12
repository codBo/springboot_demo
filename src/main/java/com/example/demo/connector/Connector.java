package com.example.demo.connector;

import com.example.demo.dto.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by brian on 2017/9/29.
 */
public abstract class Connector <T>{

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${core.vendor.url:127.0.0.1}")
    private String baseUrl;

    private String finalUrl;

    public abstract void setFinalUrl(String url);

    public Long create(T t) {

        Id id =  restTemplate.postForObject(baseUrl + finalUrl, t, Id.class);
        return (Long) id.getId();
    }

    public void update(T t) {

        restTemplate.patchForObject(finalUrl, t, null);
    }

    public T findOne() {

        Class<T> entityClass =(Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return restTemplate.getForObject(finalUrl, entityClass);
    }

    public Object[] findAll(String url) {

        return restTemplate.getForObject(finalUrl, Object[].class);
    }
}
