package com.misight.service;

import com.misight.model.MonitoringStation;
import com.misight.repository.MonitoringStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoringStationService {
    private final MonitoringStationRepo stationRepo;

    @Autowired
    public MonitoringStationService(MonitoringStationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public MonitoringStation addStation(MonitoringStation station) {
        return stationRepo.save(station);
    }

    public List<MonitoringStation> getAllStations() {
        return stationRepo.findAll();
    }

    public Optional<MonitoringStation> getStationById(Integer stationId) {
        return stationRepo.findById(stationId);
    }

    public List<MonitoringStation> getStationsByProvince(Integer provinceId) {
        return stationRepo.findByProvinceProvinceId(provinceId);
    }

    public void deleteStation(Integer stationId) {
        stationRepo.deleteById(stationId);
    }
}