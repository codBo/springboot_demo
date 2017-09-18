package com.example.demo;

import com.example.demo.dto.ResponseMessage;
import com.example.demo.entity.resource;
import com.example.demo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Value("${com.example.demo.title}")
    private String title;

    private ResourceRepository resourceRepository;

    @Autowired
    public DemoController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public ResponseMessage<List<resource>> findAll() {

        List<resource> resource = resourceRepository.findAll();
        ResponseMessage<List<resource>> resources = new ResponseMessage<>();
        resources.setData(resource);
        return resources ;
    }


}
