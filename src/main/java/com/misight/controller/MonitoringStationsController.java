package com.misight.controller;

import com.misight.model.MonitoringStations;
import com.misight.service.MonitoringStationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitoring-stations")
public class MonitoringStationsController {

    @Autowired
    private MonitoringStationsService service;

    @GetMapping
    public List<MonitoringStations> getAllStations() {
        return service.getAllStations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoringStations> getStationById(@PathVariable Long id) {
        MonitoringStations station = service.getStationById(id);
        return station != null ? ResponseEntity.ok(station) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MonitoringStations createStation(@RequestBody MonitoringStations station) {
        return service.createStation(station);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitoringStations> updateStation(@PathVariable Long id, @RequestBody MonitoringStations station) {
        MonitoringStations updatedStation = service.updateStation(id, station);
        return updatedStation != null ? ResponseEntity.ok(updatedStation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        service.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}
