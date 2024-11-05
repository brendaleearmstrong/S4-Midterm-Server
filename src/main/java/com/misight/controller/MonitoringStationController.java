package com.misight.controller;

import com.misight.model.MonitoringStation;
import com.misight.service.MonitoringStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "*")
public class MonitoringStationController {
    private final MonitoringStationService stationService;

    @Autowired
    public MonitoringStationController(MonitoringStationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public ResponseEntity<List<MonitoringStation>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoringStation> getStationById(@PathVariable Long id) {
        return ResponseEntity.ok(stationService.getStationById(id));
    }

    @GetMapping("/province/{provinceId}")
    public ResponseEntity<List<MonitoringStation>> getStationsByProvince(@PathVariable Long provinceId) {
        return ResponseEntity.ok(stationService.getStationsByProvince(provinceId));
    }

    @PostMapping
    public ResponseEntity<MonitoringStation> createStation(@RequestBody MonitoringStation station) {
        return new ResponseEntity<>(stationService.createStation(station), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitoringStation> updateStation(
            @PathVariable Long id,
            @RequestBody MonitoringStation station) {
        return ResponseEntity.ok(stationService.updateStation(id, station));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}