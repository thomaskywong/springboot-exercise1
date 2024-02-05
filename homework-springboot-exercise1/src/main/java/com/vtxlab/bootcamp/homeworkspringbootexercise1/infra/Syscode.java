package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

public enum Syscode {

  OK (1, "OK."),
  INVALID_INPUT (2, "Invalid input."),
  INVALID_OPERATION (3, "Invalid operation."),
  DIVID_BY_ZERO (4, "Divided by zero."),
  GENERAL_EXCEPTION(0, "General Exception"),
  ;

  private int code;
  private String message; 

  private Syscode(int code, String message) {
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
