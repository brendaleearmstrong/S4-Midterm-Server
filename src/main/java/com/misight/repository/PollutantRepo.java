package com.misight.repository;

import com.misight.model.Pollutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollutantRepo extends JpaRepository<Pollutant, Long> {
    boolean existsByNameIgnoreCase(String name);
}
