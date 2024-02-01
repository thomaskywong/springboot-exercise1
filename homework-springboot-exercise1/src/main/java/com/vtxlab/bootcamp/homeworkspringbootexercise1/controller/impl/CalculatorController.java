package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.CalculatorOperation;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Errors;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.CalResult;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.ErrMessage;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.Input;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public String calculator(String x, String y, String operation) {

    double result = 0.0d;

    double doubleX = 0.0d;
    double doubleY = 0.0d;

    try {
      doubleX = Double.parseDouble(x);
      doubleY = Double.parseDouble(y);
    } catch (IllegalArgumentException ex) {
      ErrMessage errMessage = ErrMessage.builder() //
          .code(Errors.INVALID_INPUT.getCode()) //
          .message(Errors.INVALID_INPUT.getMessage()) //
          .build();
      return toJson(errMessage);
    }

    switch (operation) {
      case "add":
        result = calculatorService.add(doubleX, doubleY);
        break;

      case "sub":
        result = calculatorService.subtract(doubleX, doubleY);
        break;

      case "mul":
        result = calculatorService.multiply(doubleX, doubleY);
        break;

      case "div":
        if (doubleY == 0.0) {
          ErrMessage errMessage = ErrMessage.builder() //
              .code(Errors.DIVID_BY_ZERO.getCode()) //
              .message(Errors.DIVID_BY_ZERO.getMessage()) //
              .build();

          return toJson(errMessage);
        }
        result = calculatorService.divide(doubleX, doubleY);
        break;

      default:
        ErrMessage errMessage = ErrMessage.builder() //
            .code(Errors.INVALID_OPERATION.getCode()) //
            .message(Errors.INVALID_OPERATION.getMessage()) //
            .build();

        return toJson(errMessage);
    }

    CalResult calResult = CalResult.builder() //
        .x(x) //
        .y(y) //
        .operation(operation) //
        .calResult(String.valueOf(result)) //
        .build();

    return toJson(calResult);
  }

  @Override
  public String calculator2(String x, String y, String operation) {
    return calculator(x, y, operation);
  }

  @Override
  public String calculator3(Input input) {
    return calculator(input.getX(), input.getY(), input.getOperation());
  }

  public static String toJson(Object obj) {
    ObjectMapper objectMapper = new ObjectMapper();
    String message = "";
    try {
      message = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException ex) {
    }
    return message;
  }
}
