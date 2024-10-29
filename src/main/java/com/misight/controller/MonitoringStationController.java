package com.misight.controller;

import com.misight.model.MonitoringStation;
import com.misight.service.MonitoringStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/stations")
public class MonitoringStationController {

    private final MonitoringStationService stationService;

    @Autowired
    public MonitoringStationController(MonitoringStationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<MonitoringStation> createStation(@RequestBody MonitoringStation station) {
        MonitoringStation addedStation = stationService.addStation(station);
        return new ResponseEntity<>(addedStation, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MonitoringStation> getStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{stationId}")
    public ResponseEntity<MonitoringStation> getStationById(@PathVariable Integer stationId) {
        return stationService.getStationById(stationId)
                .map(station -> new ResponseEntity<>(station, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/province/{provinceId}")
    public List<MonitoringStation> getStationsByProvince(@PathVariable Integer provinceId) {
        return stationService.getStationsByProvince(provinceId);
    }

    @PutMapping("/{stationId}")
    public ResponseEntity<MonitoringStation> updateStation(
            @PathVariable Integer stationId,
            @RequestBody MonitoringStation updatedStation) {
        return stationService.getStationById(stationId)
                .map(currentStation -> {
                    currentStation.setStationName(updatedStation.getStationName());
                    currentStation.setLocation(updatedStation.getLocation());
                    currentStation.setProvince(updatedStation.getProvince());
                    MonitoringStation saved = stationService.addStation(currentStation);
                    return new ResponseEntity<>(saved, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{stationId}")
    public ResponseEntity<Void> deleteStation(@PathVariable Integer stationId) {
        if (stationService.getStationById(stationId).isPresent()) {
            stationService.deleteStation(stationId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}