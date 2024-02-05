package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.InputDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.service.CalculatorService;

@WebMvcTest(CalculatorController.class)
public class CalculatorController2Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAdd() throws Exception {

        Mockito.when(calculatorService.add(3.0, 10.0)).thenReturn(13.0);

        mockMvc.perform(get("/api/v1/") //
                .param("x", "3.0") //
                .param("y", "10.0") //
                .param("operation", "add")) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value("3.0")) //
                .andExpect(jsonPath("$.y").value("10.0")) //
                .andExpect(jsonPath("$.operation").value("add")) //
                .andExpect(jsonPath("$.result").value("13.0")) //
                .andDo(print());
    }

    @Test
    void testSub() throws Exception {

        Mockito.when(calculatorService.subtract(3.0, 10.0)).thenReturn(-7.0);

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "3.0") //
                .param("y", "10.0") //
                .param("operation", "sub")) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value(3.0)) //
                .andExpect(jsonPath("$.y").value("10.0")) //
                .andExpect(jsonPath("$.operation").value("sub")) //
                .andExpect(jsonPath("$.result").value(-7.0)) //
                .andDo(print());

    }

    @Test
    void testMul() throws Exception {

        Mockito.when(calculatorService.multiply(3.0, 10.0)).thenReturn(30.0);

        mockMvc.perform(get("/api/v1/") //
                .param("x", "3.0") //
                .param("y", "10.0") //
                .param("operation", "mul")) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value("3.0")) //
                .andExpect(jsonPath("$.y").value("10.0")) //
                .andExpect(jsonPath("$.operation").value("mul")) //
                .andExpect(jsonPath("$.result").value("30.0")) //
                .andDo(print());

    }

    @Test
    void testDiv() throws Exception {

        Mockito.when(calculatorService.divide(10.0, 3.0)).thenReturn(3.33333);

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "10.0") //
                .param("y", "3.0") //
                .param("operation", "div")) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value("10.0")) //
                .andExpect(jsonPath("$.y").value("3.0")) //
                .andExpect(jsonPath("$.operation").value("div")) //
                .andExpect(jsonPath("$.result").value("3.33333")) //
                .andDo(print());

    }

    @Test
    void testDivByZero() throws Exception {

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "10.0") //
                .param("y", "0.0") //
                .param("operation", "div")) //
                .andExpect(status().isBadRequest()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.DIVID_BY_ZERO.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.DIVID_BY_ZERO.getMessage())) //
                .andDo(print());

    }

    @Test
    void testInvalidX() throws Exception {

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "abc") //
                .param("y", "3.0") //
                .param("operation", "div")) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(status().isBadRequest()) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.INVALID_INPUT.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.INVALID_INPUT.getMessage())) //
                .andDo(print());

    }

    @Test
    void testInvalidY() throws Exception {

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "10.0") //
                .param("y", "edf") //
                .param("operation", "div")) //
                .andExpect(status().isBadRequest()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.INVALID_INPUT.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.INVALID_INPUT.getMessage())) //
                .andDo(print());

    }

    @Test
    void testInvalidOperation() throws Exception {

        // @RequestParam
        mockMvc.perform(get("/api/v1/") //
                .param("x", "10.0") //
                .param("y", "3.0") //
                .param("operation", "divide")) //
                .andExpect(status().isBadRequest()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.INVALID_OPERATION.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.INVALID_OPERATION.getMessage())) //
                .andDo(print());

    }

    @Test
    void testAdd2() throws Exception {

        Mockito.when(calculatorService.add(3.0, 10.0)).thenReturn(13.0);

        // @PathVariable
        mockMvc.perform(
                get("/api/v1/{x}/{y}/{operation}", "3.0", "10.0", "add"))
                .andExpect(status().isOk()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value("3.0")) //
                .andExpect(jsonPath("$.y").value("10.0")) //
                .andExpect(jsonPath("$.operation").value("add")) //
                .andExpect(jsonPath("$.result").value("13.0")) //
                .andDo(print());
    }

    @Test
    void testDivByZero2() throws Exception {

        // @RequestParam
        mockMvc.perform(get("/api/v1/{x}/{y}/{operation}", "3", "0", "div")) //
                .andExpect(status().isBadRequest()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.DIVID_BY_ZERO.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.DIVID_BY_ZERO.getMessage())) //
                .andDo(print());

    }

    @Test
    void testSub2() throws Exception {

        InputDTO input = InputDTO.builder() //
                .x("3.0") //
                .y("10.0") //
                .operation("sub") //
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(input);

        Mockito.when(calculatorService.subtract(3.0, 10.0)).thenReturn(-7.0);

        mockMvc.perform(post("/api/v1/") //
                .contentType(MediaType.APPLICATION_JSON) //
                .content(jsonInput)) //
                .andExpect(status().isOk()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.x").value(3.0)) //
                .andExpect(jsonPath("$.y").value("10.0")) //
                .andExpect(jsonPath("$.operation").value("sub")) //
                .andExpect(jsonPath("$.result").value(-7.0)) //
                .andDo(print());
    }

    @Test
    void testInvalidY2() throws Exception {

        InputDTO input = InputDTO.builder() //
                .x("3.0") //
                .y("abc") //
                .operation("sub") //
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(input);

        // @RequestBody
        mockMvc.perform(post("/api/v1/") //
                .contentType(MediaType.APPLICATION_JSON) //
                .content(jsonInput)) //
                .andExpect(status().isBadRequest()) //
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
                .andExpect(jsonPath("$.code")
                        .value(Syscode.INVALID_INPUT.getCode())) //
                .andExpect(jsonPath("$.message")
                        .value(Syscode.INVALID_INPUT.getMessage())) //
                .andDo(print());

    }


}
