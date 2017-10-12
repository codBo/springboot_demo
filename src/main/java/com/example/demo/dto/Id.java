package com.example.demo.dto;

import lombok.Data;

/**
 * Created by brian on 2017/9/27.
 */
@Data
public class Id<T extends Number> {

    private T id;
    public Id() {}
    public Id(T id) {
        this.id = id;
    }
}
