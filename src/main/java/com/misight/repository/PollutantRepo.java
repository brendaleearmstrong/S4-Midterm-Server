package com.misight.repository;

import com.misight.model.Pollutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PollutantRepo extends JpaRepository<Pollutant, Integer> {
    Optional<Pollutant> findByPollutantName(String pollutant_name);
}