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

    @GetMapping("/{station_id}")
    public Optional<MonitoringStation> getStationById(@PathVariable("station_id") Integer station_id) {
        return stationService.getStationById(station_id);
    }

    @GetMapping("/province/{province_id}")
    public List<MonitoringStation> getStationsByProvince(@PathVariable("province_id") Integer province_id) {
        return stationService.getStationsByProvince(province_id);
    }

    @DeleteMapping("/{station_id}")
    public boolean deleteStation(@PathVariable("station_id") Integer station_id) {
        if (!stationService.findById(station_id).equals(Optional.empty())) {
            stationService.delStation(station_id);
            return true;
        }
        return false;
    }

    @PutMapping("/{station_id}")
    public MonitoringStation updateStation(@PathVariable("station_id") Integer station_id,
                                           @RequestBody Map<String, String> body) {
        MonitoringStation currentStation = stationService.getStationById(station_id).get();
        currentStation.setStation_name(body.get("station_name"));
        currentStation.setLocation(body.get("location"));
        currentStation.setProvince_id(Integer.parseInt(body.get("province_id")));

        stationService.addStation(currentStation);
        return currentStation;
    }
}