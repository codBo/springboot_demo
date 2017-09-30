package com.example.demo.controller;

import com.example.demo.dto.ResponseMessage;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by brian on 2017/8/24.
 */
@RestController
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

}
