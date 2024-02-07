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

    double actual3 = calculatorService.add(3.0, 7.0);
    assertThat(actual3, equalTo(10.0));

    double actual = calculatorService.add(-3.0, 10.0);
    assertThat(actual, equalTo(7.0));

    double actual2 = calculatorService.add(3.0, -7.0);
    assertThat(actual2, equalTo(-4.0));

    double actual4 = calculatorService.add(-3.0, -7.0);
    assertThat(actual4, equalTo(-10.0));

  }

  @Test
  void testSub() {

    CalculatorService calculatorService = new CalculatorServiceImpl();


    double actual = calculatorService.subtract(3.0, 10.0);
    assertThat(actual, equalTo(-7.0));

    double actual2 = calculatorService.subtract(-3.0, 10.0);
    assertThat(actual2, equalTo(-13.0));

    double actual3 = calculatorService.subtract(3.0, -10.0);
    assertThat(actual3, equalTo(13.0));

    double actual4 = calculatorService.subtract(-3.0, -10.0);
    assertThat(actual4, equalTo(7.0));

  }

  @Test
  void testMul() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.multiply(3.0, 10.0);
    assertThat(actual, equalTo(30.0));
    
    double actual2 = calculatorService.multiply(-3.0, 10.0);
    assertThat(actual2, equalTo(-30.0));

    double actual3 = calculatorService.multiply(3.0, -10.0);
    assertThat(actual3, equalTo(-30.0));

    double actual4 = calculatorService.multiply(-3.0, -10.0);
    assertThat(actual4, equalTo(30.0));

  }

  
  @Test
  void testDiv() {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    double actual = calculatorService.divide(10.0, 3.0);
    assertThat(actual, equalTo(3.33333));

    double actual2 = calculatorService.divide(-10.0, 3.0);
    assertThat(actual2, equalTo(-3.33333));

    double actual3 = calculatorService.divide(10.0, -3.0);
    assertThat(actual3, equalTo(-3.33333));

    double actual4 = calculatorService.divide(-10.0, -3.0);
    assertThat(actual4, equalTo(3.33333));

  }
  
}
