package com.misight.repository;

import com.misight.model.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnvironmentalDataRepo extends JpaRepository<EnvironmentalData, Long> {
    List<EnvironmentalData> findByMonitoringStationId(Long stationId);
    List<EnvironmentalData> findByDateRecordedBetween(LocalDate startDate, LocalDate endDate);
}
