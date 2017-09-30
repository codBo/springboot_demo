package com.example.demo.controller;

import com.example.demo.connector.AppleConnector;
import com.example.demo.dto.ResponseMessage;
import com.example.demo.entity.Apple;
import com.example.demo.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by brian on 2017/9/27.
 */
@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private AppleConnector appleConnector;

    @PostMapping
    public Apple create(@RequestBody Apple apple) {

        return appleConnector.create(apple);
    }
}
