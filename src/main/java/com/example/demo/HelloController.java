package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brian on 2017/8/24.
 */
@RestController
@RequestMapping(value="/hellos")
public class HelloController {

    @GetMapping
    public String hello() {

        return "hello world";
    }
}
