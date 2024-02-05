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
public class ErrorMsgDTO {

  private int code;
  private String message;

  public static ErrorMsgDTO of(int code, String message) {
    return ErrorMsgDTO.builder() //
                 .code(code) //
                 .message(message) //
                 .build();
  }
  
}
