package io.beansprout.spooly.services.implementations;

import io.beansprout.spooly.models.Manufacturer;
import io.beansprout.spooly.repos.ManuRepo;
import io.beansprout.spooly.services.ManuService;
import org.springframework.stereotype.Service;

@Service
public class ManuServiceImpl implements ManuService {
  private final ManuRepo repo;

  public ManuServiceImpl(ManuRepo repo) {
    this.repo = repo;
  }

  @Override
  public Manufacturer findByName(String name) {
    return repo.findByName(name);
  }
}
