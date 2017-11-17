package com.example.demo.entity;

import com.example.demo.dto.Color;
import com.example.demo.util.JpaConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by brian on 2017/9/16.
 */
@Entity
@Data
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Convert(converter = JpaConverter.class)
    private List<Color> insideColor;

    @Convert(converter = JpaConverter.class)
    private List<String> strings;

    private String name;
//    @Convert(converter = JpaListJsonConverter.class)
//    @Lob
//    private List<Hub> hubs;

}
