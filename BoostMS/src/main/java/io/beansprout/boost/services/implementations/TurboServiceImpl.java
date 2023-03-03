package io.beansprout.boost.services.implementations;

import io.beansprout.boost.DTOs.ManufacturerDTO;
import io.beansprout.boost.clients.MSClient;
import io.beansprout.boost.exceptions.ServiceErrorException;
import io.beansprout.boost.exceptions.ValidationCode;
import io.beansprout.boost.models.Turbo;
import io.beansprout.boost.repos.TurboRepo;
import io.beansprout.boost.services.TurboService;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Implementation of Turbo Service CRUD
 *
 * @author Kollier Martin
 * @date 1/6/2021
 */
@Service
public class TurboServiceImpl implements TurboService {
  private final TurboRepo repo;
  private final MSClient client;

  public TurboServiceImpl(TurboRepo repo, MSClient client) {
    this.repo = repo;
    this.client = client;
  }

  @Override
  public ManufacturerDTO fetchManufacturer(String name) throws ServiceErrorException {
    return client.getManufacturer(name);
  }

  @Override
  public Turbo findByNameAndSizeInMM(String name, Integer size) throws ServiceErrorException {
    Optional<Turbo> turbo = repo.findByNameAndSizeInMM(name, size);

    if (turbo.isPresent()) {
      return turbo.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }

  @Override
  public Turbo findByName(String name) throws ServiceErrorException {
    Optional<Turbo> turbo = repo.findByName(name);

    if (turbo.isPresent()) {
      return turbo.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }

  @Override
  public Turbo findByManufacturer(String name) {
    Optional<Turbo> turbo = repo.findByManufacturer(name);

    if (turbo.isPresent()) {
      return turbo.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }

  @Override
  public Turbo findByRotation(Turbo.Rotation rotation) {
    Optional<Turbo> turbo = repo.findByRotation(rotation);

    if (turbo.isPresent()) {
      return turbo.get();
    } else {
      throw new ServiceErrorException(ValidationCode.NOT_FOUND);
    }
  }
}
