package com.example.demo.entity;

import com.example.demo.util.JpaListJsonConverter;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.List;

/**
 * Created by brian on 2017/9/16.
 */
@Entity
@Data
public class Resource {

    @Id
    private Long id;
//    @Convert(converter = JpaListJsonConverter.class)
    @Lob
    private List<Color> insideColor;

//    @Convert(converter = JpaListJsonConverter.class)
    @Lob
    private List<Hub> hubs;

//    protected JavaType getJavaType(Class<?> clazz) {
//        if (List.class.isAssignableFrom(clazz)) {
//            return TypeFactory.collectionType(ArrayList.class, MyBean.class);
//        } else {
//            return super.getJavaType(clazz);
//        }
//    }
}
