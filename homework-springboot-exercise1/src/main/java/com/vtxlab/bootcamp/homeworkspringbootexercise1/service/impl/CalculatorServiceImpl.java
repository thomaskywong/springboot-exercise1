package com.vtxlab.bootcamp.homeworkspringbootexercise1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public Double add(double x, double y) {
    return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).doubleValue();
  }

  @Override
  public Double subtract(double x, double y) {
    return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).doubleValue();
  }

  @Override
  public Double multiply(double x, double y) {
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y))
        .setScale(5, RoundingMode.HALF_UP).doubleValue();
  }

  @Override
  public Double divide(double x, double y) {
    return BigDecimal.valueOf(x)
        .divide(BigDecimal.valueOf(y), 5, RoundingMode.HALF_UP).doubleValue();
  }

}
