package io.beansprout.boost.DTOs;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ManufacturerDTO implements Serializable {
  @NotNull private Integer id;

  @NotNull private String name;

  @NotNull private String link;
}
