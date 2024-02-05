package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.CalculatorOperation;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResultDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.InputDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.DivideByZeroException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidInputException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.InvalidOperationException;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Operator;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public CalResultDTO calculator(String x, String y,
      String operation) {

    double result = -1.0d;
    double doubleX = 0.0d;
    double doubleY = 0.0d;

    try {
      doubleX = Double.parseDouble(x);
      doubleY = Double.parseDouble(y);
    } catch (IllegalArgumentException ex) {
      throw new InvalidInputException();
    }

    if (Operator.ADD.getDesc().equals(operation)){ 

      result = calculatorService.add(doubleX, doubleY);
    
    } else if (Operator.SUBSTRACT.getDesc().equals(operation)) {
    
      result = calculatorService.subtract(doubleX, doubleY);
    
    } else if (Operator.MULTIPLY.getDesc().equals(operation)) {
    
      result = calculatorService.multiply(doubleX, doubleY);
    
    } else if (Operator.DIVIDE.getDesc().equals(operation)) {
    
      if (doubleY == 0.0) { 
        throw new DivideByZeroException();    
      }
    
      result = calculatorService.divide(doubleX, doubleY);
    
    } else {
    
      throw new InvalidOperationException();
    
    }

    return CalResultDTO.of(x, y, operation, String.valueOf(result));

  }

  @Override
  public CalResultDTO calculator2(String x, String y,
      String operation) {
    return calculator(x, y, operation);
  }

  @Override
  public CalResultDTO calculator3(InputDTO input) {
    return calculator(input.getX(), input.getY(), input.getOperation());
  }


}
