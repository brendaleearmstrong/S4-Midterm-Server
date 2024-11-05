package com.misight.service;

import com.misight.model.MonitoringStation;
import com.misight.repository.MonitoringStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoringStationService {

    private final MonitoringStationRepo monitoringStationRepo;

    @Autowired
    public MonitoringStationService(MonitoringStationRepo monitoringStationRepo) {
        this.monitoringStationRepo = monitoringStationRepo;
    }

    public List<MonitoringStation> findAll() {
        return monitoringStationRepo.findAll();
    }

    public Optional<MonitoringStation> findById(Long id) {
        return monitoringStationRepo.findById(id);
    }

    public MonitoringStation save(MonitoringStation monitoringStation) {
        return monitoringStationRepo.save(monitoringStation);
    }

    public void deleteById(Long id) {
        monitoringStationRepo.deleteById(id);
    }
}
