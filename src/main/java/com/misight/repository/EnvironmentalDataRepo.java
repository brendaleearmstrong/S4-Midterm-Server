package com.misight.repository;

import com.misight.model.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnvironmentalDataRepo extends JpaRepository<EnvironmentalData, Integer> {
    List<EnvironmentalData> findByDateRecorded(LocalDate date);
    List<EnvironmentalData> findByMonitoringStation_StationId(Integer stationId);
    List<EnvironmentalData> findByPollutant_PollutantId(Integer pollutantId);
}