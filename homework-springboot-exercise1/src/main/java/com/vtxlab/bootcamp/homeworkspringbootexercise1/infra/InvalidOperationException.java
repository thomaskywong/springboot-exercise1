package com.vtxlab.bootcamp.homeworkspringbootexercise1.infra;

public class InvalidOperationException extends IllegalArgumentException {
  public InvalidOperationException() {
    super(Syscode.INVALID_OPERATION.getMessage());
  }
}
