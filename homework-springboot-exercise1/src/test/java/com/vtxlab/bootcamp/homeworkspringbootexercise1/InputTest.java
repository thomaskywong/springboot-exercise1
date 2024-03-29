package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResultDTO;

public class InputTest {

  @Test
  void getterX() {

    CalResultDTO result = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    String actual = result.getX();

    assertThat(actual, equalTo("3.0"));

  }

  @Test
  void getterY() {

    CalResultDTO result = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    String actual = result.getY();

    assertThat(actual, equalTo("10.0"));

  }

  @Test
  void getterOperation() {

    CalResultDTO result = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    String actual = result.getOperation();

    assertThat(actual, equalTo("sub"));

  }

  @Test
  void equals() {

    CalResultDTO result1 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    CalResultDTO result2 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    CalResultDTO result3 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("add") //
        .result("13.0") //
        .build();

    boolean actual1 = result1.equals(result2);
    boolean actual2 = result1.equals(result3);

    assertTrue(actual1);
    assertFalse(actual2);

  }

  @Test
  void hashCode1() {

    CalResultDTO result1 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    CalResultDTO result2 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    CalResultDTO result3 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("add") //
        .result("13.0") //
        .build();

    int actual1 = result1.hashCode();
    int actual2 = result2.hashCode();
    int actual3 = result3.hashCode();


    assertThat(actual1, equalTo(-1543934283));
    assertThat(actual2, equalTo(-1543934283));
    assertThat(actual3, equalTo(-1544870520));   

  }

  @Test
  void toString1() {

    CalResultDTO result1 = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    String actual = result1.toString();


    assertThat(actual, equalTo("CalResultDTO(x=3.0, y=10.0, operation=sub, result=-7.0)")); 

  }

  @Test
  void builder1() {

    CalResultDTO actual = CalResultDTO.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();
    
    CalResultDTO result = new CalResultDTO("3.0","10.0","sub","-7.0");

    assertEquals(actual, result); 
    assertEquals(result, actual); 

  }



}
