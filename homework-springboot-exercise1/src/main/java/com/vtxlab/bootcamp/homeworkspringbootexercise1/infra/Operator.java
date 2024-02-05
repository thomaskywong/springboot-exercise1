package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

import lombok.Getter;

@Getter
public enum Operator {
  
  ADD ("add"),
  SUBSTRACT ("sub"),
  MULTIPLY ("mul"),
  DIVIDE ("div"),
  ;

  private String desc;

  private Operator (String desc) {
    this.desc = desc;
  }

  
}
