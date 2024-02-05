package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.CalResultDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.InputDTO;

public interface CalculatorOperation {
  // @RequestParam
  @GetMapping(value = "/")
  @ResponseStatus(value = HttpStatus.OK)
  CalResultDTO calculator(@RequestParam String x, //
      @RequestParam String y, //
      @RequestParam String operation) throws Exception;

  // @RequestParam
  @GetMapping(value = "/{x}/{y}/{operation}")
  @ResponseStatus(value = HttpStatus.OK)
  CalResultDTO calculator2(@PathVariable String x, //
      @PathVariable String y, //
      @PathVariable String operation) throws Exception;

  @PostMapping(value = "/")
  @ResponseStatus(value = HttpStatus.OK)
  CalResultDTO calculator3(@RequestBody InputDTO input) 
      throws Exception;

}
