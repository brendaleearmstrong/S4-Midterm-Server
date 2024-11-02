package com.misight.controller;

import com.misight.model.EnvironmentalData;
import com.misight.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/environmental-data")
public class EnvironmentalDataController {

    private final EnvironmentalDataService environmentalDataService;

    @Autowired
    public EnvironmentalDataController(EnvironmentalDataService environmentalDataService) {
        this.environmentalDataService = environmentalDataService;
    }

    @GetMapping
    public ResponseEntity<List<EnvironmentalData>> getAllEnvironmentalData() {
        return ResponseEntity.ok(environmentalDataService.getAllEnvironmentalData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalData> getEnvironmentalDataById(@PathVariable Integer id) {
        return environmentalDataService.getEnvironmentalDataById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EnvironmentalData>> getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(environmentalDataService.getEnvironmentalDataByDate(date));
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<List<EnvironmentalData>> getByStation(@PathVariable Integer stationId) {
        return ResponseEntity.ok(environmentalDataService.getEnvironmentalDataByStation(stationId));
    }

    @GetMapping("/pollutant/{pollutantId}")
    public ResponseEntity<List<EnvironmentalData>> getByPollutant(@PathVariable Integer pollutantId) {
        return ResponseEntity.ok(environmentalDataService.getEnvironmentalDataByPollutant(pollutantId));
    }

    @PostMapping
    public ResponseEntity<EnvironmentalData> createEnvironmentalData(@RequestBody EnvironmentalData data) {
        return ResponseEntity.ok(environmentalDataService.createEnvironmentalData(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalData> updateEnvironmentalData(
            @PathVariable Integer id,
            @RequestBody EnvironmentalData data) {
        return environmentalDataService.updateEnvironmentalData(id, data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironmentalData(@PathVariable Integer id) {
        return environmentalDataService.deleteEnvironmentalData(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}