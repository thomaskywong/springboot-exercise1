package com.vtxlab.bootcamp.homeworkspringbootexercise1;

import org.junit.jupiter.api.Test;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.dto.ErrorMsgDTO;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Mapper;
import com.vtxlab.bootcamp.homeworkspringbootexercise1.infra.Syscode;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MapperTest {

  @Test
  void map() throws Exception {

    ErrorMsgDTO actualMsg = ErrorMsgDTO.of(Syscode.DIVID_BY_ZERO.getCode(), //
        Syscode.DIVID_BY_ZERO.getMessage());

    String actual = Mapper.map(actualMsg);

    assertThat(actual, equalTo("{\"code\":4,\"message\":\"Divided by zero.\"}"));

  }
}
