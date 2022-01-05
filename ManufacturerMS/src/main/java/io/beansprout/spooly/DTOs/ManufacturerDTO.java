package io.beansprout.spooly.DTOs;

import io.beansprout.spooly.models.Manufacturer;
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

    /**
     * Converts Entity into DTO
     * @param manufacturer Manufacturer entity to convert to a DTO
     * @return ManufacturerDTO
     */
    public static ManufacturerDTO convert(Manufacturer manufacturer) {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();

        manufacturerDTO.setId(manufacturer.getId());
        manufacturerDTO.setLink(manufacturer.getLink());
        manufacturerDTO.setName(manufacturer.getName());

        return manufacturerDTO;
    }
}
