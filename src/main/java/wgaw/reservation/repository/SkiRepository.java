package wgaw.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wgaw.reservation.model.Ski;

import java.util.List;

@Repository
public interface SkiRepository extends JpaRepository<Ski, Long> {

    @Query("SELECT s FROM Ski s ORDER BY s.id ASC")
    List<Ski> findAllOrderByIdAsc();
}
