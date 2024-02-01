package com.vtxlab.bootcamp.homeworkspringbootexercise1.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class ErrMessage {

  private int code;
  private String message;
  
}
