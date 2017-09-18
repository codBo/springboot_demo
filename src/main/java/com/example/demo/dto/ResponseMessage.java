package com.example.demo.dto;

import lombok.Data;

/**
 * Created by brian on 2017/9/16.
 */
@Data
public class ResponseMessage <T>{

    private Integer code;

    private String message;

    private T data;

}
