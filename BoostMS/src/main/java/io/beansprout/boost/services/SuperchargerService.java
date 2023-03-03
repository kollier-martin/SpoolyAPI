package io.beansprout.boost.services;

import io.beansprout.boost.DTOs.ManufacturerDTO;
import io.beansprout.boost.exceptions.ServiceErrorException;
import io.beansprout.boost.models.Supercharger;

/**
 * CRUD for Supercharger's Service Layer
 *
 * @author Kollier Martin
 * @date 1/6/2021
 */
public interface SuperchargerService {
  ManufacturerDTO fetchManufacturer(String name) throws ServiceErrorException;

  Supercharger findByName(String name);

  Supercharger findByManufacturer(String name);

  Supercharger findByRotation(Supercharger.Rotation rotation);
}
