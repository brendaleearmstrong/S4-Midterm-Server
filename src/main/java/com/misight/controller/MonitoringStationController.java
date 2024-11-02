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
    public Optional<MonitoringStation> getStationById(@PathVariable("stationId") Integer stationId) {
        return stationService.getStationById(stationId);
    }

    @GetMapping("/province/{provinceId}")
    public List<MonitoringStation> getStationsByProvince(@PathVariable("provinceId") Integer provinceId) {
        return stationService.getStationsByProvince(provinceId);
    }

    @DeleteMapping("/{stationId}")
    public boolean deleteStation(@PathVariable("stationId") Integer stationId) {
        if (!stationService.findById(stationId).equals(Optional.empty())) {
            stationService.delStation(stationId);
            return true;
        }
        return false;
    }

    @PutMapping("/{stationId}")
    public MonitoringStation updateStation(@PathVariable("stationId") Integer stationId,
                                           @RequestBody Map<String, String> body) {
        MonitoringStation currentStation = stationService.getStationById(stationId).get();
        currentStation.setStationName(body.get("stationName"));
        currentStation.setLocation(body.get("location"));
        currentStation.setProvinceId(Integer.parseInt(body.get("provinceId")));

        stationService.addStation(currentStation);
        return currentStation;
    }
}