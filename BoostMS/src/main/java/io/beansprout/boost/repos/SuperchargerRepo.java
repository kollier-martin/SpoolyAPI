package io.beansprout.boost.repos;

import io.beansprout.boost.models.Supercharger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperchargerRepo extends JpaRepository<Supercharger, Integer> {
    Optional<Supercharger> findByName(String name);
    Optional<Supercharger> findByManufacturer(String name);
    Optional<Supercharger> findByRotation(Supercharger.Rotation rotation);
}
