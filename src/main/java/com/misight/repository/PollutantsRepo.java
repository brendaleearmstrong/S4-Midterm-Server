package com.misight.repository;

import com.misight.model.Pollutants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PollutantsRepo extends JpaRepository<Pollutants, Long> {
    List<Pollutants> findByCategory(String category);
    List<Pollutants> findByMeasurementFrequency(String frequency);
    Optional<Pollutants> findByName(String name);
    List<Pollutants> findByNameIgnoreCase(String name);
    boolean existsByName(String name);
}
