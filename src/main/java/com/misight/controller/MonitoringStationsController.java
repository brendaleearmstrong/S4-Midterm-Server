package com.misight.controller;

import com.misight.model.MonitoringStations;
import com.misight.model.Pollutants;
import com.misight.service.MonitoringStationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoringStations")
public class MonitoringStationsController {

    @Autowired
    private MonitoringStationsService service;

    @PostMapping
    public MonitoringStations createStation(@RequestBody MonitoringStations station) {
        return service.createStation(station);
    }

    @GetMapping
    public List<MonitoringStations> getAllStations() {
        return service.getAllStations();
    }

    @GetMapping("/{id}")
    public MonitoringStations getStationById(@PathVariable Long id) {
        return service.getStationById(id);
    }

    @PutMapping("/{id}")
    public MonitoringStations updateStation(@PathVariable Long id, @RequestBody MonitoringStations stationDetails) {
        return service.updateStation(id, stationDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id) {
        return service.deleteStation(id);
    }

    @GetMapping("/province/{provinceId}")
    public List<MonitoringStations> getStationsByProvince(@PathVariable Long provinceId) {
        return service.getStationsByProvince(provinceId);
    }

    @GetMapping("/location/{location}")
    public List<MonitoringStations> getStationsByLocation(@PathVariable String location) {
        return service.getStationsByLocation(location);
    }

    @PutMapping("/{stationId}/pollutants")
    public MonitoringStations updateStationPollutants(
            @PathVariable Long stationId, @RequestBody List<Long> pollutantIds) {
        return service.updateStationPollutants(stationId, pollutantIds);
    }

    @GetMapping("/{stationId}/pollutants")
    public List<Pollutants> getStationPollutants(@PathVariable Long stationId) {
        return service.getStationPollutants(stationId);
    }
}
