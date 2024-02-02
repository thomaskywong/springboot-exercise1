package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class ApiResp<T> {

  private int code;
  private String message;
  private T data;

  public static <T> ApiResp<T> of(int code, String message, T data) {
    return ApiResp.<T>builder() //
                  .code(code) //
                  .message(message) //
                  .data(data) //
                  .build();
  }
  
}
