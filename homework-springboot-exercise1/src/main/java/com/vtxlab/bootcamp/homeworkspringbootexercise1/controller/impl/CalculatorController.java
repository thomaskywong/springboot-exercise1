package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.CalculatorOperation;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.ApiResp;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.CalResult;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.Input;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public ResponseEntity<ApiResp<CalResult>> calculator(String x, String y,
      String operation) {

    double result = 0.0d;
    double doubleX = 0.0d;
    double doubleY = 0.0d;

    try {
      doubleX = Double.parseDouble(x);
      doubleY = Double.parseDouble(y);
    } catch (IllegalArgumentException ex) {

      CalResult calResult = CalResult.of(x, y, operation, "ERROR");

      ApiResp<CalResult> errMessage = ApiResp.of( //
              Syscode.INVALID_INPUT.getCode(), //
              Syscode.INVALID_INPUT.getMessage(),  //
              calResult);

      return ResponseEntity.badRequest().body(errMessage);
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

          CalResult calResult = CalResult.of(x, y, operation, "ERROR");

          ApiResp<CalResult> errMessage = ApiResp.of( //
          Syscode.DIVID_BY_ZERO.getCode(), //
          Syscode.DIVID_BY_ZERO.getMessage(),  //
          calResult);

          return ResponseEntity.status(400).body(errMessage);
        }
        result = calculatorService.divide(doubleX, doubleY);
        break;

      default:

        CalResult calResult = CalResult.of(x, y, operation, "ERROR");

        ApiResp<CalResult> errMessage = ApiResp.of( //
        Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage(),  //
        calResult);

        return ResponseEntity.status(400).body(errMessage);
    }

    CalResult calResult = CalResult.of(x, y, operation, String.valueOf(result));;

    ApiResp<CalResult> apiResp = ApiResp.of( //
        Syscode.OK.getCode(), //
        Syscode.OK.getMessage(),  //
        calResult);

    return ResponseEntity.ok(apiResp);
  }

  @Override
  public ResponseEntity<ApiResp<CalResult>> calculator2(String x, String y,
      String operation) {
    return calculator(x, y, operation);
  }

  @Override
  public ResponseEntity<ApiResp<CalResult>> calculator3(Input input) {
    return calculator(input.getX(), input.getY(), input.getOperation());
  }


}
