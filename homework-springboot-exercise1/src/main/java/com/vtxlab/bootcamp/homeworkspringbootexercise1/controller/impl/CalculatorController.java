package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.CalculatorOperation;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResult;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsg;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.Input;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Mapper;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public ResponseEntity<String> calculator(String x, String y,
      String operation) throws Exception {

    double result = 0.0d;
    double doubleX = 0.0d;
    double doubleY = 0.0d;

    try {
      doubleX = Double.parseDouble(x);
      doubleY = Double.parseDouble(y);
    } catch (IllegalArgumentException ex) {

      ErrorMsg err = ErrorMsg.of(Syscode.INVALID_INPUT.getCode(), //
          Syscode.INVALID_INPUT.getMessage());

      String jsonErr = Mapper.map(err);

      return new ResponseEntity<String>(jsonErr, HttpStatus.BAD_REQUEST);
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

          ErrorMsg err = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
              Syscode.DIVID_BY_ZERO.getMessage());

          String jsonErr = Mapper.map(err);

          return new ResponseEntity<String>(jsonErr, HttpStatus.BAD_REQUEST);
        }

        result = calculatorService.divide(doubleX, doubleY);
        break;

      default:

      ErrorMsg err = ErrorMsg.of(Syscode.INVALID_OPERATION.getCode(), //
          Syscode.INVALID_OPERATION.getMessage());
      
      String jsonErr = Mapper.map(err);

      return new ResponseEntity<String>(jsonErr, HttpStatus.BAD_REQUEST);
    }

    CalResult calResult =
        CalResult.of(x, y, operation, String.valueOf(result));

        String jsonString = Mapper.map(calResult);

        return new ResponseEntity<String>(jsonString, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> calculator2(String x, String y,
      String operation) throws Exception {
    return calculator(x, y, operation);
  }

  @Override
  public ResponseEntity<String> calculator3(Input input) throws Exception {
    return calculator(input.getX(), input.getY(), input.getOperation());
  }


}
