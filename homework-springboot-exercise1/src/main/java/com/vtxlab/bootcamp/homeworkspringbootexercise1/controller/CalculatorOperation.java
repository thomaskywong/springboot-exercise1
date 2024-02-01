package com.vtxlab.bootcamp.homeworkspringbootexercise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.model.Input;

public interface CalculatorOperation {
  // @RequestParam
  @GetMapping(value = "/")
  String calculator(@RequestParam String x, //
      @RequestParam String y, //
      @RequestParam String operation);

  // @RequestParam
  @GetMapping(value = "/{x}/{y}/{operation}")
  String calculator2(@PathVariable String x, //
      @PathVariable String y, //
      @PathVariable String operation);

  @PostMapping(value = "/")
  String calculator3(@RequestBody Input input);

}