package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.controller.impl.CalculatorController;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResult;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsg;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.Input;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CalculatorService calculatorService;

  @Test
  void testAdd() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("add") //
        .result("13.0") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);

    Mockito.when(calculatorService.add(3.0, 10.0)).thenReturn(13.0);

    // @RequestParam
    // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/")
    // .param("x","3.0") //
    // .param("y","10.0") //
    // .param("operation", "add")) //
    // .andExpect(MockMvcResultMatchers.status().isOk())
    // .andExpect(MockMvcResultMatchers.content().string(jsonString))
    // .andDo(MockMvcResultHandlers.print());

    mockMvc.perform(get("/api/v1/") //
        .param("x", "3.0") //
        .param("y", "10.0") //
        .param("operation", "add")) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)) //
        .andDo(print());
  }

  @Test
  void testSub() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub")//
        .result("-7.0") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);

    Mockito.when(calculatorService.subtract(3.0, 10.0)).thenReturn(-7.0);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "3.0") //
        .param("y", "10.0") //
        .param("operation", "sub")) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testMul() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("mul")//
        .result("30.0") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);

    Mockito.when(calculatorService.multiply(3.0, 10.0)).thenReturn(30.0);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "3.0") //
        .param("y", "10.0") //
        .param("operation", "mul")) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testDiv() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("10.0") //
        .y("3.0") //
        .operation("div")//
        .result("3.33333") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);

    Mockito.when(calculatorService.divide(10.0, 3.0)).thenReturn(3.33333);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "10.0") //
        .param("y", "3.0") //
        .param("operation", "div")) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testDivByZero() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "10.0") //
        .param("y", "0.0") //
        .param("operation", "div")) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testInvalidX() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.INVALID_INPUT.getCode(), //
        Syscode.INVALID_INPUT.getMessage());

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "abc") //
        .param("y", "3.0") //
        .param("operation", "div")) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testInvalidY() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.INVALID_INPUT.getCode(), //
        Syscode.INVALID_INPUT.getMessage());

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "10.0") //
        .param("y", "edf") //
        .param("operation", "div")) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }

  @Test
  void testInvalidOperation() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage());

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);

    // @RequestParam
    mockMvc.perform(get("/api/v1/") //
        .param("x", "10.0") //
        .param("y", "3.0") //
        .param("operation", "divide")) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content() //
            .string(jsonString)) //
        .andDo(print());

  }

  @Test
  void testAdd2() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("add") //
        .result("13.0") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);

    Mockito.when(calculatorService.add(3.0, 10.0)).thenReturn(13.0);

    // @PathVariable
    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "3.0", "10.0", "add")) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)) //
        .andDo(print());
  }

  // @Test
  void testDivByZero2() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);

    // @RequestParam
    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "10.0", "0.0", "div")) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content() //
            .string(jsonString)) //
        .andDo(print());

  }

  @Test
  void testSub2() throws Exception {

    CalResult mockCalResult = CalResult.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .result("-7.0") //
        .build();

    Input input = Input.builder() //
        .x("3.0") //
        .y("10.0") //
        .operation("sub") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(mockCalResult);
    String jsonInput = objectMapper.writeValueAsString(input);

    Mockito.when(calculatorService.subtract(3.0, 10.0)).thenReturn(-7.0);

    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON_VALUE) //
        .content(jsonInput)) //
        .andExpect(status().isOk()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)) //
        .andDo(print());
  }

  @Test
  void testInvalidY2() throws Exception {

    ErrorMsg errMessage = ErrorMsg.of(Syscode.INVALID_INPUT.getCode(), //
        Syscode.INVALID_INPUT.getMessage());

    Input input = Input.builder() //
        .x("3.0") //
        .y("abc") //
        .operation("sub") //
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(errMessage);
    String jsonInput = objectMapper.writeValueAsString(input);

    // @RequestBody
    mockMvc.perform(post("/api/v1/") //
        .contentType(MediaType.APPLICATION_JSON_VALUE) //
        .content(jsonInput)) //
        .andExpect(status().isBadRequest()) //
        .andExpect(content()
            .contentType(MediaType.valueOf("text/plain;charset=UTF-8"))) //
        .andExpect(content().string(jsonString)).andDo(print());

  }


}
