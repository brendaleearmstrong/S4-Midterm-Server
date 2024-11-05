package com.misight.repository;

import com.misight.model.Pollutants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollutantsRepo extends JpaRepository<Pollutants, Long> {
    List<Pollutants> findByNameIgnoreCase(String name);
    List<Pollutants> findByType(String type);
    List<Pollutants> findByMonitoringStationId(Long stationId);
}
