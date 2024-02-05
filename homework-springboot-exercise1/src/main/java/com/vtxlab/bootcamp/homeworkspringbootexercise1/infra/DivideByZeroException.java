package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

public class DivideByZeroException extends ArithmeticException {
  
  public DivideByZeroException() {
    super(Syscode.DIVID_BY_ZERO.getMessage());
  }

}
