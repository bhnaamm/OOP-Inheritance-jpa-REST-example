package com.bhnaamm.examples.config;

import com.bhnaamm.examples.domain.enumeration.CarType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverter implements Converter<String, CarType> {

    @Override
    public CarType convert(String source) {
        String text = source.toUpperCase();
        return CarType.valueOf(text);
    }
}
