package io.beansprout.spooly.repos;

import io.beansprout.spooly.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManuRepo extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findByName(String name);
}