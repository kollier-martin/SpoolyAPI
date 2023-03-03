package io.beansprout.boost.models;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperchargerDTO implements Serializable {
  @NotNull private Integer id;

  @NotNull private String name;

  @NotNull private String link;

  @NotNull private String manufacturer;

  @NotNull private Float housingDiameter;

  @NotNull private Integer hpMax;

  @NotNull private Integer baseHpMin;

  @NotNull private Integer baseHpMax;

  @NotNull private Integer maxFlow;

  @NotNull private Integer psi;

  @NotNull private Float inletHoseDiameter;

  @NotNull private Float inducerDiameter;

  @NotNull private Float exducerDiameter;

  @NotNull private Float outletHoseDiameter;

  @NotNull private Float outletID;

  @NotNull private Integer maxImpellerRPM;

  @NotNull private String internalStepUpRatio;

  @NotNull private Supercharger.Rotation rotation;

  @NotNull private Boolean selfContainedOil;

  @NotNull private Float oilCapacity;

  public static SuperchargerDTO convert(Supercharger supercharger) {
    SuperchargerDTO superchargerDTO = new SuperchargerDTO();

    superchargerDTO.setId(supercharger.getId());
    superchargerDTO.setName(supercharger.getName());
    superchargerDTO.setBaseHpMax(supercharger.getBaseHpMax());
    superchargerDTO.setBaseHpMin(supercharger.getBaseHpMin());
    superchargerDTO.setPsi(supercharger.getPsi());
    superchargerDTO.setManufacturer(supercharger.getManufacturer());
    superchargerDTO.setLink(supercharger.getLink());
    superchargerDTO.setExducerDiameter(supercharger.getExducerDiameter());
    superchargerDTO.setInducerDiameter(supercharger.getInducerDiameter());
    superchargerDTO.setHousingDiameter(supercharger.getHousingDiameter());
    superchargerDTO.setRotation(supercharger.getRotation());
    superchargerDTO.setInletHoseDiameter(supercharger.getInletHoseDiameter());
    superchargerDTO.setOutletHoseDiameter(supercharger.getOutletHoseDiameter());
    superchargerDTO.setInternalStepUpRatio(supercharger.getInternalStepUpRatio());
    superchargerDTO.setMaxFlow(supercharger.getMaxFlow());
    superchargerDTO.setOilCapacity(supercharger.getOilCapacity());
    superchargerDTO.setOutletID(superchargerDTO.getOutletID());
    superchargerDTO.setSelfContainedOil(supercharger.getSelfContainedOil());
    superchargerDTO.setMaxImpellerRPM(supercharger.getMaxImpellerRPM());

    return superchargerDTO;
  }
}
