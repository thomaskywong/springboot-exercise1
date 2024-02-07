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

  public static Operator operatorEnum(String operation) {
    return switch (operation) {
                  case "add" -> Operator.ADD;
                  case "sub" -> Operator.SUBSTRACT;
                  case "mul" -> Operator.MULTIPLY;
                  case "div" -> Operator.DIVIDE;
                  default -> throw new InvalidOperationException();
                  };
  }

  
}
