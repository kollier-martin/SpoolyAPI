package io.beansprout.boost.repos;

import io.beansprout.boost.models.Turbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurboRepo extends JpaRepository<Turbo, Integer> {
    Optional<Turbo> findByName(String name);
    Optional<Turbo> findByNameAndSizeInMM(String name, Integer size);
    Optional<Turbo> findByManufacturer(String name);
    Optional<Turbo> findByRotation(Turbo.Rotation rotation);
}
