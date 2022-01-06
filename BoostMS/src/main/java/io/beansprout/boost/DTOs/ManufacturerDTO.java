package io.beansprout.boost.DTOs;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ManufacturerDTO implements Serializable {
    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String link;
}
