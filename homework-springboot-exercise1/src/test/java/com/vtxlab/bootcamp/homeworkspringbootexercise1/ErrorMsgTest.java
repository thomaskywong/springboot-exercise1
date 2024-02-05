package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsgDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;

public class ErrorMsgTest {

  @Test
  void of() {

    ErrorMsgDTO actual = ErrorMsgDTO.of(Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage());

    ErrorMsgDTO expected = new ErrorMsgDTO(Syscode.INVALID_OPERATION.getCode(),
        Syscode.INVALID_OPERATION.getMessage());

    assertThat(actual, equalTo(expected));
    assertThat(expected, equalTo(actual));

  }

  @Test
  void getCode() {

    ErrorMsgDTO actual = ErrorMsgDTO.of(Syscode.INVALID_OPERATION.getCode(), //
        Syscode.INVALID_OPERATION.getMessage());

    int actualCode = actual.getCode();

    assertThat(actualCode, equalTo(3));

  }

  @Test
  void getMessage() {

    ErrorMsgDTO actual = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    String actualMessage = actual.getMessage();

    assertThat(actualMessage, equalTo("Divided by zero."));

  }

  @Test
  void equals() {

    ErrorMsgDTO actual1 = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsgDTO actual2 = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsgDTO actual3 = ErrorMsgDTO.of(Syscode.OK.getCode(), //
        Syscode.OK.getMessage());

    assertThat(actual1.equals(actual2), equalTo(true));
    assertThat(actual1.equals(actual3), equalTo(false));


  }

  @Test
  void hashCode1() {

    ErrorMsgDTO actual1 = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    ErrorMsgDTO actual2 = ErrorMsgDTO.of(Syscode.INVALID_INPUT.getCode(), //
        Syscode.INVALID_INPUT.getMessage());

    assertThat(actual1.hashCode(), equalTo(1830450583));
    assertThat(actual2.hashCode(), equalTo(-1538318820));

  }

  @Test
  void toString1() {

    ErrorMsgDTO actual = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    assertThat(actual.toString(),
        equalTo("ErrorMsg(code=4, message=Divided by zero.)"));

  }

}
