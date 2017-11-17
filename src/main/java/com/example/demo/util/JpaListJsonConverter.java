package com.example.demo.util;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/**
 * Created by brian on 2017/9/14.
 */
public class JpaListJsonConverter<T> implements AttributeConverter<T, String> {

    final static private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(T entityValue) {
        if( entityValue == null )
            return null;
        try {
            return mapper.writeValueAsString(entityValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T convertToEntityAttribute(String databaseValue) {
        Class<T> entityClass =(Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        if( databaseValue == null )
            return null;
        try {
            return mapper.readValue(databaseValue, entityClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
