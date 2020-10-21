package com.example.pinboard.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringArrayConverter implements AttributeConverter<List<String>, String> {

  @Override
  public String convertToDatabaseColumn(List<String> attribute) {
    return String.join(", ", attribute);
  }

  @Override
  public List<String> convertToEntityAttribute(String dbData) {
    return Arrays.asList(dbData.split(", "));
  }
  
}
