package io.beansprout.boost.services;

import io.beansprout.boost.DTOs.ManufacturerDTO;
import io.beansprout.boost.exceptions.ServiceErrorException;
import io.beansprout.boost.models.Turbo;

/**
 * CRUD for Turbo's Service Layer
 *
 * @author Kollier Martin
 * @date 1/6/2021
 */
public interface TurboService {
  ManufacturerDTO fetchManufacturer(String name) throws ServiceErrorException;

  Turbo findByNameAndSizeInMM(String name, Integer size) throws ServiceErrorException;

  Turbo findByName(String name) throws ServiceErrorException;

  Turbo findByManufacturer(String name) throws ServiceErrorException;

  Turbo findByRotation(Turbo.Rotation rotation) throws ServiceErrorException;
}
