package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

public enum Errors {

  INVALID_INPUT (1, "Invalid input."),
  INVALID_OPERATION (2, "Invalid operation."),
  DIVID_BY_ZERO (3, "Divided by zero."),
  ;

  private int code;
  private String message; 

  private Errors(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode(){
    return code;
  }

  public String getMessage(){
    return message;
  }
  
}
