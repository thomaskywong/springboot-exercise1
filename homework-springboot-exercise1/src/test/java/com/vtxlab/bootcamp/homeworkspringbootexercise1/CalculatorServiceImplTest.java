package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.impl.CalculatorServiceImpl;


public class CalculatorServiceImplTest {

  @Test
  void testAdd() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.add(3.0, 10.0);

    assertThat(actual, equalTo(13.0));

  }

  @Test
  void testSub() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.subtract(3.0, 10.0);

    assertThat(actual, equalTo(-7.0));

  }

  @Test
  void testMul() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.multiply(3.0, 10.0);

    assertThat(actual, equalTo(30.0));

  }

  
  @Test
  void testDiv() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.divide(10.0, 3.0);

    assertThat(actual, equalTo(3.33333));

  }
  
}
