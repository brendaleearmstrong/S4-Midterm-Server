package com.misight.service;

import com.misight.model.MonitoringStations;
import com.misight.repository.MonitoringStationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitoringStationsService {

    @Autowired
    private MonitoringStationsRepo repo;

    public List<MonitoringStations> getAllStations() {
        return repo.findAll();
    }

    public MonitoringStations getStationById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public MonitoringStations createStation(MonitoringStations station) {
        return repo.save(station);
    }

    public MonitoringStations updateStation(Long id, MonitoringStations station) {
        station.setId(id);
        return repo.save(station);
    }

    public void deleteStation(Long id) {
        repo.deleteById(id);
    }
}
