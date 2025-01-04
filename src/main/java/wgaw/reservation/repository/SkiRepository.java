package wgaw.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wgaw.reservation.model.Ski;

@Repository
public interface SkiRepository extends JpaRepository<Ski, Long> {
}
