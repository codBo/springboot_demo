package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by mac on 09/09/2017.
 */
@Data
public class Color implements Serializable{

    private static final long serialVersionUID = 4125289746708872472L;

    private String thumb;
    private int    count;
    private String text;
    private String value;

}
