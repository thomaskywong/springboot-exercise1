package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsg;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;

public class ErrorMsgTest {

  @Test
  void of() {

    ErrorMsg actual = ErrorMsg.of(Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage());

    ErrorMsg expected = new ErrorMsg(Syscode.INVALID_OPERATION.getCode(),
        Syscode.INVALID_OPERATION.getMessage());

    assertThat(actual, equalTo(expected));
    assertThat(expected, equalTo(actual));

  }

  @Test
  void getCode() {

    ErrorMsg actual = ErrorMsg.of(Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage());

    int actualCode = actual.getCode();

    assertThat(actualCode, equalTo(3));

  }

  @Test
  void getMessage() {

    ErrorMsg actual = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    String actualMessage = actual.getMessage();

    assertThat(actualMessage, equalTo("Divided by zero."));

  }

  @Test
  void equals() {

    ErrorMsg actual1 = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsg actual2 = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsg actual3 = ErrorMsg.of(Syscode.OK.getCode(), //
        Syscode.OK.getMessage());

    assertThat(actual1.equals(actual2), equalTo(true));
    assertThat(actual1.equals(actual3), equalTo(false));


  }

  @Test
  void hashCode1() {

    ErrorMsg actual1 = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsg actual2 = ErrorMsg.of(Syscode.INVALID_INPUT.getCode(), //
        Syscode.INVALID_INPUT.getMessage());

    assertThat(actual1.hashCode(), equalTo(1830450583));
    assertThat(actual2.hashCode(), equalTo(-1538318820));

  }

  @Test
  void toString1() {

    ErrorMsg actual = ErrorMsg.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    assertThat(actual.toString(),
        equalTo("ErrorMsg(code=4, message=Divided by zero.)"));

  }

}
