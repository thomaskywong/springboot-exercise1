package com.vtxlab.bootcamp.homeworkspringbootexercise1.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class CalResult {

  private String x;
  private String y;
  private String operation;
  private String calResult;
  
}
