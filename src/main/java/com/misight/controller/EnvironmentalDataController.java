package com.misight.controller;

import com.misight.model.EnvironmentalData;
import com.misight.service.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/environmental-data")
@CrossOrigin(origins = "*")
public class EnvironmentalDataController {
    private final EnvironmentalDataService environmentalDataService;

    @Autowired
    public EnvironmentalDataController(EnvironmentalDataService environmentalDataService) {
        this.environmentalDataService = environmentalDataService;
    }

    @GetMapping
    public ResponseEntity<List<EnvironmentalData>> getAllData() {
        return ResponseEntity.ok(environmentalDataService.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalData> getDataById(@PathVariable Long id) {
        return ResponseEntity.ok(environmentalDataService.getDataById(id));
    }

    @GetMapping("/station/{stationId}")
    public ResponseEntity<List<EnvironmentalData>> getDataByStation(@PathVariable Long stationId) {
        return ResponseEntity.ok(environmentalDataService.getDataByStation(stationId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<EnvironmentalData>> getDataByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(environmentalDataService.getDataByDateRange(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<EnvironmentalData> createData(@RequestBody EnvironmentalData data) {
        return new ResponseEntity<>(environmentalDataService.createData(data), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalData> updateData(
            @PathVariable Long id,
            @RequestBody EnvironmentalData data) {
        return ResponseEntity.ok(environmentalDataService.updateData(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        environmentalDataService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}