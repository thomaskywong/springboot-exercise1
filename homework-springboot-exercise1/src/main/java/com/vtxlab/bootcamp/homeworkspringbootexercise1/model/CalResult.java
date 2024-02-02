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
public class CalResult {

  private String x;
  private String y;
  private String operation;
  private String result;

  public static CalResult of(String x, String y, String operation,
      String result) {
    return CalResult.builder() //
        .x(x) //
        .y(y) //
        .operation(operation) //
        .result(result) //
        .build();
  }

}
