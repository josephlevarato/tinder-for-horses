package com.tinder.horse.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tinder.horse.enums.Gender;

@Component
public class StringToGenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        return Gender.fromLabel(source);
    }
}