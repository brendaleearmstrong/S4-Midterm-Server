package com.misight.repository;

import com.misight.model.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnvironmentalDataRepo extends JpaRepository<EnvironmentalData, Long> {
    List<EnvironmentalData> findByMineId(Long mineId);
    List<EnvironmentalData> findByMonitoringStationId(Long stationId);
    List<EnvironmentalData> findByPollutantId(Long pollutantId);
    List<EnvironmentalData> findByMeasurementDateBetween(LocalDateTime start, LocalDateTime end);
}