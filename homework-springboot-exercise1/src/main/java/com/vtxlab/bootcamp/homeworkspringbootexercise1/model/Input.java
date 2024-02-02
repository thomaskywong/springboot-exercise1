package com.vtxlab.bootcamp.homeworkspringbootexercise1.model;

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
public class Input {

  private String x;
  private String y;
  private String operation;
  
}
