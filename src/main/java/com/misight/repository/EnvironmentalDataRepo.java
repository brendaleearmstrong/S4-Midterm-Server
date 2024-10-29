package com.misight.repository;

import com.misight.model.EnvironmentalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnvironmentalDataRepo extends JpaRepository<EnvironmentalData, Integer> {
    List<EnvironmentalData> findByDate(LocalDate date);
    List<EnvironmentalData> findByStationId(Integer station_id);
    List<EnvironmentalData> findByPollutantId(Integer pollutant_id);
}