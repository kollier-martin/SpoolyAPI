package io.beansprout.boost.repos;

import io.beansprout.boost.models.Turbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurboRepo extends JpaRepository<Turbo, Integer> {
}
