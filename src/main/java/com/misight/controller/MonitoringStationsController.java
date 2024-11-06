package com.misight.controller;

import com.misight.model.MonitoringStations;
import com.misight.service.MonitoringStationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monitoring-stations")
public class MonitoringStationsController {

    @Autowired
    private MonitoringStationsService monitoringStationsService;

    // Get all monitoring stations
    @GetMapping
    public List<MonitoringStations> getAllMonitoringStations() {
        return monitoringStationsService.getAllMonitoringStations();
    }

    // Get a monitoring station by ID
    @GetMapping("/{id}")
    public ResponseEntity<MonitoringStations> getMonitoringStationById(@PathVariable Long id) {
        Optional<MonitoringStations> station = monitoringStationsService.getMonitoringStationById(id);
        return station.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new monitoring station with a province association
    @PostMapping
    public ResponseEntity<MonitoringStations> createMonitoringStation(
            @RequestBody MonitoringStations station,
            @RequestParam Long provinceId) {
        MonitoringStations createdStation = monitoringStationsService.createMonitoringStation(station, provinceId);
        return ResponseEntity.ok(createdStation);
    }

    // Update an existing monitoring station by ID
    @PutMapping("/{id}")
    public ResponseEntity<MonitoringStations> updateMonitoringStation(
            @PathVariable Long id,
            @RequestBody MonitoringStations stationDetails,
            @RequestParam(required = false) Long provinceId) {
        try {
            MonitoringStations updatedStation = monitoringStationsService.updateMonitoringStation(id, stationDetails, provinceId);
            return ResponseEntity.ok(updatedStation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a monitoring station by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonitoringStation(@PathVariable Long id) {
        try {
            monitoringStationsService.deleteMonitoringStation(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
