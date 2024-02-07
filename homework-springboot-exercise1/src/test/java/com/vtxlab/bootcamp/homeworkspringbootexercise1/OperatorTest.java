package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Operator;

public class OperatorTest {

  @Test
  void convert() {

    assertThat(Operator.operatorEnum("add"), equalTo(Operator.ADD));
    assertThat(Operator.operatorEnum("sub"), equalTo(Operator.SUBSTRACT));
    assertThat(Operator.operatorEnum("mul"), equalTo(Operator.MULTIPLY));
    assertThat(Operator.operatorEnum("div"), equalTo(Operator.DIVIDE));

    assertThat("add", equalTo(Operator.ADD.getDesc()));
    assertThat("sub", equalTo(Operator.SUBSTRACT.getDesc()));
    assertThat("mul", equalTo(Operator.MULTIPLY.getDesc()));
    assertThat("div", equalTo(Operator.DIVIDE.getDesc()));
    

  }
  
}
