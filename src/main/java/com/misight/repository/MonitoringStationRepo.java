package com.misight.repository;

import com.misight.model.MonitoringStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MonitoringStationRepo extends JpaRepository<MonitoringStation, Long> {
    List<MonitoringStation> findByProvinceId(Long provinceId);
    boolean existsByStationName(String stationName);
}
