package com.vtxlab.bootcamp.homeworkspringbootexercise1.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsgDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.DivideByZeroException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidInputException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidOperationException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice // @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
  
  @ExceptionHandler(DivideByZeroException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMsgDTO DivideByZeroExceptionHandler(DivideByZeroException e) {
    return ErrorMsgDTO.builder() //
                      .code(Syscode.DIVID_BY_ZERO.getCode()) //
                      .message(Syscode.DIVID_BY_ZERO.getMessage()) //
                      .build(); 
  }

  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMsgDTO InvalidInputExceptionHandler(InvalidInputException e) {
    return ErrorMsgDTO.builder() //
                      .code(Syscode.INVALID_INPUT.getCode()) //
                      .message(Syscode.INVALID_INPUT.getMessage()) //
                      .build(); 
  }

  @ExceptionHandler(InvalidOperationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMsgDTO InvalidOperationExceptionHandler(InvalidOperationException e) {
    return ErrorMsgDTO.builder() //
                      .code(Syscode.INVALID_OPERATION.getCode()) //
                      .message(Syscode.INVALID_OPERATION.getMessage()) //
                      .build(); 
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ErrorMsgDTO ExceptionHandler(Exception e) {
    return ErrorMsgDTO.builder() //
                      .code(Syscode.GENERAL_EXCEPTION.getCode()) //
                      .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
                      .build(); 
  }


}
