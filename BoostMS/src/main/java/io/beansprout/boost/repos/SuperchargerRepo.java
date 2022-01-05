package io.beansprout.boost.repos;

import io.beansprout.boost.models.Supercharger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperchargerRepo extends JpaRepository<Supercharger, Integer> {
}
