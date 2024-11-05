package com.misight.repository;

import com.misight.model.MonitoringStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringStationRepo extends JpaRepository<MonitoringStation, Long> {

}
