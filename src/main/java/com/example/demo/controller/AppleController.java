package com.example.demo.controller;

import com.example.demo.entity.Apple;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brian on 2017/9/27.
 */
@RestController
@RequestMapping("/apples")
public class AppleController {

    @PostMapping
    public Apple create(@RequestBody Apple apple) {
        System.out.println(apple);
        return apple;
    }
}
