package com.example.demo.dto;


import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Created by brian on 2017/9/16.
 */
@Data
public class User {

    private Long id;

    private String username;

    private Integer age;

    public User(String name, Integer age) {
        this.username = name;
        this.age = age;
    }

}
