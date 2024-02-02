package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.ApiResp;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.CalResult;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.Input;

public interface CalculatorOperation {
  // @RequestParam
  @GetMapping(value = "/")
  ResponseEntity<ApiResp<CalResult>> calculator(@RequestParam String x, //
      @RequestParam String y, //
      @RequestParam String operation) throws Exception;

  // @RequestParam
  @GetMapping(value = "/{x}/{y}/{operation}")
  ResponseEntity<ApiResp<CalResult>> calculator2(@PathVariable String x, //
      @PathVariable String y, //
      @PathVariable String operation) throws Exception;

  @PostMapping(value = "/")
  ResponseEntity<ApiResp<CalResult>> calculator3(@RequestBody Input input) throws Exception;

}
