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

    assertThat(Operator.ADD.getDesc(), equalTo("add"));
    assertThat(Operator.SUBSTRACT.getDesc(), equalTo("sub"));
    assertThat(Operator.MULTIPLY.getDesc(), equalTo("mul"));
    assertThat(Operator.DIVIDE.getDesc(), equalTo("div"));

    assertThat(Operator.operatorEnum("div"), not(equalTo(Operator.ADD)));
    assertThat(Operator.ADD.getDesc(), not(equalTo("mul")));
    

  }
  
}
