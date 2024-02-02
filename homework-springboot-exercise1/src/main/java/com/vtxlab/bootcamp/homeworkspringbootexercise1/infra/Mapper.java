package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    public static <T> String map(T t) throws Exception{
    ObjectMapper objectMapper = new ObjectMapper();
    
    String message = objectMapper.writeValueAsString(t);

    return message;
  }
}
