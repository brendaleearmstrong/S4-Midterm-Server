package com.misight.repository;

import com.misight.model.MonitoringStations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitoringStationsRepo extends JpaRepository<MonitoringStations, Long> {
    List<MonitoringStations> findByProvinceId(Long provinceId);
    List<MonitoringStations> findByLocation(String location);
}
