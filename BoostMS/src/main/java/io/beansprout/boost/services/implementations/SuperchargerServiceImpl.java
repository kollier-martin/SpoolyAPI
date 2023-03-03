package io.beansprout.boost.services.implementations;

import io.beansprout.boost.DTOs.ManufacturerDTO;
import io.beansprout.boost.clients.MSClient;
import io.beansprout.boost.exceptions.ServiceErrorException;
import io.beansprout.boost.exceptions.ValidationCode;
import io.beansprout.boost.models.Supercharger;
import io.beansprout.boost.repos.SuperchargerRepo;
import io.beansprout.boost.services.SuperchargerService;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Implementation of Supercharger Service CRUD
 *
 * @author Kollier Martin
 * @date 1/6/2021
 */
@Service
public class SuperchargerServiceImpl implements SuperchargerService {
  private final SuperchargerRepo repo;
  private final MSClient client;

  public SuperchargerServiceImpl(SuperchargerRepo repo, MSClient client) {
    this.repo = repo;
    this.client = client;
  }

  @Override
  public ManufacturerDTO fetchManufacturer(String name) throws ServiceErrorException {
    return client.getManufacturer(name);
  }

  @Override
  public Supercharger findByName(String name) {
    Optional<Supercharger> supercharger = repo.findByName(name);

    if (supercharger.isPresent()) {
      return supercharger.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }

  @Override
  public Supercharger findByManufacturer(String name) {
    Optional<Supercharger> supercharger = repo.findByManufacturer(name);

    if (supercharger.isPresent()) {
      return supercharger.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }

  @Override
  public Supercharger findByRotation(Supercharger.Rotation rotation) {
    Optional<Supercharger> supercharger = repo.findByRotation(rotation);

    if (supercharger.isPresent()) {
      return supercharger.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }
}
