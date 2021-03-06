package com.example.demo.controller;

import com.example.demo.dto.ResponseMessage;
import com.example.demo.dto.Apple;
import com.example.demo.entity.Resource;
import com.example.demo.exception.MyException;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by brian on 2017/8/24.
 */
@RestController
@Slf4j
@RequestMapping(value="/resources")
public class DemoController {

    @Value("${com.example.demo.name}")
    private String name;
    @Value("${com.example.demo.title:Random.Int[1,4]}")
    private String title;

    private ResourceRepository resourceRepository;

    @Autowired
    public DemoController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public ResponseMessage findAll() {

        List<Resource> resource = resourceRepository.findAll();
        return MessageUtil.getSuccessMessage(resource);
    }

    @PostMapping
    public ResponseMessage create(@RequestBody Resource resource) {

        Resource resource1  = resourceRepository.save(resource);
        return MessageUtil.getSuccessMessage(resource1);
    }

    @GetMapping("/testJpaConverter")
    public Object test() throws IOException {

        Apple apple = new Apple();
        apple.setColor("sdf");
        ObjectMapper objectMapper = new ObjectMapper();
        String a = objectMapper.writeValueAsString(apple);
        return objectMapper.readValue(a, Object.class);
    }
    @GetMapping("/testStatic")
    public Object testStatic() throws InterruptedException {

        return MessageUtil.getCount();
    }
    @GetMapping("/testStaticV2")
    public Object testStaticV2() {

        return MessageUtil.getCountV2();
    }

    @GetMapping("/error")
    public Object error() throws Exception {
        throw new Exception();
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
    @RequestMapping("/testLogging")
    public void testLogging() {

        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
    }
}
