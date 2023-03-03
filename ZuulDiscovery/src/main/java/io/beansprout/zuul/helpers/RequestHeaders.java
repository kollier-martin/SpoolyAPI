package io.beansprout.zuul.helpers;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class RequestHeaders {
  @Getter @Setter public List<String> headers;

  public RequestHeaders() {
    headers = new ArrayList<>();
  }
}
