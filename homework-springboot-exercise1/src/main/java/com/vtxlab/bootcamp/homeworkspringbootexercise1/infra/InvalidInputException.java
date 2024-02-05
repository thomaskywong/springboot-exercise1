package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

public class InvalidInputException extends IllegalArgumentException {

  public InvalidInputException() {
    super(Syscode.INVALID_INPUT.getMessage());
  }
  
}
