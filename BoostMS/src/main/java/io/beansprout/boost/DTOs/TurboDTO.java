package io.beansprout.boost.DTOs;

import io.beansprout.boost.models.Turbo;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TurboDTO implements Serializable {
  @NotNull private Integer id;

  @NotNull private String name;

  @NotNull private Integer hpMin;

  @NotNull private Integer hpMax;

  @NotNull private Integer psi;

  @NotNull private String manufacturer;

  @NotNull private String link;

  @NotNull private String displacement;

  @NotNull private Turbo.Compressor compressor;

  @NotNull private Turbo.Turbine turbine;

  @NotNull private Turbo.Rotation rotation;

  public static TurboDTO convert(Turbo turbo) {
    TurboDTO turboDTO = new TurboDTO();

    turboDTO.setId(turbo.getId());
    turboDTO.setName(turbo.getName());
    turboDTO.setHpMin(turbo.getHpMin());
    turboDTO.setHpMax(turbo.getHpMax());
    turboDTO.setPsi(turbo.getPsi());
    turboDTO.setManufacturer(turbo.getManufacturer());
    turboDTO.setLink(turbo.getLink());
    turboDTO.setDisplacement(turbo.getDisplacement());
    turboDTO.setCompressor(turbo.getCompressor());
    turboDTO.setTurbine(turbo.getTurbine());
    turboDTO.setRotation(turbo.getRotation());

    return turboDTO;
  }
}
