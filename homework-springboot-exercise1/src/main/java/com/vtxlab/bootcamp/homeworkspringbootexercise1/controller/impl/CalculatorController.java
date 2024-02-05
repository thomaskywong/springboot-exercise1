package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.CalculatorOperation;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResultDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.InputDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidInputException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidOperationException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public CalResultDTO calculator(String x, String y,
      String operation) throws Exception {

    double result = 0.0d;
    double doubleX = 0.0d;
    double doubleY = 0.0d;

    try {
      doubleX = Double.parseDouble(x);
      doubleY = Double.parseDouble(y);
    } catch (IllegalArgumentException ex) {
      throw new InvalidInputException();
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
        if (doubleY == 0.0) 
          throw new InvalidInputException();    

        result = calculatorService.divide(doubleX, doubleY);
        break;

      default:

        throw new InvalidOperationException();

    }

    return CalResultDTO.of(x, y, operation, String.valueOf(result));

  }

  @Override
  public CalResultDTO calculator2(String x, String y,
      String operation) throws Exception {
    return calculator(x, y, operation);
  }

  @Override
  public CalResultDTO calculator3(InputDTO input) throws Exception {
    return calculator(input.getX(), input.getY(), input.getOperation());
  }


}
