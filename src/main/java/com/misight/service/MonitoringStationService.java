package com.misight.service;

import com.misight.exception.ResourceNotFoundException;
import com.misight.model.MonitoringStation;
import com.misight.repository.MonitoringStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringStationService {

    private final MonitoringStationRepo monitoringStationRepo;

    @Autowired
    public MonitoringStationService(MonitoringStationRepo monitoringStationRepo) {
        this.monitoringStationRepo = monitoringStationRepo;
    }

    public List<MonitoringStation> getAllStations() {
        return monitoringStationRepo.findAll();
    }

    public MonitoringStation getStationById(Long id) {
        return monitoringStationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitoring station not found with id: " + id));
    }

    public List<MonitoringStation> getStationsByProvince(Long provinceId) {
        return monitoringStationRepo.findByProvinceId(provinceId);
    }

    public MonitoringStation createStation(MonitoringStation station) {
        return monitoringStationRepo.save(station);
    }

    public MonitoringStation updateStation(Long id, MonitoringStation stationDetails) {
        MonitoringStation station = getStationById(id);
        station.setName(stationDetails.getName());
        station.setLocation(stationDetails.getLocation());
        station.setProvince(stationDetails.getProvince());
        return monitoringStationRepo.save(station);
    }

    public void deleteStation(Long id) {
        if (!monitoringStationRepo.existsById(id)) {
            throw new ResourceNotFoundException("Monitoring station not found with id: " + id);
        }
        monitoringStationRepo.deleteById(id);
    }
}