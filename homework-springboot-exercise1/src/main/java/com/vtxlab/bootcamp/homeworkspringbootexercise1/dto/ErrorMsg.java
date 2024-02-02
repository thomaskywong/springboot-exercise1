package com.vtxlab.bootcamp.homeworkspringbootexercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
public class ErrorMsg {

  private int code;
  private String message;

  public static ErrorMsg of(int code, String message) {
    return ErrorMsg.builder() //
                 .code(code) //
                 .message(message) //
                 .build();
  }
  
}
