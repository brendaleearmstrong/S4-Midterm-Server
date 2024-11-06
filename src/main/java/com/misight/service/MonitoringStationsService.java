package com.misight.service;

import com.misight.model.MonitoringStations;
import com.misight.model.Provinces;
import com.misight.repository.MonitoringStationsRepo;
import com.misight.repository.ProvincesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoringStationsService {

    @Autowired
    private MonitoringStationsRepo monitoringStationsRepo;

    @Autowired
    private ProvincesRepo provincesRepo;

    public List<MonitoringStations> getAllMonitoringStations() {
        return monitoringStationsRepo.findAll();
    }

    public Optional<MonitoringStations> getMonitoringStationById(Long id) {
        return monitoringStationsRepo.findById(id);
    }

    public MonitoringStations createMonitoringStation(MonitoringStations station, Long provinceId) {
        Provinces province = provincesRepo.findById(provinceId)
                .orElseThrow(() -> new IllegalArgumentException("Province not found with id: " + provinceId));
        station.setProvince(province);
        return monitoringStationsRepo.save(station);
    }

    public MonitoringStations updateMonitoringStation(Long id, MonitoringStations stationDetails, Long provinceId) {
        MonitoringStations station = monitoringStationsRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Monitoring Station not found with id: " + id));

        station.setLocation(stationDetails.getLocation());
        station.setName(stationDetails.getName());

        // Update the province if a new provinceId is provided
        if (provinceId != null) {
            Provinces province = provincesRepo.findById(provinceId)
                    .orElseThrow(() -> new IllegalArgumentException("Province not found with id: " + provinceId));
            station.setProvince(province);
        }

        return monitoringStationsRepo.save(station);
    }

    public void deleteMonitoringStation(Long id) {
        monitoringStationsRepo.deleteById(id);
    }
}
